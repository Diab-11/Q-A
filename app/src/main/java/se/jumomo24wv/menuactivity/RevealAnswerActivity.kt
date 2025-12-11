package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RevealAnswerActivity : AppCompatActivity() {

    private lateinit var answerText: TextView
    private lateinit var teamACorrectButton: Button
    private lateinit var teamBCorrectButton: Button
    private lateinit var noneCorrectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reveal_answer)

        answerText = findViewById(R.id.answer_text)
        teamACorrectButton = findViewById(R.id.team_a_correct_button)
        teamBCorrectButton = findViewById(R.id.team_b_correct_button)
        noneCorrectButton = findViewById(R.id.none_correct_button)

        val answer = intent.getStringExtra("ANSWER")
        val teamAName = intent.getStringExtra("TEAM_A_NAME") ?: "Team A"
        val teamBName = intent.getStringExtra("TEAM_B_NAME") ?: "Team B"
        answerText.text = answer

        teamACorrectButton.text = "$teamAName Correct"
        teamBCorrectButton.text = "$teamBName Correct"

        teamACorrectButton.setOnClickListener { setResultAndFinish(true, false) }
        teamBCorrectButton.setOnClickListener { setResultAndFinish(false, true) }
        noneCorrectButton.setOnClickListener { setResultAndFinish(false, false) }
    }

    private fun setResultAndFinish(teamA: Boolean, teamB: Boolean) {
        val resultIntent = Intent()
        resultIntent.putExtra("TEAM_A_CORRECT", teamA)
        resultIntent.putExtra("TEAM_B_CORRECT", teamB)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}