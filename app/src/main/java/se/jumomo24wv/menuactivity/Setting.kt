package se.jumomo24wv.menuactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Setting : AppCompatActivity() {

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

        // Initialize Firebase Auth
        firebaseAuth = Firebase.auth

        setupThemeSpinner()
        setupLogoutButton()
    }

    private fun setupThemeSpinner() {
        val themeSpinner: Spinner = findViewById(R.id.theme_spinner)
        val sharedPreferences = getSharedPreferences("ThemePref", Context.MODE_PRIVATE)

        val themes = resources.getStringArray(R.array.theme_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, themes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        themeSpinner.adapter = adapter

        val savedTheme = sharedPreferences.getInt("theme_pos", 2) // Default to system theme
        themeSpinner.setSelection(savedTheme)

        themeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val editor = sharedPreferences.edit()
                editor.putInt("theme_pos", position)
                editor.apply()
                when (position) {
                    0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setupLogoutButton() {
        val logoutButton: Button = findViewById(R.id.logout_button)

        if (firebaseAuth.currentUser != null) {
            logoutButton.visibility = View.VISIBLE
            logoutButton.setOnClickListener {
                firebaseAuth.signOut()
                // Optional: Sign out from Google to allow account switching
                // val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                // val googleSignInClient = GoogleSignIn.getClient(this, gso)
                // googleSignInClient.signOut()

                Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show()

                // Redirect to MainActivity and clear the task stack
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        } else {
            logoutButton.visibility = View.GONE
        }
    }
}
