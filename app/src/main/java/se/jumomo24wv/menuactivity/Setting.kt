package se.jumomo24wv.menuactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import se.jumomo24wv.menuactivity.data.LanguageManager

class Setting : AppCompatActivity() {

    // konstanter för tema o språk, använd för att undvika magiska nummer.
    private companion object {
        private const val THEME_PREF = "ThemePref"
        private const val THEME_POS_KEY = "theme_pos"

        private const val THEME_LIGHT = 0
        private const val THEME_DARK = 1
        private const val THEME_SYSTEM = 2

        private const val LANG_CODE_SWEDISH = "sv"
        private const val LANG_CODE_ENGLISH = "en"
        private const val LANG_CODE_ARABIC = "ar"
        
        private const val LANG_DISPLAY_SWEDISH = "Svenska"
        private const val LANG_DISPLAY_ENGLISH = "English"
        private const val LANG_DISPLAY_ARABIC = "العربية"
    }

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = Firebase.auth

        setupThemeDropdown()
        setupLanguageDropdown()
        setupLogoutButton()
    }

    /**
     * Theme dropdown (samma typ av UI som languageDropdown).
     * Kräver att XML har MaterialAutoCompleteTextView med id: themeDropdown
     */
    private fun setupThemeDropdown() {
        val dropdown = findViewById<MaterialAutoCompleteTextView>(R.id.themeDropdown)
        // SharedPreferences används för att spara användarens temaval
        val sharedPreferences = getSharedPreferences(THEME_PREF, Context.MODE_PRIVATE)

        val themes = resources.getStringArray(R.array.theme_options).toList()
        // Kopplar listan till dropdownen
        dropdown.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, themes))

        val savedThemePos = sharedPreferences.getInt(THEME_POS_KEY, THEME_SYSTEM).coerceIn(themes.indices)
        dropdown.setText(themes[savedThemePos], false)

        dropdown.setOnItemClickListener { _, _, position, _ ->
            sharedPreferences.edit().putInt(THEME_POS_KEY, position).apply()
            when (position) {
                THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    private fun setupLogoutButton() {
        val logoutButton: Button = findViewById(R.id.logout_button)

        if (firebaseAuth.currentUser != null) {
            logoutButton.visibility = View.VISIBLE
            logoutButton.setOnClickListener {
                firebaseAuth.signOut()
                Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        } else {
            logoutButton.visibility = View.GONE
        }
    }

    private fun setupLanguageDropdown() {
        val dropdown = findViewById<MaterialAutoCompleteTextView>(R.id.languageDropdown)

        val items = listOf(LANG_DISPLAY_ENGLISH, LANG_DISPLAY_SWEDISH, LANG_DISPLAY_ARABIC)
        // Kopplar listan till dropdownen
        dropdown.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, items))
        
        // Hämtar nuvarande språk som sparats lokalt
        val current = LanguageManager.getLanguage(this)
        val initialText = when (current) {
            LANG_CODE_SWEDISH -> LANG_DISPLAY_SWEDISH
            LANG_CODE_ARABIC -> LANG_DISPLAY_ARABIC
            else -> LANG_DISPLAY_ENGLISH
        }
        dropdown.setText(initialText, false)

        dropdown.setOnItemClickListener { _, _, position, _ ->
            val selectedLang = when (position) {
                0 -> LANG_CODE_ENGLISH
                1 -> LANG_CODE_SWEDISH
                2 -> LANG_CODE_ARABIC
                else -> LANG_CODE_ENGLISH
            }

            if (selectedLang == current) return@setOnItemClickListener

            LanguageManager.saveLanguage(this, selectedLang)

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
