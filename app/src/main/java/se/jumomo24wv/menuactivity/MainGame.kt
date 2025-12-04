package se.jumomo24wv.menuactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.jumomo24wv.menuactivity.databinding.ActivityMainGameBinding

class MainGame : AppCompatActivity() {

    private lateinit var binding: ActivityMainGameBinding

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
    }
}
