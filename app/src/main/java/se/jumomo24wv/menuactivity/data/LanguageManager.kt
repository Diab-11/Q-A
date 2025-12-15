package se.jumomo24wv.menuactivity.data

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LanguageManager {

    private const val PREF_NAME = "settings"
    private const val KEY_LANG = "lang"


    fun getLanguage(context: Context): String {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_LANG, DEFAULT_LANG) ?: DEFAULT_LANG
    }


    fun saveLanguage(context: Context, lang: String) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_LANG, lang).apply()
        setLocale(context, lang)
    }


    fun isSwedish(context: Context): Boolean {
        return getLanguage(context) == LANG_SV
    }


    fun setLocale(context: Context, lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    private const val LANG_SV = "sv"
    private const val DEFAULT_LANG = "en"
}
