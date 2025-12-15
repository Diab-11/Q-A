package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import se.jumomo24wv.menuactivity.data.QuizData
import se.jumomo24wv.menuactivity.data.QuizDataSV
import se.jumomo24wv.menuactivity.data.QuizQuestion
import se.jumomo24wv.menuactivity.databinding.ActivityMainGameBinding
import se.jumomo24wv.menuactivity.data.NoWordData
import se.jumomo24wv.menuactivity.data.NoWordQuestion
import se.jumomo24wv.menuactivity.data.NoWordDataSV

import androidx.activity.addCallback
import se.jumomo24wv.menuactivity.data.LanguageManager

private const val SCORE_START = 0
private const val RESOURCE_NOT_FOUND = 0

private const val LOADING_PULSE_DURATION_MS = 900L

private const val BOARD_INTRO_DURATION_IN_MS = 120L
private const val BOARD_INTRO_RETURN_DURATION_MS = 180L
private const val BONUS_TILE_ANIM_DURATION_MS = 220L

private const val TEAM_A_STARTS = true

private const val EMPTY = ""

private const val EXTRA_TEAM_A_POINTS_GAINED = "TEAM_A_POINTS_GAINED"
private const val EXTRA_TEAM_B_POINTS_GAINED = "TEAM_B_POINTS_GAINED"
private const val EXTRA_ANSWERED_QUESTION_ID = "ANSWERED_QUESTION_ID"
private const val SCALE_START = 1f
private const val SCALE_PULSE = 1.08f

private const val BOARD_INTRO_SCALE = 0.96f
private const val BOARD_INTRO_ALPHA = 0.7f

private const val BONUS_TILE_START_SCALE = 0.85f
private const val ALPHA_ZERO = 0f
private const val ALPHA_FULL = 1f


class MainGame : AppCompatActivity() {

    private lateinit var binding: ActivityMainGameBinding
    private var teamAScore = 0
    private var teamBScore = 0
    private var teamAName: String? = null
    private var teamBName: String? = null
    private var isTeamATurn = TEAM_A_STARTS // Team A starts

    // Current game state
    private val gameQuestions = mutableMapOf<String, QuizQuestion>()
    private val answeredQuestions = mutableSetOf<String>()
    private val usedBonusButtons = mutableSetOf<String>()
    private val presentedQuestions = mutableSetOf<QuizQuestion>() // Tracks all questions shown to user
    private val answeredNoWordQuestions = mutableSetOf<String>()

    // State for bonus round
    private var isBonusMode = false
    private val preBonusAnsweredQuestions = mutableSetOf<String>()
    private val preBonusGameQuestions = mutableMapOf<String, QuizQuestion>()
    private var loadingAnimator: android.animation.ObjectAnimator? = null



    private fun showLoadingPulse(message: String = getString(R.string.loading_default)) {
        binding.loadingText.text = message
        binding.loadingOverlay.visibility = View.VISIBLE

        if (loadingAnimator?.isRunning == true) return

        loadingAnimator = android.animation.ObjectAnimator.ofFloat(
            binding.loadingLogo,
            View.SCALE_X,
            SCALE_START,
            SCALE_PULSE,
            SCALE_START
        ).apply {
            duration = LOADING_PULSE_DURATION_MS
            repeatCount = android.animation.ValueAnimator.INFINITE
            repeatMode = android.animation.ValueAnimator.RESTART
        }

        // vi vill pulse på både X och Y
        val scaleYAnimator = android.animation.ObjectAnimator.ofFloat(
            binding.loadingLogo,
            View.SCALE_Y,
            SCALE_START,
            SCALE_PULSE,
            SCALE_START
        ).apply {
            duration = LOADING_PULSE_DURATION_MS
            repeatCount = android.animation.ValueAnimator.INFINITE
            repeatMode = android.animation.ValueAnimator.RESTART
        }

        loadingAnimator?.start()
        scaleYAnimator.start()

        // spara Y-animator också så vi kan stoppa båda
        binding.loadingLogo.tag = scaleYAnimator
    }

