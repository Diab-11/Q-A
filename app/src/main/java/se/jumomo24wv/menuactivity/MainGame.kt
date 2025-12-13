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
import se.jumomo24wv.menuactivity.data.QuizQuestion
import se.jumomo24wv.menuactivity.databinding.ActivityMainGameBinding
import se.jumomo24wv.menuactivity.data.NoWordData
import se.jumomo24wv.menuactivity.data.NoWordQuestion



class MainGame : AppCompatActivity() {

    private lateinit var binding: ActivityMainGameBinding
    private var teamAScore = 0
    private var teamBScore = 0
    private var teamAName: String? = null
    private var teamBName: String? = null
    private var isTeamATurn = true // Team A starts

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


    private fun showLoadingPulse(message: String = "Loading...") {
        binding.loadingText.text = message
        binding.loadingOverlay.visibility = View.VISIBLE

        // om den redan kör, starta inte igen
        if (loadingAnimator?.isRunning == true) return

        // pulserar skalan på loggan
        loadingAnimator = android.animation.ObjectAnimator.ofFloat(
            binding.loadingLogo,
            View.SCALE_X,
            1f, 1.08f, 1f
        ).apply {
            duration = 900
            repeatCount = android.animation.ValueAnimator.INFINITE
            repeatMode = android.animation.ValueAnimator.RESTART
        }

        // vi vill pulse på både X och Y
        val scaleYAnimator = android.animation.ObjectAnimator.ofFloat(
            binding.loadingLogo,
            View.SCALE_Y,
            1f, 1.08f, 1f
        ).apply {
            duration = 900
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

        // återställ skala
        binding.loadingLogo.scaleX = 1f
        binding.loadingLogo.scaleY = 1f
    }
    private fun playBonusRoundIntroAnimation() {
        val board = binding.main  // root layout i activity_main_game.xml

        board.animate()
            .scaleX(0.96f)
            .scaleY(0.96f)
            .alpha(0.7f)
            .setDuration(120)
            .withEndAction {
                board.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .setDuration(180)
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
            val teamAPointsGained = data?.getIntExtra("TEAM_A_POINTS_GAINED", 0) ?: 0
            val teamBPointsGained = data?.getIntExtra("TEAM_B_POINTS_GAINED", 0) ?: 0
            teamAScore += teamAPointsGained
            teamBScore += teamBPointsGained
            updateScores()

            val answeredQuestionId = data?.getStringExtra("ANSWERED_QUESTION_ID")

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
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        teamAName = intent.getStringExtra(CreateGame.ARG_TXT1)
        teamBName = intent.getStringExtra(CreateGame.ARG_TXT2)
        val gameNameText = intent.getStringExtra(CreateGame.ARG_GAMETXT)

        binding.mainGameTeam1.text = teamAName ?: ""
        binding.mainGameTeam2.text = teamBName ?: ""
        binding.mainGameName.text = gameNameText ?: ""
        updateScores()
        initializeNewGame()
        setupButtonClickListeners()
        setupBonusButtonClickListeners()
        setupNoWordClickListeners()
        restoreBoardState() // Set initial state of all buttons
        updateTurnHighlight() // Set initial highlight
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
                b.scaleX = 0.85f
                b.scaleY = 0.85f
                b.alpha = 0f
                b.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(220).start()
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
        fun updateQuestion(buttonId: String, questionPool: List<QuizQuestion>) {
            val newQuestion = questionPool.filter { it !in presentedQuestions }.randomOrNull()
            val questionToUse = newQuestion ?: questionPool.random() // Fallback to any random question if uniques run out

            gameQuestions[buttonId] = questionToUse
            presentedQuestions.add(questionToUse) // Track all presented questions to ensure uniqueness
        }

        when (category) {
            "Flags and Countries" -> {
                updateQuestion("flags_countries_200", QuizData.flagsEasy)
                updateQuestion("flags_countries_400", QuizData.flagsMedium)
                updateQuestion("flags_countries_600", QuizData.flagsHard)
            }
            "Geography" -> {
                updateQuestion("geography_200", QuizData.geographyEasy)
                updateQuestion(
                    "geography_400",
                    QuizData.geographyMedium
                )
                updateQuestion("geography_600", QuizData.geographyHard)
            }
            "Cars" -> {
                updateQuestion("cars_200", QuizData.carsEasy)
                updateQuestion("cars_400", QuizData.carsMedium)
                updateQuestion("cars_600", QuizData.carsHard)
            }
            "Common Knowledge" -> {
                updateQuestion("common_knowledge_200", QuizData.commonKnowledgeEasy)
                updateQuestion("common_knowledge_400", QuizData.commonKnowledgeMedium)
                updateQuestion("common_knowledge_600", QuizData.commonKnowledgeHard)
            }
            "Sports" -> {
                updateQuestion("sports_200", QuizData.sportsEasy)
                updateQuestion("sports_400", QuizData.sportsMedium)
                updateQuestion("sports_600", QuizData.sportsHard)
            }
        }
    }

    private fun restoreBoardState() {
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
            Triple(binding.carsBonus, listOf("cars_200", "cars_400", "cars_600"), "cars_bonus"),
            Triple(binding.commonKnowledgeBonus, listOf("common_knowledge_200", "common_knowledge_400", "common_knowledge_600"), "common_knowledge_bonus"),
            Triple(binding.sportsBonus, listOf("sports_200", "sports_400", "sports_600"), "sports_bonus"),
            Triple(binding.geographyBonus, listOf("geography_200", "geography_400", "geography_600"), "geography_bonus"),
            Triple(binding.flagsCountriesBonus, listOf("flags_countries_200", "flags_countries_400", "flags_countries_600"), "flags_countries_bonus"),
        )

        for ((button, ids, bonusId) in bonusRules) {
            if (usedBonusButtons.contains(bonusId)) {
                button.isEnabled = false
                button.setBackgroundColor(Color.GRAY)
            } else {
                val unlocked = answeredQuestions.containsAll(ids)
                button.isEnabled = unlocked
                button.setBackgroundColor(if (unlocked) ContextCompat.getColor(this, R.color.ripplePrimary) else Color.GRAY)
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

        val allNoWordAnswered = answeredNoWordQuestions.containsAll(listOf("no_word_200", "no_word_400", "no_word_600"))
        binding.noWordBonus.isEnabled = allNoWordAnswered && !usedBonusButtons.contains("no_word_bonus")
        if (binding.noWordBonus.isEnabled) {
            binding.noWordBonus.setBackgroundColor(ContextCompat.getColor(this, R.color.ripplePrimary))
        } else {
            binding.noWordBonus.setBackgroundColor(Color.GRAY)
        }
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

        val allRegularAnswered = answeredQuestions.size == gameQuestions.size
        val allNoWordAnswered = answeredNoWordQuestions.containsAll(listOf("no_word_200", "no_word_400", "no_word_600"))

        if (!allRegularAnswered || !allNoWordAnswered) return

        // vilka bonusar är upplåsta just nu?
        val unlockedBonuses = mutableSetOf<String>()

        if (answeredQuestions.containsAll(listOf("cars_200", "cars_400", "cars_600"))) unlockedBonuses.add("cars_bonus")
        if (answeredQuestions.containsAll(listOf("common_knowledge_200", "common_knowledge_400", "common_knowledge_600"))) unlockedBonuses.add("common_knowledge_bonus")
        if (answeredQuestions.containsAll(listOf("sports_200", "sports_400", "sports_600"))) unlockedBonuses.add("sports_bonus")
        if (answeredQuestions.containsAll(listOf("geography_200", "geography_400", "geography_600"))) unlockedBonuses.add("geography_bonus")
        if (answeredQuestions.containsAll(listOf("flags_countries_200", "flags_countries_400", "flags_countries_600"))) unlockedBonuses.add("flags_countries_bonus")
        if (allNoWordAnswered) unlockedBonuses.add("no_word_bonus")

        val allUnlockedBonusesUsed = usedBonusButtons.containsAll(unlockedBonuses)

        if (!allUnlockedBonusesUsed) {
            Toast.makeText(this, "Bonus rounds remaining!", Toast.LENGTH_SHORT).show()
            return
        }

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
        binding.noWord200.setOnClickListener {
            openNoWordQr(NoWordData.noWord200, "no_word_200")
        }
        binding.noWord400.setOnClickListener {
            openNoWordQr(NoWordData.noWord400, "no_word_400")
        }
        binding.noWord600.setOnClickListener {
            openNoWordQr(NoWordData.noWord600, "no_word_600")
        }
    }






    private fun updateScores() {
        binding.mainGameTeam1Score.text = teamAScore.toString()
        binding.mainGameTeam2Score.text = teamBScore.toString()
    }
}