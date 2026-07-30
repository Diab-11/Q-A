package se.jumomo24wv.menuactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import se.jumomo24wv.menuactivity.data.LanguageManager
import se.jumomo24wv.menuactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply the saved language before super.onCreate
        LanguageManager.applyLanguage(LanguageManager.getLanguage(this))
        
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
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
        val intent = Intent(this, CreateGame::class.java)
        startActivity(intent)
    }
    fun loginStartActivity(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
    fun contactUsStartActivity(){
        val intent = Intent(this, ContactUs::class.java)
        startActivity(intent)
    }
    fun settingStartActivity(){
        val intent = Intent(this, Setting::class.java)
        startActivity(intent)
    }
    fun rulesStartActivity(){
        val intent = Intent(this, RulesAndPolicy::class.java)
        startActivity(intent)
    }
}