    private fun hideLoadingPulse() {
        binding.loadingOverlay.visibility = View.GONE

        loadingAnimator?.cancel()
        loadingAnimator = null

        val yAnim = binding.loadingLogo.tag as? android.animation.ObjectAnimator
        yAnim?.cancel()
        binding.loadingLogo.tag = null

        binding.loadingLogo.scaleX = SCALE_START
        binding.loadingLogo.scaleY = SCALE_START
    }
    private fun playBonusRoundIntroAnimation() {
        val board = binding.main

        board.animate()
            .scaleX(BOARD_INTRO_SCALE)
            .scaleY(BOARD_INTRO_SCALE)
            .alpha(BOARD_INTRO_ALPHA)
            .setDuration(BOARD_INTRO_DURATION_IN_MS)
            .withEndAction {
                board.animate()
                    .scaleX(SCALE_START)
                    .scaleY(SCALE_START)
                    .alpha(ALPHA_FULL)
                    .setDuration(BOARD_INTRO_RETURN_DURATION_MS)
                    .start()
            }
            .start()
    }
    private val questionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        hideLoadingPulse()
        val wasInBonusMode = isBonusMode
        if (isBonusMode) {
            isBonusMode = false // Exit bonus mode immediately
        }


        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val teamAPointsGained = data?.getIntExtra(EXTRA_TEAM_A_POINTS_GAINED, SCORE_START) ?: SCORE_START
            val teamBPointsGained = data?.getIntExtra(EXTRA_TEAM_B_POINTS_GAINED, SCORE_START) ?: SCORE_START
            teamAScore += teamAPointsGained
            teamBScore += teamBPointsGained
            updateScores()

            val answeredQuestionId = data?.getStringExtra(EXTRA_ANSWERED_QUESTION_ID)

