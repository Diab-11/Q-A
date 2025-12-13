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

    private val questionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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
    }
    private val noWordLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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

        preBonusGameQuestions.clear()
        preBonusGameQuestions.putAll(gameQuestions)
        preBonusAnsweredQuestions.clear()
        preBonusAnsweredQuestions.addAll(answeredQuestions)

        refreshCategoryQuestions(category)

        for ((buttonId, question) in gameQuestions) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                val button = findViewById<View>(resId)
                if (question.category == category) {
                    button.isEnabled = true
                    (button as? MaterialButton)?.setBackgroundColor(ContextCompat.getColor(this, R.color.Secondry))
                } else {
                    button.isEnabled = false
                }
            }
        }
        setAllBonusButtonsEnabled(false)
    }

    private fun triggerNoWordBonusRound(bonusButtonId: String) {
        if (isBonusMode || usedBonusButtons.contains(bonusButtonId)) return

        isBonusMode = true
        usedBonusButtons.add(bonusButtonId)

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


        val bonusCategories = mapOf(
            "cars_bonus" to "Cars",
            "common_knowledge_bonus" to "Common Knowledge",
            "sports_bonus" to "Sports",
            "geography_bonus" to "Geography",
            "flags_countries_bonus" to "Flags and Countries"
        )

        for ((bonusButtonId, category) in bonusCategories) {
            val resId = resources.getIdentifier(bonusButtonId, "id", packageName)
            if (resId != 0) {
                val button = findViewById<MaterialButton>(resId)
                if (usedBonusButtons.contains(bonusButtonId)) {
                    button.isEnabled = false
                    button.setBackgroundColor(Color.GRAY)
                } else {
                    val questionIdsForCategory = gameQuestions.filter { it.value.category == category }.keys
                    val allAnswered = questionIdsForCategory.size == 3 && answeredQuestions.containsAll(questionIdsForCategory)

                    button.isEnabled = allAnswered
                    if (allAnswered) {
                        button.setBackgroundColor(ContextCompat.getColor(this, R.color.ripplePrimary))
                    } else {
                        button.setBackgroundColor(Color.GRAY)
                    }
                }
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
        noWordLauncher.launch(intent)
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