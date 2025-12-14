package se.jumomo24wv.menuactivity.data

import android.content.Context

object LanguageManager {

    fun getLanguage(context: Context): String {
        val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        return prefs.getString("lang", "en") ?: "en"
    }

    fun saveLanguage(context: Context, lang: String) {
        val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        prefs.edit().putString("lang", lang).apply()
    }

    fun isSwedish(context: Context): Boolean {
        return getLanguage(context) == "sv"
    }
}