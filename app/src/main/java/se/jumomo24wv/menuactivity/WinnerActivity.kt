package se.jumomo24wv.menuactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val winnerTextView: TextView = findViewById(R.id.winner_textview)
        val goBackButton: Button = findViewById(R.id.go_back_button)

        val winnerName = intent.getStringExtra("WINNER_NAME")
        val winnerScore = intent.getIntExtra("WINNER_SCORE", 0)

        winnerTextView.text = "Winner: $winnerName with $winnerScore points!"

        goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}