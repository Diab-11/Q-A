package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class NoWordActActivity : AppCompatActivity() {

    private lateinit var timerText: TextView
    private lateinit var finishButton: Button
    private var timer: CountDownTimer? = null
    private var points: Int = 0
    private var answer: String = ""
    private var teamAName: String? = null
    private var teamBName: String? = null

    private var answeredQuestionId: String? = null

    private val revealLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val teamACorrect = data?.getBooleanExtra("TEAM_A_CORRECT", false) ?: false
                val teamBCorrect = data?.getBooleanExtra("TEAM_B_CORRECT", false) ?: false

                var teamAPoints = 0
                var teamBPoints = 0
                if (teamACorrect) teamAPoints = points
                if (teamBCorrect) teamBPoints = points

                val resultIntent = Intent().apply {
                    putExtra("TEAM_A_POINTS_GAINED", teamAPoints)
                    putExtra("TEAM_B_POINTS_GAINED", teamBPoints)
                    putExtra("ANSWERED_QUESTION_ID", answeredQuestionId)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_word_act)

        timerText = findViewById(R.id.timer_text)
        finishButton = findViewById(R.id.round_finished_button)
        answeredQuestionId = intent.getStringExtra("ANSWERED_QUESTION_ID")

        points = intent.getIntExtra("NO_WORD_POINTS", 0)
        answer = intent.getStringExtra("NO_WORD_ANSWER").toString()

        teamAName = intent.getStringExtra("TEAM_A_NAME") ?: "Team A"
        teamBName = intent.getStringExtra("TEAM_B_NAME") ?: "Team B"

        startTimerForPoints(points)

        finishButton.setOnClickListener {
            // gå till samma view som vanliga frågor använder
            val intent = Intent(this, RevealAnswerActivity::class.java).apply {
                // vi behöver inte visa ordet, men vi kan sätta en text
                putExtra("ANSWER", answer)
                putExtra("TEAM_A_NAME", teamAName)
                putExtra("TEAM_B_NAME", teamBName)
            }
            revealLauncher.launch(intent)
        }
    }

    private fun startTimerForPoints(points: Int) {
        val millis = when (points) {
            200 -> 90_000L   // 1.5 min
            400 -> 60_000L   // 1 min
            600 -> 45_000L   // 45 s
            else -> 60_000L
        }

        timer?.cancel()
        timer = object : CountDownTimer(millis, 1_000L) {
            override fun onTick(millisUntilFinished: Long) {
                val totalSeconds = millisUntilFinished / 1000
                val minutes = totalSeconds / 60
                val seconds = totalSeconds % 60
                timerText.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                timerText.text = "00:00"  // bara visuellt
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}