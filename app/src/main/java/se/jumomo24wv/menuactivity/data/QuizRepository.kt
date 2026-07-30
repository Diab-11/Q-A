package se.jumomo24wv.menuactivity.data

import android.content.Context
import se.jumomo24wv.menuactivity.R

/**
 * Central registry for every quiz category in the game.
 *
 * - ALL_CATEGORIES holds the fixed, language-independent internal keys used
 *   throughout the app (selection screen, MainGame slots, bonus logic).
 * - "No Word" is intentionally NOT included here: it is always part of every
 *   game and is handled separately in MainGame (own layout, own mechanic).
 *
 * To add a new selectable category to the game:
 * 1. Add its easy/medium/hard question lists to QuizData / QuizDataSV / QuizDataAR
 *    in QuizModel.kt (matching naming convention, e.g. myCategoryEasy).
 * 2. Add its key to ALL_CATEGORIES below.
 * 3. Add a "<key>DisplayNameRes" entry to displayNameRes below.
 * 4. Add a "..._category" string resource to strings.xml (values / values-sv / values-ar).
 */
object QuizRepository {

    val ALL_CATEGORIES: List<String> = listOf(
        "Flags and Countries",
        "Geography",
        "Cars",
        "Common Knowledge",
        "Sports",
        "History",
        "Movies",
        "Science"
    )

    const val CATEGORIES_TO_PICK = 6

    private val displayNameRes: Map<String, Int> = mapOf(
        "Flags and Countries" to R.string.flags_countries_category,
        "Geography" to R.string.geography_category,
        "Cars" to R.string.cars_category,
        "Common Knowledge" to R.string.common_knowledge_category,
        "Sports" to R.string.sports_category,
        "History" to R.string.history_category,
        "Movies" to R.string.movies_category,
        "Science" to R.string.science_category
    )

    fun displayName(context: Context, categoryKey: String): String {
        val resId = displayNameRes[categoryKey] ?: return categoryKey
        return context.getString(resId)
    }

    /**
     * difficulty must be one of "easy", "medium", "hard" (matches point buttons
     * 200 / 400 / 600 respectively).
     */
    fun getPool(context: Context, categoryKey: String, difficulty: String): List<QuizQuestion> {
        val useArabic = LanguageManager.isArabic(context)
        val useSwedish = LanguageManager.isSwedish(context)

        return when (categoryKey) {
            "Flags and Countries" -> when {
                useArabic -> pick(difficulty, QuizDataAR.flagsEasy, QuizDataAR.flagsMedium, QuizDataAR.flagsHard)
                useSwedish -> pick(difficulty, QuizDataSV.flagsEasy, QuizDataSV.flagsMedium, QuizDataSV.flagsHard)
                else -> pick(difficulty, QuizData.flagsEasy, QuizData.flagsMedium, QuizData.flagsHard)
            }
            "Geography" -> when {
                useArabic -> pick(difficulty, QuizDataAR.geographyEasy, QuizDataAR.geographyMedium, QuizDataAR.geographyHard)
                useSwedish -> pick(difficulty, QuizDataSV.geographyEasy, QuizDataSV.geographyMedium, QuizDataSV.geographyHard)
                else -> pick(difficulty, QuizData.geographyEasy, QuizData.geographyMedium, QuizData.geographyHard)
            }
            "Cars" -> when {
                useArabic -> pick(difficulty, QuizDataAR.carsEasy, QuizDataAR.carsMedium, QuizDataAR.carsHard)
                useSwedish -> pick(difficulty, QuizDataSV.carsEasy, QuizDataSV.carsMedium, QuizDataSV.carsHard)
                else -> pick(difficulty, QuizData.carsEasy, QuizData.carsMedium, QuizData.carsHard)
            }
            "Common Knowledge" -> when {
                useArabic -> pick(difficulty, QuizDataAR.commonKnowledgeEasy, QuizDataAR.commonKnowledgeMedium, QuizDataAR.commonKnowledgeHard)
                useSwedish -> pick(difficulty, QuizDataSV.commonKnowledgeEasy, QuizDataSV.commonKnowledgeMedium, QuizDataSV.commonKnowledgeHard)
                else -> pick(difficulty, QuizData.commonKnowledgeEasy, QuizData.commonKnowledgeMedium, QuizData.commonKnowledgeHard)
            }
            "Sports" -> when {
                useArabic -> pick(difficulty, QuizDataAR.sportsEasy, QuizDataAR.sportsMedium, QuizDataAR.sportsHard)
                useSwedish -> pick(difficulty, QuizDataSV.sportsEasy, QuizDataSV.sportsMedium, QuizDataSV.sportsHard)
                else -> pick(difficulty, QuizData.sportsEasy, QuizData.sportsMedium, QuizData.sportsHard)
            }
            "History" -> when {
                useArabic -> pick(difficulty, QuizDataAR.historyEasy, QuizDataAR.historyMedium, QuizDataAR.historyHard)
                useSwedish -> pick(difficulty, QuizDataSV.historyEasy, QuizDataSV.historyMedium, QuizDataSV.historyHard)
                else -> pick(difficulty, QuizData.historyEasy, QuizData.historyMedium, QuizData.historyHard)
            }
            "Movies" -> when {
                useArabic -> pick(difficulty, QuizDataAR.moviesEasy, QuizDataAR.moviesMedium, QuizDataAR.moviesHard)
                useSwedish -> pick(difficulty, QuizDataSV.moviesEasy, QuizDataSV.moviesMedium, QuizDataSV.moviesHard)
                else -> pick(difficulty, QuizData.moviesEasy, QuizData.moviesMedium, QuizData.moviesHard)
            }
            "Science" -> when {
                useArabic -> pick(difficulty, QuizDataAR.scienceEasy, QuizDataAR.scienceMedium, QuizDataAR.scienceHard)
                useSwedish -> pick(difficulty, QuizDataSV.scienceEasy, QuizDataSV.scienceMedium, QuizDataSV.scienceHard)
                else -> pick(difficulty, QuizData.scienceEasy, QuizData.scienceMedium, QuizData.scienceHard)
            }
            else -> emptyList()
        }
    }

    private fun pick(
        difficulty: String,
        easy: List<QuizQuestion>,
        medium: List<QuizQuestion>,
        hard: List<QuizQuestion>
    ): List<QuizQuestion> = when (difficulty) {
        "easy" -> easy
        "medium" -> medium
        else -> hard
    }
}
