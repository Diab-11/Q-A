package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class NoWordQrActivity : AppCompatActivity() {

    private val actingLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // skicka bara vidare resultatet till MainGame
                setResult(Activity.RESULT_OK, result.data)
                finish()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_word_qr)

        val qrImage: ImageView = findViewById(R.id.qrImage)
        val startActingButton: Button = findViewById(R.id.doneButton)

        val url = intent.getStringExtra("NO_WORD_URL") ?: return
        val points = intent.getIntExtra("NO_WORD_POINTS", 0)
        val teamAName = intent.getStringExtra("TEAM_A_NAME")
        val teamBName = intent.getStringExtra("TEAM_B_NAME")
        val answer = intent.getStringExtra("NO_WORD_ANSWER")


        val qrBitmap = generateQrBitmap(url)
        qrImage.setImageBitmap(qrBitmap)

        startActingButton.text = "Start acting"
        startActingButton.setOnClickListener {
            val actIntent = Intent(this, NoWordActActivity::class.java).apply {
                putExtra("NO_WORD_POINTS", points)
                putExtra("TEAM_A_NAME", teamAName)
                putExtra("TEAM_B_NAME", teamBName)
                putExtra("NO_WORD_ANSWER",answer)
            }
            actingLauncher.launch(actIntent)
        }
    }
}
