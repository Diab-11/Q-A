package se.jumomo24wv.menuactivity.data


import se.jumomo24wv.menuactivity.R // <-- CORRECT IMPORT
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// ... rest of your code



@Parcelize
data class QuizQuestion(
    val category: String,
    val difficulty: String,
    val question: String,
    val imageRes: Int? = null,
    val answer: String,
    val points: Int
) : Parcelable



object QuizData {

    val flagsEasy = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.france,
            answer = "France",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.canda,
            answer = "Canada",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "What is the capital city of Japan?",
            imageRes = R.drawable.tokyo,
            answer = "Tokyo",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country’s flag consists of green, white, and orange vertical stripes?",
            imageRes = R.drawable.ireland,
            answer = "Ireland",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.japanflag,
            answer = "Japan",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country has Brasília as its capital?",
            imageRes = R.drawable.brazilia,
            answer = "Brazil",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.usa_flag,
            answer = "United States",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "What is the capital city of Egypt?",
            imageRes = R.drawable.cairo,
            answer = "Cairo",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_cuba,
            answer = "Cuba",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "The capital of Australia is not Sydney. What is it?",
            imageRes = R.drawable.canberra,
            answer = "Canberra",
            points = 200
        )
    )
    val flagsMedium = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which African country’s flag features a golden star within a blue triangle and green–red stripes?",
            imageRes = R.drawable.flag_mozambique,
            answer = "Mozambique",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "The capital city of Kazakhstan was renamed several times; what is its current official name?",
            imageRes = R.drawable.astana,
            answer = "Astana",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_palestine,
            answer = "Palestine",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_iraq,
            answer = "Irak",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "What is the administrative capital of Turkey?",
            imageRes = R.drawable.ankara,
            answer = "Ankara",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_syria,
            answer = "Syria",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_morocco,
            answer = "Morocco",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_thailand,
            answer = "Thailand",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country dose this flag belongs to?",
            imageRes = R.drawable.flag_somalia,
            answer = "Somalia",
            points = 400
        ),

        QuizQuestion(
        category = "Flags and Countries",
        difficulty = "hard",
        question = "Which country dose this flag belongs to?",
        imageRes = R.drawable.flag_sweden,
        answer = "Sweden",
        points = 400
    )
    )

    val flagsHard = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "What is the capital of New Zealand?",
            imageRes = R.drawable.wellington,
            answer = "Wellington",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which is the only country in the world with no official capital city?",
            imageRes = R.drawable.nauru,
            answer = "Nauru",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country contains the most islands in the world?",
            imageRes = R.drawable.island_sweden,
            answer = "Sweden",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which ocean is the saltiest?",
            imageRes = R.drawable.ocean,
            answer = "The Atlantic Ocean",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "This black, yellow, and white tricolor flag belonged to which former empire?",
            imageRes = R.drawable.flag_of_russian_empire,
            answer = "Russian Empire",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "What is the capital of Lebanon?",
            imageRes = R.drawable.beriut,
            answer = "Beirut",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Where is the city of Bethlehem located?",
            imageRes = R.drawable.betlahim,
            answer = "In Palestine",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Where is the first university in the world located?",
            imageRes = R.drawable.uni_morocco,
            answer = "In Morocco ",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "What is the capital city of Colombia?",
            imageRes = R.drawable.bogota,
            answer = "Bogota",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "What is the oldest capital in the world?",
            imageRes = R.drawable.damascus,
            answer = "Damascus",
            points = 600
        )

    )
    // -------------------------
