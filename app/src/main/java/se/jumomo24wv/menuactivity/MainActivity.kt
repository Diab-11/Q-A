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
