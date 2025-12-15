package se.jumomo24wv.menuactivity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity

class WinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val trophy = findViewById<View>(R.id.trophyIcon)
        val congrats = findViewById<View>(R.id.Congrats)
        val winnerText = findViewById<View>(R.id.winner_textview)
        val winnerScore = findViewById<View>(R.id.winner_score_textview)
        val backBtn = findViewById<View>(R.id.go_back_button)

        requireNotNull(trophy) { "trophyIcon saknas i activity_winner.xml" }

        val name = intent.getStringExtra("WINNER_NAME") ?: "Winner"
        val score = intent.getIntExtra("WINNER_SCORE", DEFAULT_SCORE)

        // Sätt text
        findViewById<android.widget.TextView>(R.id.winner_textview).text = name
        findViewById<android.widget.TextView>(R.id.winner_score_textview).text = "Score: $score"

        // Startläge för animation
        trophy.scaleX = TROPHY_START_SCALE
        trophy.scaleY = TROPHY_START_SCALE

        congrats.translationY = SLIDE_START_TRANSLATION_Y
        winnerText.translationY = SLIDE_START_TRANSLATION_Y
        winnerScore.translationY = SLIDE_START_TRANSLATION_Y
        backBtn.translationY = SLIDE_START_TRANSLATION_Y

        // Trophy pop + fade
        val trophyFade = ObjectAnimator.ofFloat(trophy, View.ALPHA, ALPHA_ZERO, ALPHA_FULL)
            .setDuration(TROPHY_FADE_DURATION_MS)

        val trophyScaleX =
            ObjectAnimator.ofFloat(trophy, View.SCALE_X, TROPHY_START_SCALE, SCALE_FULL)
                .setDuration(TROPHY_SCALE_DURATION_MS)

        val trophyScaleY =
            ObjectAnimator.ofFloat(trophy, View.SCALE_Y, TROPHY_START_SCALE, SCALE_FULL)
                .setDuration(TROPHY_SCALE_DURATION_MS)

        trophyScaleX.interpolator = OvershootInterpolator(TROPHY_OVERSHOOT_TENSION)
        trophyScaleY.interpolator = OvershootInterpolator(TROPHY_OVERSHOOT_TENSION)

        // Text slide in + fade (stagger)
        fun fadeSlide(v: View, delay: Long): AnimatorSet {
            val fade = ObjectAnimator.ofFloat(v, View.ALPHA, ALPHA_ZERO, ALPHA_FULL)
                .setDuration(TEXT_ANIM_DURATION_MS)
            val slide = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, SLIDE_START_TRANSLATION_Y, TRANSLATION_Y_END)
                .setDuration(TEXT_ANIM_DURATION_MS)

            return AnimatorSet().apply {
                startDelay = delay
                playTogether(fade, slide)
            }
        }

        val a1 = fadeSlide(congrats, DELAY_CONGRATS_MS)
        val a2 = fadeSlide(winnerText, DELAY_NAME_MS)
        val a3 = fadeSlide(winnerScore, DELAY_SCORE_MS)
        val a4 = fadeSlide(backBtn, DELAY_BACK_MS)

        AnimatorSet().apply {
            playTogether(
                trophyFade,
                trophyScaleX,
                trophyScaleY,
                a1, a2, a3, a4
            )
            start()
        }

        backBtn.setOnClickListener { finish() }
    }

    companion object {
        private const val DEFAULT_SCORE = 0

        private const val ALPHA_ZERO = 0f
        private const val ALPHA_FULL = 1f

        private const val TROPHY_START_SCALE = 0.6f
        private const val SCALE_FULL = 1f

        private const val SLIDE_START_TRANSLATION_Y = 25f
        private const val TRANSLATION_Y_END = 0f

        private const val TROPHY_FADE_DURATION_MS = 220L
        private const val TROPHY_SCALE_DURATION_MS = 360L
        private const val TEXT_ANIM_DURATION_MS = 240L

        private const val TROPHY_OVERSHOOT_TENSION = 1.1f

        private const val DELAY_CONGRATS_MS = 180L
        private const val DELAY_NAME_MS = 320L
        private const val DELAY_SCORE_MS = 460L
        private const val DELAY_BACK_MS = 620L
    }
}
