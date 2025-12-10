package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import se.jumomo24wv.menuactivity.data.QuizQuestion

class QuestionViewActivity : AppCompatActivity() {
    private lateinit var questionPoints : MaterialButton
    private lateinit var questionText: TextView
    private lateinit var questionImage: ImageView
    private lateinit var timerText: TextView
    private lateinit var teamAScore: TextView
    private lateinit var teamBScore: TextView
    private lateinit var revealAnswerButton: Button

    private var currentQuestion: QuizQuestion? = null
    private var questionId: String? = null
    private var teamAScoreValue = 0
    private var teamBScoreValue = 0
    private var timer: CountDownTimer? = null

    private val revealAnswerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val teamACorrect = data?.getBooleanExtra("TEAM_A_CORRECT", false) ?: false
            val teamBCorrect = data?.getBooleanExtra("TEAM_B_CORRECT", false) ?: false
            awardPoints(teamA = teamACorrect, teamB = teamBCorrect)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)

        questionText = findViewById(R.id.question_text)
        questionImage = findViewById(R.id.question_image)
        timerText = findViewById(R.id.timer_text)
        teamAScore = findViewById(R.id.team_a_score)
        teamBScore = findViewById(R.id.team_b_score)
        revealAnswerButton = findViewById(R.id.reveal_answer_button)
        questionPoints = findViewById(R.id.question_points)

        teamAScoreValue = intent.getIntExtra("TEAM_A_SCORE", 0)
        teamBScoreValue = intent.getIntExtra("TEAM_B_SCORE", 0)
        updateScores()

        currentQuestion = intent.getParcelableExtra("QUESTION")
        questionId = intent.getStringExtra("QUESTION_ID")

        if (currentQuestion != null) {
            displayQuestion()
            startTimer()
        } else {
            // Handle error: No question provided
            finish()
        }

        revealAnswerButton.setOnClickListener {
            revealAnswer()
        }
    }

    private fun displayQuestion() {
        currentQuestion?.let {
            questionText.text = it.question
            if (it.imageRes != null) {
                questionImage.setImageResource(it.imageRes)
                questionImage.visibility = View.VISIBLE
            } else {
                questionImage.visibility = View.GONE
            }
        }
        questionPoints.text = "${currentQuestion?.category} : ${currentQuestion?.points}"
    }

    private fun startTimer() {
        timer = object : CountDownTimer(60000, 1000) { // 60 second timer
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerText.text = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                timerText.text = "00:00"
                revealAnswer()
            }
        }.start()
    }

    private fun revealAnswer() {
        timer?.cancel()
        val intent = Intent(this, RevealAnswerActivity::class.java)
        intent.putExtra("ANSWER", currentQuestion?.answer)
        revealAnswerLauncher.launch(intent)
    }

    private fun awardPoints(teamA: Boolean, teamB: Boolean) {
        var teamAPointsGained = 0
        var teamBPointsGained = 0
        currentQuestion?.let {
            if (teamA) teamAPointsGained = it.points
            if (teamB) teamBPointsGained = it.points
        }

        teamAScoreValue += teamAPointsGained
        teamBScoreValue += teamBPointsGained
        updateScores()

        val resultIntent = Intent()
        resultIntent.putExtra("TEAM_A_POINTS_GAINED", teamAPointsGained)
        resultIntent.putExtra("TEAM_B_POINTS_GAINED", teamBPointsGained)
        resultIntent.putExtra("ANSWERED_QUESTION_ID", questionId)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun updateScores() {
        teamAScore.text = "Team A: $teamAScoreValue"
        teamBScore.text = "Team B: $teamBScoreValue"
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
