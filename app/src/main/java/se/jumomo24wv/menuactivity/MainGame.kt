package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import se.jumomo24wv.menuactivity.data.QuizQuestion
import se.jumomo24wv.menuactivity.data.QuizRepository
import se.jumomo24wv.menuactivity.databinding.ActivityMainGameBinding
import se.jumomo24wv.menuactivity.data.NoWordData
import se.jumomo24wv.menuactivity.data.NoWordQuestion
import se.jumomo24wv.menuactivity.data.NoWordDataSV
import se.jumomo24wv.menuactivity.data.NoWordDataAR

import androidx.activity.addCallback
import se.jumomo24wv.menuactivity.data.LanguageManager

private const val SCORE_START = 0

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

// Number of quiz category slots on the board (the teams pick this many categories,
// possibly including "No Word", on the SelectCategoriesActivity screen).
private const val SLOT_COUNT = 6


class MainGame : AppCompatActivity() {

    private lateinit var binding: ActivityMainGameBinding
    private var teamAScore = 0
    private var teamBScore = 0
    private var teamAName: String? = null
    private var teamBName: String? = null
    private var gameName: String? = null
    private var isTeamATurn = TEAM_A_STARTS // Team A starts

    // The categories the teams picked, in slot order: index 0 -> slot1, ... index 5 -> slot6.
    // "No Word" may or may not be one of these six, exactly like any other category.
    private var selectedCategories: List<String> = emptyList()
    private val slotIds = listOf("slot1", "slot2", "slot3", "slot4", "slot5", "slot6")
    private lateinit var slotToCategory: Map<String, String>
    private lateinit var categoryToSlot: Map<String, String>

    // All 18 point-button ids on the board (3 per slot), regardless of which
    // category (regular or "No Word") ends up in each slot.
    private val allQuestionButtonIds: List<String> by lazy {
        slotIds.flatMap { slot -> listOf("${slot}_200", "${slot}_400", "${slot}_600") }
    }

    private data class SlotViews(
        val title: TextView,
        val btn200: MaterialButton,
        val btn400: MaterialButton,
        val btn600: MaterialButton,
        val bonus: MaterialButton
    )

    private lateinit var slotViews: List<SlotViews>

    // Current game state
    private val gameQuestions = mutableMapOf<String, QuizQuestion>()
    private val answeredQuestions = mutableSetOf<String>()
    private val usedBonusButtons = mutableSetOf<String>()
    private val presentedQuestions = mutableSetOf<QuizQuestion>() // Tracks all questions shown to user

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

        // The old fixed "No Word" column is no longer used: "No Word" is now just
        // one of the 6 dynamic slots when the teams choose to pick it.
        binding.sectionNoWord.visibility = View.GONE

        teamAName = intent.getStringExtra(CreateGame.ARG_TXT1)
        teamBName = intent.getStringExtra(CreateGame.ARG_TXT2)
        gameName = intent.getStringExtra(CreateGame.ARG_GAMETXT)

        binding.mainGameTeam1.text = teamAName ?: EMPTY
        binding.mainGameTeam2.text = teamBName ?: EMPTY
        binding.mainGameName.text = gameName ?: EMPTY

        setUpSelectedCategories()

