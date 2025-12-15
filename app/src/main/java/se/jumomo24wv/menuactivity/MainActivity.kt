package se.jumomo24wv.menuactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.jumomo24wv.menuactivity.data.LanguageManager
import se.jumomo24wv.menuactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.setLocale(this, LanguageManager.getLanguage(this))
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            menuStartGame.setOnClickListener {
                createGameStartActivity()
            }
            menuLogin.setOnClickListener {
                loginStartActivity()
            }
            menuContactUs.setOnClickListener {
                contactUsStartActivity()
            }
            menuSetting.setOnClickListener {
                settingStartActivity()
            }
            menuRulesPolicy.setOnClickListener {
                rulesStartActivity()
            }


        }

    }
    fun createGameStartActivity(){
        intent = Intent(this, CreateGame::class.java)
        startActivity(intent)
    }
    fun loginStartActivity(){
        intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
    fun contactUsStartActivity(){
        intent = Intent(this, ContactUs::class.java)
        startActivity(intent)
    }
    fun settingStartActivity(){
        intent = Intent(this, Setting::class.java)
        startActivity(intent)
    }


    fun rulesStartActivity(){
        intent = Intent(this, RulesAndPolicy::class.java)
        startActivity(intent)
    }

}