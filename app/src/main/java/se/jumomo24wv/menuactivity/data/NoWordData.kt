package se.jumomo24wv.menuactivity.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoWordQuestion(
    val answer: String,
    val url: String,
    val points: Int
): Parcelable

object NoWordData {

    val noWord200 = listOf(
        NoWordQuestion(
            answer = "Brown Bear",
            url = "https://mohamedlutfi.github.io/noword-pages/bear.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Bee",
            url = "https://mohamedlutfi.github.io/noword-pages/bee.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Banana",
            url = "https://mohamedlutfi.github.io/noword-pages/banana.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Golden Crown",
            url = "https://mohamedlutfi.github.io/noword-pages/goldcrown.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Ice",
            url = "https://mohamedlutfi.github.io/noword-pages/ice.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Mirror",
            url = "https://mohamedlutfi.github.io/noword-pages/mirror.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Snowman",
            url = "https://mohamedlutfi.github.io/noword-pages/snowman.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Robot Arm",
            url = "https://mohamedlutfi.github.io/noword-pages/robotarm.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Pirate Hat",
            url = "https://mohamedlutfi.github.io/noword-pages/piratehat.html",
            points = 200
        ),
        NoWordQuestion(
            answer = "Sea Turtle",
            url = "https://mohamedlutfi.github.io/noword-pages/seaturtle.html",
            points = 200
        ),
    )

    val noWord400 = listOf(
        NoWordQuestion(
            answer = "Armor",
            url = "https://mohamedlutfi.github.io/noword-pages/armor.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Astronaut",
            url = "https://mohamedlutfi.github.io/noword-pages/astronaut.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Batman",
            url = "https://mohamedlutfi.github.io/noword-pages/batman.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Cactus",
            url = "https://mohamedlutfi.github.io/noword-pages/cactus.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Candle",
            url = "https://mohamedlutfi.github.io/noword-pages/candle.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Detective",
            url = "https://mohamedlutfi.github.io/noword-pages/detective.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Hacker",
            url = "https://mohamedlutfi.github.io/noword-pages/hacker.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Lightning",
            url = "https://mohamedlutfi.github.io/noword-pages/lightning.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Pancakes",
            url = "https://mohamedlutfi.github.io/noword-pages/pancackes.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Popcorn Machine",
            url = "https://mohamedlutfi.github.io/noword-pages/popcorn.html",
            points = 400
        ),
        NoWordQuestion(
            answer = "Treasuremap",
            url = "https://mohamedlutfi.github.io/noword-pages/treasuremap.html",
            points = 400
        ),

    )

    val noWord600 = listOf(
        NoWordQuestion(
            answer = "Ufo",
            url = "https://mohamedlutfi.github.io/noword-pages/ufo.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Skydiver",
            url = "https://mohamedlutfi.github.io/noword-pages/skydiver.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Secret Agent",
            url = "https://mohamedlutfi.github.io/noword-pages/secretagent.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Nuclear Bomb",
            url = "https://mohamedlutfi.github.io/noword-pages/nuclearbomb.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Magic Wand",
            url = "https://mohamedlutfi.github.io/noword-pages/magicwand.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Helicopter Pilot",
            url = "https://mohamedlutfi.github.io/noword-pages/helicopterpilot.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Fruit Salad",
            url = "https://mohamedlutfi.github.io/noword-pages/fruitsalad.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Dragon Egg",
            url = "https://mohamedlutfi.github.io/noword-pages/dragonegg.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Black hole",
            url = "https://mohamedlutfi.github.io/noword-pages/blackhole.html",
            points = 600
        ),
        NoWordQuestion(
            answer = "Bush",
            url = "https://mohamedlutfi.github.io/noword-pages/bush.html",
            points = 600
        ),
    )
}