        updateScores()
        initializeNewGame()
        setupBonusButtonClickListeners()
        setupButtonClickListeners()
        restoreBoardState()
        updateTurnHighlight()
    }

    /**
     * Reads the categories chosen on SelectCategoriesActivity, assigns each one to a
     * board slot (slot1..slot6), wires up the SlotViews for those slots, and sets
     * each slot's title to the localized category name.
     */
    private fun setUpSelectedCategories() {
        val chosen = intent.getStringArrayListExtra(SelectCategoriesActivity.EXTRA_SELECTED_CATEGORIES)
            ?: arrayListOf()

        selectedCategories = if (chosen.size >= SLOT_COUNT) {
            chosen.take(SLOT_COUNT)
        } else {
            // Defensive fallback (e.g. MainGame launched without going through the
            // selection screen): fill any missing slots from the full category pool.
            val remaining = QuizRepository.ALL_CATEGORIES.filter { it !in chosen }
            (chosen + remaining).take(SLOT_COUNT)
        }

        slotToCategory = slotIds.zip(selectedCategories).toMap()
        categoryToSlot = slotToCategory.entries.associate { (slot, category) -> category to slot }

        slotViews = listOf(
            SlotViews(binding.slot1Title, binding.slot1200, binding.slot1400, binding.slot1600, binding.slot1Bonus),
            SlotViews(binding.slot2Title, binding.slot2200, binding.slot2400, binding.slot2600, binding.slot2Bonus),
            SlotViews(binding.slot3Title, binding.slot3200, binding.slot3400, binding.slot3600, binding.slot3Bonus),
            SlotViews(binding.slot4Title, binding.slot4200, binding.slot4400, binding.slot4600, binding.slot4Bonus),
            SlotViews(binding.slot5Title, binding.slot5200, binding.slot5400, binding.slot5600, binding.slot5Bonus),
            SlotViews(binding.slot6Title, binding.slot6200, binding.slot6400, binding.slot6600, binding.slot6Bonus)
        )

        for ((slot, category) in slotToCategory) {
            val index = slotIds.indexOf(slot)
            slotViews[index].title.text = QuizRepository.displayName(this, category)
        }
    }

    /** Resolves a generated button id like "slot3_400" or "slot3_bonus" back to its MaterialButton. */
    private fun findButtonView(buttonId: String): MaterialButton? {
        val slot = slotIds.firstOrNull { buttonId.startsWith("${it}_") } ?: return null
        val index = slotIds.indexOf(slot)
        val views = slotViews.getOrNull(index) ?: return null
        return when {
            buttonId.endsWith("_200") -> views.btn200
            buttonId.endsWith("_400") -> views.btn400
            buttonId.endsWith("_600") -> views.btn600
            buttonId.endsWith("_bonus") -> views.bonus
            else -> null
        }
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


    /**
     * Starts a bonus round for whichever slot [category] lives in. Works the same way
     * for a regular category (re-rolls its 3 questions) and for "No Word" (its 3
     * buttons just get re-enabled — new cards are picked at click time anyway).
     */
    private fun triggerBonusRound(category: String, bonusButtonId: String) {
        if (isBonusMode || usedBonusButtons.contains(bonusButtonId)) return
        val slot = categoryToSlot[category] ?: return

        isBonusMode = true
        usedBonusButtons.add(bonusButtonId)

        // Intro animation
        playBonusRoundIntroAnimation()

        // Spara state före bonus
        preBonusGameQuestions.clear()
        preBonusGameQuestions.putAll(gameQuestions)
        preBonusAnsweredQuestions.clear()
        preBonusAnsweredQuestions.addAll(answeredQuestions)

        // Ladda om frågor för vald kategori (inte relevant för "No Word", som slumpar kort vid klick)
        if (category != QuizRepository.NO_WORD_CATEGORY) {
            refreshCategoryQuestions(category)
        }

        // Fasta knapp-id:n för den slot kategorin ligger i
        val allowedQuestionIds = listOf("${slot}_200", "${slot}_400", "${slot}_600")

        // ✅ VIKTIGT: gör rutorna klickbara i bonus genom att ta bort dem från answeredQuestions
        answeredQuestions.removeAll(allowedQuestionIds.toSet())

        // Aktivera endast bonus-kategorins tre rutor, disable resten
        val allowedSet = allowedQuestionIds.toSet()
        for (buttonId in allQuestionButtonIds) {
            val button = findButtonView(buttonId) ?: continue
            if (allowedSet.contains(buttonId)) {
                button.isEnabled = true
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
            } else {
                button.isEnabled = false
            }
        }

        // Poppa in de tre bonusrutorna
        for (buttonId in allowedQuestionIds) {
            val b = findButtonView(buttonId) ?: continue
            b.scaleX = BONUS_TILE_START_SCALE
            b.scaleY = BONUS_TILE_START_SCALE
            b.alpha = ALPHA_ZERO
            b.animate().alpha(ALPHA_FULL).scaleX(ALPHA_FULL).scaleY(ALPHA_FULL).setDuration(BONUS_TILE_ANIM_DURATION_MS).start()
        }

        // Disable bonus-knapparna under bonusrundan
        setAllBonusButtonsEnabled(false)
    }

    /** Refreshes the 3 questions (easy/medium/hard) shown for one category, in whichever slot it's in. */
    private fun refreshCategoryQuestions(category: String) {
        val slot = categoryToSlot[category] ?: return

        fun updateQuestion(buttonId: String, questionPool: List<QuizQuestion>) {
            if (questionPool.isEmpty()) return
            val newQuestion = questionPool.filter { it !in presentedQuestions }.randomOrNull()
            val questionToUse = newQuestion ?: questionPool.random() // Fallback if uniques run out

            gameQuestions[buttonId] = questionToUse
            presentedQuestions.add(questionToUse) // Track all presented questions to ensure uniqueness
        }

        updateQuestion("${slot}_200", QuizRepository.getPool(this, category, "easy"))
        updateQuestion("${slot}_400", QuizRepository.getPool(this, category, "medium"))
        updateQuestion("${slot}_600", QuizRepository.getPool(this, category, "hard"))
    }

    private fun restoreBoardState() {
        val unlockAllBonusesNow = isAllMainQuestionsDone()

        for (buttonId in allQuestionButtonIds) {
            val button = findButtonView(buttonId) ?: continue
            if (answeredQuestions.contains(buttonId)) {
                button.isEnabled = false
                button.setBackgroundColor(Color.GRAY)
            } else {
                button.isEnabled = true
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
            }
        }

        val bonusRules = slotIds.mapIndexed { index, slot -> slotViews[index].bonus to "${slot}_bonus" }

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
    }

    private fun initializeNewGame() {
        presentedQuestions.clear()
        for (category in selectedCategories) {
            if (category != QuizRepository.NO_WORD_CATEGORY) {
                refreshCategoryQuestions(category)
            }
        }
    }

    /**
     * Wires up the 3 point-buttons for every slot. A slot holding "No Word" opens the
     * acting/QR flow; any other slot opens the normal question flow.
     */
    private fun setupButtonClickListeners() {
        for ((slot, category) in slotToCategory) {
            val index = slotIds.indexOf(slot)
            val views = slotViews[index]

            if (category == QuizRepository.NO_WORD_CATEGORY) {
                val pools = noWordPoolsForCurrentLanguage()
                views.btn200.setOnClickListener { openNoWordQr(pools.first, "${slot}_200") }
                views.btn400.setOnClickListener { openNoWordQr(pools.second, "${slot}_400") }
                views.btn600.setOnClickListener { openNoWordQr(pools.third, "${slot}_600") }
            } else {
                views.btn200.setOnClickListener { openQuestion("${slot}_200") }
                views.btn400.setOnClickListener { openQuestion("${slot}_400") }
                views.btn600.setOnClickListener { openQuestion("${slot}_600") }
            }
        }
    }

    private fun setAllBonusButtonsEnabled(enabled: Boolean) {
        // This function is now only for disabling buttons during a bonus round.
        // The main logic is in restoreBoardState.
        if (!enabled) {
            for (slot in slotViews) {
                slot.bonus.isEnabled = false
            }
        }
    }

    private fun setupBonusButtonClickListeners() {
        for ((slot, category) in slotToCategory) {
            val index = slotIds.indexOf(slot)
            slotViews[index].bonus.setOnClickListener { triggerBonusRound(category, "${slot}_bonus") }
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

    /** Returns the (easy, medium, hard) No-Word card pools for the current app language. */
    private fun noWordPoolsForCurrentLanguage(): Triple<List<NoWordQuestion>, List<NoWordQuestion>, List<NoWordQuestion>> {
        return when {
            LanguageManager.isArabic(this) -> Triple(NoWordDataAR.noWord200, NoWordDataAR.noWord400, NoWordDataAR.noWord600)
            LanguageManager.isSwedish(this) -> Triple(NoWordDataSV.noWord200, NoWordDataSV.noWord400, NoWordDataSV.noWord600)
            else -> Triple(NoWordData.noWord200, NoWordData.noWord400, NoWordData.noWord600)
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
        // Same result contract/shape as a normal question, so it can share questionLauncher.
        questionLauncher.launch(intent)
    }


    private var gameOverTriggered = false

    private fun checkGameOver() {
        if (gameOverTriggered) return

        // 1) Vänta tills alla 6 kategoriers frågor är klara
        if (!isAllMainQuestionsDone()) return

        // 2) När allt är klart, måste alla bonusar användas innan Winner
        val allBonusIds = slotIds.map { "${it}_bonus" }.toSet()

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

    private fun isAllMainQuestionsDone(): Boolean {
        return answeredQuestions.size == allQuestionButtonIds.size
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