// CATEGORY 2: GEOGRAPHY
// -------------------------

    val geographyEasy = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Which city is home to the Eiffel Tower?",
            imageRes = R.drawable.eiffel,
            answer = "Paris",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Which country is famous for the pyramids of Giza?",
            imageRes = R.drawable.pyramids,
            answer = "Egypt",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Mount Everest lies on the border of Nepal and which country?",
            imageRes = R.drawable.mount_everest,
            answer = "China",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Which continent is the Sahara Desert located in?",
            imageRes = R.drawable.sahara,
            answer = "Africa",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "What is the capital of Italy?",
            imageRes = R.drawable.rome,
            answer = "Rome",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Which famous statue stands in New York Harbor?",
            imageRes = R.drawable.statue_hero,
            answer = "Statue of Liberty",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Which country is known as the Land of the Rising Sun?",
            imageRes = R.drawable.sun,
            answer = "Japan",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "What is the largest ocean on Earth?",
            imageRes = R.drawable.ocean,
            answer = "Pacific Ocean",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "What is biggest city in the world?",
            imageRes = R.drawable.japan1,
            answer = "Tokyo",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "What is the smallest continent in the world?",
            imageRes = R.drawable.map7,
            answer = "Australia",
            points = 200
        )
    )

    val geographyMedium = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which African country has the highest population?",
            imageRes = R.drawable.map_africa,
            answer = "Nigeria",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "What is the largest state in the United States?",
            imageRes = R.drawable.usa_map,
            answer = "Alaska",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "What is the world’s longest river?",
            imageRes = R.drawable.nile_river,
            answer = "Nile River",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which river is the longest in Europe?",
            imageRes = R.drawable.volga,
            answer = "Volga River",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which country owns the island of Greenland?",
            imageRes = R.drawable.grenland,
            answer = "Denmark",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which country has the most time zones?",
            imageRes = R.drawable.timezone,
            answer = "France",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which country has the largest Muslim population in the world?",
            imageRes = R.drawable.muslim,
            answer = "Indonesia",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "What country is home to the Amazon Rainforest (largest portion)?",
            imageRes = R.drawable.amazon,
            answer = "Brazil",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Which European mountain range runs through Switzerland, France, and Italy?",
            imageRes = R.drawable.alps,
            answer = "The Alps",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "In which country can you find the ancient city of Petra?",
            imageRes = R.drawable.petra,
            answer = "Jordan",
            points = 400
        )
    )

    val geographyHard = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Which country is home to the K2 mountain peak?",
            imageRes = R.drawable.k2,
            answer = "Pakistan",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "What is the least populated sovereign country in the world?",
            imageRes = R.drawable.vatican_city,
            answer = "Vatican City",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Which river flows through the Grand Canyon?",
            imageRes = R.drawable.colorado_river,
            answer = "Colorado River",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "What is the world’s largest non-polar desert?",
            imageRes = R.drawable.sahara,
            answer = "Sahara Desert",
            points = 600
        ),

        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Which country has the most UNESCO World Heritage Sites?",
            imageRes = R.drawable.itlay,
            answer = "Italy",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Which city is located exactly where the Blue Nile and White Nile meet?",
            imageRes = R.drawable.khartoum,
            answer = "Khartoum",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "What is the area of Sweden?",
            imageRes = R.drawable.sweden_map,
            answer = "449,964 square kilometers",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "What is the area of Denmark?",
            imageRes = R.drawable.denmark_map,
            answer = "42,933 square kilometers",
            points = 600
        ),
    )
    // ----------------------------
