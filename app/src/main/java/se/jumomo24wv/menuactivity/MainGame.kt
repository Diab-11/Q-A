package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.jumomo24wv.menuactivity.data.QuizData
import se.jumomo24wv.menuactivity.data.QuizQuestion
import se.jumomo24wv.menuactivity.databinding.ActivityMainGameBinding

class MainGame : AppCompatActivity() {

    private lateinit var binding: ActivityMainGameBinding
    private var teamAScore = 0
    private var teamBScore = 0

    private val gameQuestions = mutableMapOf<String, QuizQuestion>()

    private val questionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val teamAPointsGained = data?.getIntExtra("TEAM_A_POINTS_GAINED", 0) ?: 0
            val teamBPointsGained = data?.getIntExtra("TEAM_B_POINTS_GAINED", 0) ?: 0
            teamAScore += teamAPointsGained
            teamBScore += teamBPointsGained
            updateScores()

            val answeredQuestionId = data?.getStringExtra("ANSWERED_QUESTION_ID")
            if (answeredQuestionId != null) {
                val resId = resources.getIdentifier(answeredQuestionId, "id", packageName)
                if (resId != 0) {
                    findViewById<View>(resId).isEnabled = false
                }
            }
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

        val nameText1 = intent.getStringExtra(CreateGame.ARG_TXT1)
        val nameText2 = intent.getStringExtra(CreateGame.ARG_TXT2)
        val gameNameText = intent.getStringExtra(CreateGame.ARG_GAMETXT)

        binding.mainGameTeam1.text = nameText1 ?: ""
        binding.mainGameTeam2.text = nameText2 ?: ""
        binding.mainGameName.text = gameNameText ?: ""
        updateScores()
        generateGameQuestions()
        setupButtonClickListeners()
    }

    private fun generateGameQuestions() {
        gameQuestions["flags_countries_200"] = QuizData.flagsEasy.random()
        gameQuestions["flags_countries_400"] = QuizData.flagsMedium.random()
        gameQuestions["flags_countries_600"] = QuizData.flagsHard.random()

        gameQuestions["geography_200"] = QuizData.geographyEasy.random()
        gameQuestions["geography_400"] = QuizData.geographyMedium.random()
        gameQuestions["geography_600"] = QuizData.geographyHard.random()

        gameQuestions["cars_200"] = QuizData.carsEasy.random()
        gameQuestions["cars_400"] = QuizData.carsMedium.random()
        gameQuestions["cars_600"] = QuizData.carsHard.random()

        gameQuestions["common_knowledge_200"] = QuizData.commonKnowledgeEasy.random()
        gameQuestions["common_knowledge_400"] = QuizData.commonKnowledgeMedium.random()
        gameQuestions["common_knowledge_600"] = QuizData.commonKnowledgeHard.random()

        gameQuestions["sports_200"] = QuizData.sportsEasy.random()
        gameQuestions["sports_400"] = QuizData.sportsMedium.random()
        gameQuestions["sports_600"] = QuizData.sportsHard.random()
    }

    private fun setupButtonClickListeners() {
        val buttonIds = gameQuestions.keys
        for (buttonId in buttonIds) {
            val resId = resources.getIdentifier(buttonId, "id", packageName)
            if (resId != 0) {
                 findViewById<View>(resId).setOnClickListener {
                    openQuestion(buttonId)
                }
            }
        }
    }

    private fun openQuestion(questionId: String) {
        val question = gameQuestions[questionId]
        if (question != null) {
            val intent = Intent(this, QuestionViewActivity::class.java)
            intent.putExtra("QUESTION", question)
            intent.putExtra("TEAM_A_SCORE", teamAScore)
            intent.putExtra("TEAM_B_SCORE", teamBScore)
            intent.putExtra("QUESTION_ID", questionId)
            questionLauncher.launch(intent)
        }
    }

    private fun updateScores() {
        binding.mainGameTeam1Score.text = teamAScore.toString()
        binding.mainGameTeam2Score.text = teamBScore.toString()
    }
}
