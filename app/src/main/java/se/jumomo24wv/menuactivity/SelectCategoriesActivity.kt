package se.jumomo24wv.menuactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import se.jumomo24wv.menuactivity.data.QuizRepository
import se.jumomo24wv.menuactivity.databinding.ActivitySelectCategoriesBinding

/**
 * Lets both teams jointly pick exactly CATEGORIES_TO_PICK quiz categories
 * out of the full pool before the board is built in MainGame.
 * "No Word" is just another entry in the pool here — teams can pick it or
 * leave it out like any other category.
 */
class SelectCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectCategoriesBinding

    // Keeps selection order stable and prevents duplicates.
    private val selectedCategories = LinkedHashSet<String>()

    private lateinit var toggleButtons: List<MaterialButton>
    private lateinit var categoryForButton: Map<MaterialButton, String>

    private var team1Name: String? = null
    private var team2Name: String? = null
    private var gameName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        team1Name = intent.getStringExtra(CreateGame.ARG_TXT1)
        team2Name = intent.getStringExtra(CreateGame.ARG_TXT2)
        gameName = intent.getStringExtra(CreateGame.ARG_GAMETXT)

        toggleButtons = listOf(
            binding.categoryToggle1,
            binding.categoryToggle2,
            binding.categoryToggle3,
            binding.categoryToggle4,
            binding.categoryToggle5,
            binding.categoryToggle6,
            binding.categoryToggle7,
            binding.categoryToggle8,
            binding.categoryToggle9
        )

        val categories = QuizRepository.ALL_CATEGORIES
        val mapping = mutableMapOf<MaterialButton, String>()

        toggleButtons.forEachIndexed { index, button ->
            val categoryKey = categories.getOrNull(index) ?: return@forEachIndexed
            mapping[button] = categoryKey
            button.text = QuizRepository.displayName(this, categoryKey)
            button.setOnClickListener { onCategoryToggled(button, categoryKey) }
        }
        categoryForButton = mapping

        updateCounterAndContinueButton()

        binding.selectCategoriesContinueBtn.setOnClickListener {
            startGameWithSelectedCategories()
        }
    }

    private fun onCategoryToggled(button: MaterialButton, categoryKey: String) {
        if (selectedCategories.contains(categoryKey)) {
            selectedCategories.remove(categoryKey)
            setButtonSelected(button, false)
        } else {
            if (selectedCategories.size >= QuizRepository.CATEGORIES_TO_PICK) {
                Toast.makeText(
                    this,
                    getString(R.string.select_categories_limit_reached, QuizRepository.CATEGORIES_TO_PICK),
                    Toast.LENGTH_SHORT
                ).show()
                return
            }
            selectedCategories.add(categoryKey)
            setButtonSelected(button, true)
        }
        updateCounterAndContinueButton()
    }

    private fun setButtonSelected(button: MaterialButton, selected: Boolean) {
        val colorRes = if (selected) R.color.ripplePrimary else R.color.Secondary
        button.setBackgroundColor(getColor(colorRes))
    }

    private fun updateCounterAndContinueButton() {
        binding.selectCategoriesCounter.text = getString(
            R.string.select_categories_counter,
            selectedCategories.size,
            QuizRepository.CATEGORIES_TO_PICK
        )
        binding.selectCategoriesContinueBtn.isEnabled =
            selectedCategories.size == QuizRepository.CATEGORIES_TO_PICK
    }

    private fun startGameWithSelectedCategories() {
        if (selectedCategories.size != QuizRepository.CATEGORIES_TO_PICK) return

        val intent = Intent(this, MainGame::class.java).apply {
            putExtra(CreateGame.ARG_TXT1, team1Name)
            putExtra(CreateGame.ARG_TXT2, team2Name)
            putExtra(CreateGame.ARG_GAMETXT, gameName)
            putStringArrayListExtra(EXTRA_SELECTED_CATEGORIES, ArrayList(selectedCategories))
        }
        startActivity(intent)
        finish()
    }

    companion object {
        const val EXTRA_SELECTED_CATEGORIES = "SELECTED_CATEGORIES"
    }
}