            if (wasInBonusMode) {
                gameQuestions.clear()
                gameQuestions.putAll(preBonusGameQuestions)
                answeredQuestions.clear()
                answeredQuestions.addAll(preBonusAnsweredQuestions)

                if (answeredQuestionId != null) {
                    answeredQuestions.add(answeredQuestionId)
                }
            } else {
                if (answeredQuestionId != null) {
                    answeredQuestions.add(answeredQuestionId)
                }
            }
            // Switch turns only after a question is successfully answered.
            isTeamATurn = !isTeamATurn
        }

        // After any round (bonus or normal, completed or cancelled), refresh the visual state of the board.
        restoreBoardState()
        updateTurnHighlight()
        checkGameOver()
    }
    private val noWordLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            hideLoadingPulse()
            val wasInNoWordBonusMode = isBonusMode
            if (isBonusMode) {
                isBonusMode = false // Exit bonus mode immediately
            }
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val teamAPoints = data?.getIntExtra("TEAM_A_POINTS_GAINED", 0) ?: 0
                val teamBPoints = data?.getIntExtra("TEAM_B_POINTS_GAINED", 0) ?: 0
                val answeredQuestionId = data?.getStringExtra("ANSWERED_QUESTION_ID")

                if (wasInNoWordBonusMode) {
                    // Restore pre-bonus state for no-word questions
                    answeredNoWordQuestions.clear()
                    answeredNoWordQuestions.addAll(preBonusAnsweredQuestions)
                    if (answeredQuestionId != null) {
                        answeredNoWordQuestions.add(answeredQuestionId)
                    }
                    // Restore other questions
                    gameQuestions.clear()
                    gameQuestions.putAll(preBonusGameQuestions)
                    answeredQuestions.clear()
                    answeredQuestions.addAll(preBonusAnsweredQuestions.filter { !it.startsWith("no_word") })

                } else {
                    if (answeredQuestionId != null) {
                        answeredNoWordQuestions.add(answeredQuestionId)
                    }
                }

                teamAScore += teamAPoints
                teamBScore += teamBPoints
                updateScores()
                restoreBoardState()
                // byt tur efter avslutad no-word-runda
                isTeamATurn = !isTeamATurn
                updateTurnHighlight()
                checkGameOver()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGameBinding.inflate(layoutInflater)

        onBackPressedDispatcher.addCallback(this) { showExitWarning() }

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        teamAName = intent.getStringExtra(CreateGame.ARG_TXT1)
        teamBName = intent.getStringExtra(CreateGame.ARG_TXT2)

        binding.mainGameTeam1.text = teamAName ?: EMPTY
        binding.mainGameTeam2.text = teamBName ?: EMPTY

        updateScores()
        initializeNewGame()
        setupBonusButtonClickListeners()
        setupNoWordClickListeners()
        restoreBoardState()
        updateTurnHighlight()
    }

    private fun updateTurnHighlight() {
        if (isTeamATurn) {
            binding.mainGameTeam1.setTextColor(Color.YELLOW)
            binding.mainGameTeam1Score.setTextColor(Color.YELLOW)
            binding.mainGameTeam2.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            binding.mainGameTeam2Score.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        } else {
            binding.mainGameTeam1.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            binding.mainGameTeam1Score.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            binding.mainGameTeam2.setTextColor(Color.YELLOW)
            binding.mainGameTeam2Score.setTextColor(Color.YELLOW)
        }
    }


    private fun triggerBonusRound(category: String, bonusButtonId: String) {
        if (isBonusMode || usedBonusButtons.contains(bonusButtonId)) return

        isBonusMode = true
        usedBonusButtons.add(bonusButtonId)

        // 🔥 Intro animation (din)
        playBonusRoundIntroAnimation()

        // Spara state före bonus
        preBonusGameQuestions.clear()
        preBonusGameQuestions.putAll(gameQuestions)
        preBonusAnsweredQuestions.clear()
        preBonusAnsweredQuestions.addAll(answeredQuestions)

        // Ladda om frågor för vald kategori
        refreshCategoryQuestions(category)

        // Fasta knapp-id:n för kategorin
        val allowedQuestionIds = when (category) {
            "Cars" -> listOf("cars_200", "cars_400", "cars_600")
            "Common Knowledge" -> listOf("common_knowledge_200", "common_knowledge_400", "common_knowledge_600")
            "Sports" -> listOf("sports_200", "sports_400", "sports_600")
            "Geography" -> listOf("geography_200", "geography_400", "geography_600")
            "Flags and Countries" -> listOf("flags_countries_200", "flags_countries_400", "flags_countries_600")
            else -> emptyList()
        }

        // ✅ VIKTIGT: gör rutorna klickbara i bonus genom att ta bort dem från answeredQuestions
        answeredQuestions.removeAll(allowedQuestionIds.toSet())

        // Aktivera endast bonus-kategorins tre rutor, disable resten
        val allowedSet = allowedQuestionIds.toSet()
        for (buttonId in gameQuestions.keys) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                val button = findViewById<View>(resId)
                if (allowedSet.contains(buttonId)) {
                    button.isEnabled = true
                    (button as? MaterialButton)
                        ?.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
                } else {
                    button.isEnabled = false
                }
            }
        }

        // (valfritt) Poppa in de tre bonusrutorna
        for (buttonId in allowedQuestionIds) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                val b = findViewById<MaterialButton>(resId)
                b.scaleX = BONUS_TILE_START_SCALE
                b.scaleY = BONUS_TILE_START_SCALE
                b.alpha = ALPHA_ZERO
                b.animate().alpha(ALPHA_FULL).scaleX(ALPHA_FULL).scaleY(ALPHA_FULL).setDuration(BONUS_TILE_ANIM_DURATION_MS).start()
            }
        }

        // Disable bonus-knapparna under bonusrundan
        setAllBonusButtonsEnabled(false)
        binding.noWordBonus.isEnabled = false
    }



    private fun triggerNoWordBonusRound(bonusButtonId: String) {
        if (isBonusMode || usedBonusButtons.contains(bonusButtonId)) return

        isBonusMode = true
        usedBonusButtons.add(bonusButtonId)

        playBonusRoundIntroAnimation()

        // Save state
        preBonusGameQuestions.clear()
        preBonusGameQuestions.putAll(gameQuestions)
        preBonusAnsweredQuestions.clear()
        preBonusAnsweredQuestions.addAll(answeredQuestions)
        // Also save no word answered questions
        preBonusAnsweredQuestions.addAll(answeredNoWordQuestions)


        // Refresh "No Word" questions for bonus round (re-enable them)
        answeredNoWordQuestions.clear()
        restoreBoardState() // this will re-enable the no word buttons

        // Disable all other categories
        for ((buttonId, question) in gameQuestions) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                findViewById<View>(resId).isEnabled = false
            }
        }
        setAllBonusButtonsEnabled(false) // disable other bonus buttons
    }

    private fun refreshCategoryQuestions(category: String) {


        val flagsEasy = if (LanguageManager.isSwedish(this)) QuizDataSV.flagsEasy else QuizData.flagsEasy
        val flagsMedium = if (LanguageManager.isSwedish(this)) QuizDataSV.flagsMedium else QuizData.flagsMedium
        val flagsHard = if (LanguageManager.isSwedish(this)) QuizDataSV.flagsHard else QuizData.flagsHard

        val geographyEasy = if (LanguageManager.isSwedish(this)) QuizDataSV.geographyEasy else QuizData.geographyEasy
        val geographyMedium = if (LanguageManager.isSwedish(this)) QuizDataSV.geographyMedium else QuizData.geographyMedium
        val geographyHard = if (LanguageManager.isSwedish(this)) QuizDataSV.geographyHard else QuizData.geographyHard

        val carsEasy = if (LanguageManager.isSwedish(this)) QuizDataSV.carsEasy else QuizData.carsEasy
        val carsMedium = if (LanguageManager.isSwedish(this)) QuizDataSV.carsMedium else QuizData.carsMedium
        val carsHard = if (LanguageManager.isSwedish(this)) QuizDataSV.carsHard else QuizData.carsHard

        val commonKnowledgeEasy = if (LanguageManager.isSwedish(this)) QuizDataSV.commonKnowledgeEasy else QuizData.commonKnowledgeEasy
        val commonKnowledgeMedium = if (LanguageManager.isSwedish(this)) QuizDataSV.commonKnowledgeMedium else QuizData.commonKnowledgeMedium
        val commonKnowledgeHard = if (LanguageManager.isSwedish(this)) QuizDataSV.commonKnowledgeHard else QuizData.commonKnowledgeHard

        val sportsEasy = if (LanguageManager.isSwedish(this)) QuizDataSV.sportsEasy else QuizData.sportsEasy
        val sportsMedium = if (LanguageManager.isSwedish(this)) QuizDataSV.sportsMedium else QuizData.sportsMedium
        val sportsHard = if (LanguageManager.isSwedish(this)) QuizDataSV.sportsHard else QuizData.sportsHard
        fun updateQuestion(buttonId: String, questionPool: List<QuizQuestion>) {
            val newQuestion = questionPool.filter { it !in presentedQuestions }.randomOrNull()
            val questionToUse = newQuestion ?: questionPool.random() // Fallback to any random question if uniques run out

            gameQuestions[buttonId] = questionToUse
            presentedQuestions.add(questionToUse) // Track all presented questions to ensure uniqueness
        }

        when (category) {

            "Flags and Countries" -> {
                updateQuestion("flags_countries_200", flagsEasy)
                updateQuestion("flags_countries_400", flagsMedium)
                updateQuestion("flags_countries_600", flagsHard)
            }
            "Geography" -> {
                updateQuestion("geography_200", geographyEasy)
                updateQuestion(
                    "geography_400",
                    QuizData.geographyMedium
                )
                updateQuestion("geography_600", geographyHard)
            }
            "Cars" -> {
                updateQuestion("cars_200", carsEasy)
                updateQuestion("cars_400", carsMedium)
                updateQuestion("cars_600", carsHard)
            }
            "Common Knowledge" -> {
                updateQuestion("common_knowledge_200", commonKnowledgeEasy)
                updateQuestion("common_knowledge_400", commonKnowledgeMedium)
                updateQuestion("common_knowledge_600", commonKnowledgeHard)
            }
            "Sports" -> {
                updateQuestion("sports_200", sportsEasy)
                updateQuestion("sports_400", sportsMedium)
                updateQuestion("sports_600", sportsHard)
            }
        }
    }

    private fun restoreBoardState() {
        val unlockAllBonusesNow = isAllMainQuestionsDone()

        for (buttonId in gameQuestions.keys) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                val button = findViewById<View>(resId)
                if (answeredQuestions.contains(buttonId)) {
                    button.isEnabled = false
                    button.setBackgroundColor(Color.GRAY)
                } else {
                    button.isEnabled = true
                    (button as? MaterialButton)?.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
                }
            }
        }


        val bonusRules = listOf(
            Pair(binding.carsBonus, "cars_bonus"),
            Pair(binding.commonKnowledgeBonus, "common_knowledge_bonus"),
            Pair(binding.sportsBonus, "sports_bonus"),
            Pair(binding.geographyBonus, "geography_bonus"),
            Pair(binding.flagsCountriesBonus, "flags_countries_bonus"),
        )

        for ((button, bonusId) in bonusRules) {
            if (usedBonusButtons.contains(bonusId)) {
                button.isEnabled = false
                button.setBackgroundColor(Color.GRAY)
            } else {
                button.isEnabled = unlockAllBonusesNow
                button.setBackgroundColor(
                    if (unlockAllBonusesNow)
                        ContextCompat.getColor(this, R.color.ripplePrimary)
                    else
                        Color.GRAY
                )
            }
        }

        val noWordButtons = listOf("no_word_200", "no_word_400", "no_word_600")
        for (buttonId in noWordButtons) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                val button = findViewById<View>(resId)
                if (answeredNoWordQuestions.contains(buttonId)) {
                    button.isEnabled = false
                    button.setBackgroundColor(Color.GRAY)
                } else {
                    button.isEnabled = true
                    (button as? MaterialButton)?.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
                }
            }
        }

        binding.noWordBonus.isEnabled = unlockAllBonusesNow && !usedBonusButtons.contains("no_word_bonus")
        binding.noWordBonus.setBackgroundColor(
            if (binding.noWordBonus.isEnabled)
                ContextCompat.getColor(this, R.color.ripplePrimary)
            else
                Color.GRAY
        )

    }

    private fun initializeNewGame() {
        presentedQuestions.clear()
        refreshCategoryQuestions("Flags and Countries")
        refreshCategoryQuestions("Geography")
        refreshCategoryQuestions("Cars")
        refreshCategoryQuestions("Common Knowledge")
        refreshCategoryQuestions("Sports")
    }

    private fun setupButtonClickListeners() {
        for (buttonId in gameQuestions.keys) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                findViewById<View>(resId).setOnClickListener {
                    openQuestion(buttonId)
                }
            }
        }
    }

    private fun setAllBonusButtonsEnabled(enabled: Boolean) {
        // This function is now only for disabling buttons during a bonus round.
        // The main logic is in restoreBoardState.
        if (!enabled) {
            binding.carsBonus.isEnabled = false
            binding.commonKnowledgeBonus.isEnabled = false
            binding.sportsBonus.isEnabled = false
            binding.geographyBonus.isEnabled = false
            binding.flagsCountriesBonus.isEnabled = false
        }
    }

    private fun setupBonusButtonClickListeners() {
        binding.carsBonus.setOnClickListener { triggerBonusRound("Cars", "cars_bonus") }
        binding.commonKnowledgeBonus.setOnClickListener { triggerBonusRound("Common Knowledge", "common_knowledge_bonus") }
        binding.sportsBonus.setOnClickListener { triggerBonusRound("Sports", "sports_bonus") }
        binding.geographyBonus.setOnClickListener { triggerBonusRound("Geography", "geography_bonus") }
        binding.flagsCountriesBonus.setOnClickListener { triggerBonusRound("Flags and Countries", "flags_countries_bonus") }

        binding.noWordBonus.setOnClickListener {
            triggerNoWordBonusRound("no_word_bonus")
        }
    }

    private fun openQuestion(questionId: String) {
        val question = gameQuestions[questionId]
        if (question != null) {
            val intent = Intent(this, QuestionViewActivity::class.java).apply {
                putExtra("QUESTION", question)
                putExtra("TEAM_A_SCORE", teamAScore)
                putExtra("TEAM_B_SCORE", teamBScore)
                putExtra("TEAM_A_NAME", teamAName)
                putExtra("TEAM_B_NAME", teamBName)
                putExtra("QUESTION_ID", questionId)
                putExtra("IS_TEAM_A_TURN", isTeamATurn)
            }
            showLoadingPulse("Loading question...")
            questionLauncher.launch(intent)
        }
    }

    private fun openNoWordQr(list: List<NoWordQuestion>, questionId: String) {
        if (list.isEmpty()) {
            Toast.makeText(this, "No No-Word cards configured yet.", Toast.LENGTH_SHORT).show()
            return
        }

        val card = list.random()  // plockar ett slumpat NoWordQuestion

        val intent = Intent(this, NoWordQrActivity::class.java).apply {
            putExtra("NO_WORD_URL", card.url)
            putExtra("NO_WORD_POINTS", card.points)
            putExtra("NO_WORD_ANSWER", card.answer)
            putExtra("TEAM_A_NAME", teamAName)
            putExtra("TEAM_B_NAME", teamBName)
            putExtra("ANSWERED_QUESTION_ID", questionId)
        }
        showLoadingPulse("Loading question...")
        noWordLauncher.launch(intent)
    }


    private var gameOverTriggered = false

    private fun checkGameOver() {
        if (gameOverTriggered) return

        // 1) Vänta tills alla vanliga frågor + no word är klara
        if (!isAllMainQuestionsDone()) return

        // 2) När allt är klart, måste alla bonusar användas innan Winner
        val allBonusIds = setOf(
            "cars_bonus",
            "common_knowledge_bonus",
            "sports_bonus",
            "geography_bonus",
            "flags_countries_bonus",
            "no_word_bonus"
        )

        val allBonusesUsed = usedBonusButtons.containsAll(allBonusIds)
        if (!allBonusesUsed) {
            Toast.makeText(this, "Bonus rounds remaining! Use them before finishing.", Toast.LENGTH_SHORT).show()
            return
        }

        // 3) Nu avslutar vi
        gameOverTriggered = true

        val winnerName: String
        val winnerScore: Int
        if (teamAScore > teamBScore) {
            winnerName = teamAName ?: "Team A"
            winnerScore = teamAScore
        } else if (teamBScore > teamAScore) {
            winnerName = teamBName ?: "Team B"
            winnerScore = teamBScore
        } else {
            winnerName = "It's a tie!"
            winnerScore = teamAScore
        }

        val intent = Intent(this, WinnerActivity::class.java).apply {
            putExtra("WINNER_NAME", winnerName)
            putExtra("WINNER_SCORE", winnerScore)
        }
        startActivity(intent)
        finish()
    }







    private fun setupNoWordClickListeners() {
        val noWord200 =
            if (LanguageManager.isSwedish(this))
                NoWordDataSV.noWord200
            else
                NoWordData.noWord200
        val noWord400 =
            if (LanguageManager.isSwedish(this))
                NoWordDataSV.noWord400
            else
                NoWordData.noWord400
        val noWord600 =
            if (LanguageManager.isSwedish(this))
                NoWordDataSV.noWord600
            else
                NoWordData.noWord600

        binding.noWord200.setOnClickListener {
            openNoWordQr(noWord200, "no_word_200")
        }
        binding.noWord400.setOnClickListener {
            openNoWordQr(noWord400, "no_word_400")
        }
        binding.noWord600.setOnClickListener {
            openNoWordQr(noWord600, "no_word_600")
        }
    }

    private fun isAllMainQuestionsDone(): Boolean {
        val allRegularAnswered = answeredQuestions.size == gameQuestions.size
        val allNoWordAnswered = answeredNoWordQuestions.containsAll(
            listOf("no_word_200", "no_word_400", "no_word_600")
        )
        return allRegularAnswered && allNoWordAnswered
    }

    private fun showExitWarning() {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(R.string.dialog_leave_match_title)
            .setMessage(R.string.dialog_leave_match_message)
            .setPositiveButton(R.string.dialog_leave_match_positive) { _, _ -> finish() }
            .setNegativeButton(R.string.dialog_leave_match_negative) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun updateScores() {
        binding.mainGameTeam1Score.text = teamAScore.toString()
        binding.mainGameTeam2Score.text = teamBScore.toString()
    }
}