// CATEGORY: Cars
// ----------------------------


    val carsEasy = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which company manufactures the Civic?",
            answer = "Honda",
            points = 200,
            imageRes = R.drawable.honda_civic
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which car brand has a prancing horse as its logo?",
            answer = "Ferrari",
            points = 200,
            imageRes = R.drawable.ferrari
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which German brand makes the 3 Series?",
            answer = "BMW",
            points = 200,
            imageRes = R.drawable.bmw3series
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "What car brand uses four interlocking rings?",
            answer = "Audi",
            points = 200,
            imageRes = R.drawable.audi
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "What company produces the Mustang?",
            answer = "Ford",
            points = 200,
            imageRes = R.drawable.mustang
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which brand is known for the Beetle?",
            answer = "Volkswagen",
            points = 200,
            imageRes = R.drawable.beetle
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which country is Tesla based in?",
            answer = "United States",
            points = 200,
            imageRes = R.drawable.tesla
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "What type of car is the Toyota Prius known as?",
            answer = "Hybrid",
            points = 200,
            imageRes = R.drawable.prius
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which Italian company produces the Huracán?",
            answer = "Lamborghini",
            points = 200,
            imageRes = R.drawable.`huracan`
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Which brand makes the Corolla?",
            answer = "Toyota",
            points = 200,
            imageRes = R.drawable.corolla
        )
    )

    val carsMedium = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "What country manufactures the brand Volvo?",
            answer = "Sweden",
            points = 400,
            imageRes = R.drawable.volvo
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "What does 'GTI' stand for in performance cars?",
            answer = "Grand Touring Injection",
            points = 400,
            imageRes = R.drawable.gti
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which brand created the iconic Countach?",
            answer = "Lamborghini",
            points = 400,
            imageRes = R.drawable.countach
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which car uses the Quattro all-wheel drive system?",
            answer = "Audi",
            points = 400,
            imageRes = R.drawable.maserati
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which company makes the luxury brand Lexus?",
            answer = "Toyota",
            points = 400,
            imageRes = R.drawable.quattro
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which BMW car has a V10 engine?",
            answer = " BMW M5 E60",
            points = 400,
            imageRes = R.drawable.lexus
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which car uses the 4MATIC all-wheel drive system?",
            answer = "Mercedes-Benz",
            points = 400,
            imageRes = R.drawable.e60
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which brand's logo features a trident?",
            answer = "Maserati",
            points = 400,
            imageRes = R.drawable.mercedes_4matic
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "How many major car brands are owned by the Volkswagen Group ?",
            answer = "12",
            points = 400,
            imageRes = R.drawable.vw_group
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Approximately how much horsepower does the BMW F10 M5 have?",
            answer = "560 hp",
            points = 400,
            imageRes = R.drawable.bmw_f10
        )
    )

    val carsHard = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which Volkswagen Group brand is known for producing luxury hypercars like the Chiron?",
            answer = "Bugatti",
            points = 600,
            imageRes = R.drawable.f1_1990s
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the exact top speed of the Bugatti Chiron Super Sport 300+ in km/h?",
            answer = "490 km/h",
            points = 600,
            imageRes = R.drawable.vw_group
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which company did Nils Bohlin work for when he invented the three-point seatbelt?",
            answer = "Volvo",
            points = 600,
            imageRes = R.drawable.bugatti_chiron
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "When did the Hummer brand stop production?",
            answer = "2010",
            points = 600,
            imageRes = R.drawable.seat_belt
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which brand produced the rare supercar named the 'F1' in the 1990s?",
            answer = "McLaren",
            points = 600,
            imageRes = R.drawable.hummer
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which company was the first to use front windshield wipers?",
            answer = "Cadillac",
            points = 600,
            imageRes = R.drawable.gle
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Toyota model?",
            answer = "RAV4",
            points = 600,
            imageRes = R.drawable.cadillac
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Audi model?",
            answer = "Audi RQ8",
            points = 600,
            imageRes = R.drawable.rav4
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Mercedes model?",
            answer = "GLE Coupe",
            points = 600,
            imageRes = R.drawable.audi_rq8
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which Italian brand built the rare hypercar 'MC12'?",
            answer = "Maserati",
            points = 600,
            imageRes = R.drawable.mc12
        )
    )


    val commonKnowledgeEasy = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which planet has the fastest rotation speed in our solar system?",
            imageRes = null,
            answer = "Jupiter",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the largest organ in the human body?",
            imageRes = null,
            answer = "Skin",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which country is the largest by land area in the world?",
            imageRes = null,
            answer = "Russia",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which bird is known for its impressive mimicry skills and intelligence?",
            imageRes = null,
            answer = "Parrot",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the chemical formula of table salt?",
            imageRes = null,
            answer = "NaCl",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which natural disaster is measured with a Richter scale?",
            imageRes = null,
            answer = "Earthquake",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which ocean is the Bermuda Triangle located in?",
            imageRes = null,
            answer = "Atlantic Ocean",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the smallest prime number?",
            imageRes = null,
            answer = "2",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which famous scientist introduced the three laws of motion?",
            imageRes = null,
            answer = "Isaac Newton",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which country is famous for inventing the compass?",
            imageRes = null,
            answer = "China",
            points = 200
        )
    )

    val commonKnowledgeMedium = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "What is the term for animals that are active during twilight hours?",
            imageRes = null,
            answer = "Crepuscular",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which language has the most native speakers worldwide?",
            imageRes = null,
            answer = "Mandarin Chinese",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which chemical element has the highest melting point?",
            imageRes = null,
            answer = "Tungsten",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which planet has a moon called Titan?",
            imageRes = null,
            answer = "Saturn",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "In which year did the first human land on the Moon?",
            imageRes = null,
            answer = "1969",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which gas is primarily responsible for the greenhouse effect on Earth?",
            imageRes = null,
            answer = "Carbon dioxide",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which country was formerly known as Ceylon?",
            imageRes = null,
            answer = "Sri Lanka",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "What is the study of fungi called?",
            imageRes = null,
            answer = "Mycology",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which city is known as the 'City of a Hundred Spires'?",
            imageRes = null,
            answer = "Prague",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which metal is liquid at room temperature?",
            imageRes = null,
            answer = "Mercury",
            points = 400
        )
    )

    val commonKnowledgeHard = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which philosopher is famous for the statement 'I think, therefore I am'?",
            imageRes = null,
            answer = "René Descartes",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "What is the rarest naturally occurring element on Earth?",
            imageRes = null,
            answer = "Astatine",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which city is the headquarters of the European Union?",
            imageRes = null,
            answer = "Brussels",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which mammal is capable of true flight?",
            imageRes = null,
            answer = "Bat",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which is the only continent without reptiles or snakes?",
            imageRes = null,
            answer = "Antarctica",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "What is the study of ancient inscriptions called?",
            imageRes = null,
            answer = "Epigraphy",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which vitamin is produced when skin is exposed to sunlight?",
            imageRes = null,
            answer = "Vitamin D",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which European country has the longest continuous coastline?",
            imageRes = null,
            answer = "Norway",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "What is the largest internal organ by mass in the human body?",
            imageRes = null,
            answer = "Liver",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which mathematician is known for the Last Theorem proved in 1994?",
            imageRes = null,
            answer = "Pierre de Fermat",
            points = 600
        )
    )


    val sportsEasy = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport is known as 'the beautiful game'?",
            imageRes = null,
            answer = "Soccer",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "In which sport is a 'slam dunk' performed?",
            imageRes = null,
            answer = "Basketball",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "How many players are there in a standard volleyball team on the court?",
            imageRes = null,
            answer = "Six",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport uses a shuttlecock?",
            imageRes = null,
            answer = "Badminton",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport is associated with Wimbledon?",
            imageRes = null,
            answer = "Tennis",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "In which country were the first modern Olympics held?",
            imageRes = null,
            answer = "Greece",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport is played on an ice rink with a puck?",
            imageRes = null,
            answer = "Ice Hockey",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "In which sport would you perform a 'snatch' or 'clean and jerk'?",
            imageRes = null,
            answer = "Weightlifting",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport uses a pommel horse?",
            imageRes = null,
            answer = "Gymnastics",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport features the 'Heisman Trophy'?",
            imageRes = null,
            answer = "American Football",
            points = 200
        )
    )

    val sportsMedium = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which country won the FIFA World Cup in 2018?",
            imageRes = null,
            answer = "France",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which tennis player has won the most Grand Slam singles titles?",
            imageRes = null,
            answer = "Serena Williams",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "In Formula 1, how many wheels does a car have, including spare wheels?",
            imageRes = null,
            answer = "Four",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which sport has positions called 'skip', 'lead', and 'third'?",
            imageRes = null,
            answer = "Curling",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "In which country did the sport of judo originate?",
            imageRes = null,
            answer = "Japan",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which NFL team is known as 'The Patriots'?",
            imageRes = null,
            answer = "New England Patriots",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "In cricket, what is the term for a bowler taking three wickets in three consecutive balls?",
            imageRes = null,
            answer = "Hat-trick",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which Olympic event combines cross-country skiing and rifle shooting?",
            imageRes = null,
            answer = "Biathlon",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which country hosts the famous cycling race 'Tour de France'?",
            imageRes = null,
            answer = "France",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "In swimming, what is the term for a race done entirely underwater?",
            imageRes = null,
            answer = "Underwater swimming or dolphin kick",
            points = 400
        )
    )

    val sportsHard = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which country has won the most Olympic gold medals in men's ice hockey?",
            imageRes = null,
            answer = "Canada",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which golfer is nicknamed 'The Golden Bear'?",
            imageRes = null,
            answer = "Jack Nicklaus",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which sport has a move called the 'Iron Cross'?",
            imageRes = null,
            answer = "Gymnastics (on rings)",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "In rugby, what is the maximum number of players allowed on the field per team?",
            imageRes = null,
            answer = "15",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which NBA player is known as 'The Black Mamba'?",
            imageRes = null,
            answer = "Kobe Bryant",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which country won the first ever FIFA World Cup in 1930?",
            imageRes = null,
            answer = "Uruguay",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which Olympic event consists of fencing, swimming, equestrian show jumping, shooting, and running?",
            imageRes = null,
            answer = "Modern Pentathlon",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "In Formula 1, who holds the record for the most World Drivers’ Championships?",
            imageRes = null,
            answer = "Lewis Hamilton / Michael Schumacher (tie, 7 titles each)",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which country hosts the annual tennis tournament known as the Queen’s Club Championships?",
            imageRes = null,
            answer = "United Kingdom",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "In boxing, what is the term for a fight where no gloves are worn?",
            imageRes = null,
            answer = "Bare-knuckle boxing",
            points = 600
        )
    )




}


