package se.jumomo24wv.menuactivity.data

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

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
        applyLanguage(lang)
    }

    /**
     * Applies the language globally using AppCompatDelegate.
     * This handles RTL support and UI updates automatically.
     */
    fun applyLanguage(lang: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(lang)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

    fun isSwedish(context: Context): Boolean = getLanguage(context) == LANG_SV
    fun isArabic(context: Context): Boolean = getLanguage(context) == LANG_AR

    const val LANG_SV = "sv"
    const val LANG_AR = "ar"
    const val DEFAULT_LANG = "en"
}
