package se.jumomo24wv.menuactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.jumomo24wv.menuactivity.databinding.ActivityCreateGameBinding

class CreateGame : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGameBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        binding.createGameBtn.setOnClickListener {
            val team1txt = binding.inputTeam1.editText?.text.toString()
            val team2txt = binding.inputTeam2.editText?.text.toString()
            val gametxt = binding.gameName.text.toString()

            var hasError = false

            if (team1txt.isEmpty()) {
                binding.inputTeam1.error = "Team name cannot be empty"
                hasError = true
            } else if (team1txt.length > MAX_NAME_LENGTH) {
                binding.inputTeam1.error = "Team name cannot be more than $MAX_NAME_LENGTH characters"
                hasError = true
            } else {
                binding.inputTeam1.error = null
            }

            if (team2txt.isEmpty()) {
                binding.inputTeam2.error = "Team name cannot be empty"
                hasError = true
            } else if (team2txt.length > MAX_NAME_LENGTH) {
                binding.inputTeam2.error = "Team name cannot be more than $MAX_NAME_LENGTH characters"
                hasError = true
            } else {
                binding.inputTeam2.error = null
            }

            if (gametxt.isEmpty()) {
                binding.createGameName.error = "Game name cannot be empty"
                hasError = true
            } else if (gametxt.length > MAX_NAME_LENGTH) {
                binding.createGameName.error = "Game name cannot be more than $MAX_NAME_LENGTH characters"
                hasError = true
            } else {
                binding.createGameName.error = null
            }

            if (!hasError) {
                val intent = Intent(this, MainGame::class.java).apply {
                    putExtra(ARG_TXT1, team1txt)
                    putExtra(ARG_TXT2, team2txt)
                    putExtra(ARG_GAMETXT, gametxt)
                }
                startActivity(intent)
            }
        }
    }

    companion object {
        const val ARG_TXT1 = "team1_name"
        const val ARG_TXT2 = "team2_name"
        const val ARG_GAMETXT = "game_name"

        private const val MAX_NAME_LENGTH = 12
    }
}
