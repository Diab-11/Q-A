package se.jumomo24wv.menuactivity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import se.jumomo24wv.menuactivity.R

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
        val score = intent.getIntExtra("WINNER_SCORE", 0)

        // Sätt text
        findViewById<android.widget.TextView>(R.id.winner_textview).text = name
        findViewById<android.widget.TextView>(R.id.winner_score_textview).text = "Score: $score"

        // Startläge för animation
        trophy.scaleX = 0.6f
        trophy.scaleY = 0.6f
        congrats.translationY = 25f
        winnerText.translationY = 25f
        winnerScore.translationY = 25f
        backBtn.translationY = 25f

        // Trophy pop + fade
        val trophyFade = ObjectAnimator.ofFloat(trophy, View.ALPHA, 0f, 1f).setDuration(220)
        val trophyScaleX = ObjectAnimator.ofFloat(trophy, View.SCALE_X, 0.6f, 1f).setDuration(360)
        val trophyScaleY = ObjectAnimator.ofFloat(trophy, View.SCALE_Y, 0.6f, 1f).setDuration(360)
        trophyScaleX.interpolator = OvershootInterpolator(1.1f)
        trophyScaleY.interpolator = OvershootInterpolator(1.1f)

        // Text slide in + fade (stagger)
        fun fadeSlide(v: View, delay: Long): AnimatorSet {
            val fade = ObjectAnimator.ofFloat(v, View.ALPHA, 0f, 1f).setDuration(240)
            val slide = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 25f, 0f).setDuration(240)
            return AnimatorSet().apply {
                startDelay = delay
                playTogether(fade, slide)
            }
        }

        val a1 = fadeSlide(congrats, 180)
        val a2 = fadeSlide(winnerText, 320)
        val a3 = fadeSlide(winnerScore, 460)
        val a4 = fadeSlide(backBtn, 620)

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
}
