package se.jumomo24wv.menuactivity.data

data class NoWordQuestion(
    val category: String = "No Word",
    val answer: String,   // t.ex. "easy", "medium", "hard"
    val url: String,          // länken till din GitHub-sida
    val points: Int           // 200 / 400 / 600
)


object NoWordData {

    val noWord200 = listOf(
        NoWordQuestion(
            answer = "Brown Bear",
            url = "https://mohamedlutfi.github.io/noword-pages/bear.html",
            points = 200
        ),
        // fler 200-kort...
    )

    val noWord400 = listOf(
        NoWordQuestion(
            answer = "doctor",
            url = "https://dittnamn.github.io/noword-pages/doctor.html",
            points = 400
        )
        // ...
    )

    val noWord600 = listOf(
        NoWordQuestion(
            answer = "pilot",
            url = "https://dittnamn.github.io/noword-pages/helicopter_pilot.html",
            points = 600
        )
        // ...
    )
}
