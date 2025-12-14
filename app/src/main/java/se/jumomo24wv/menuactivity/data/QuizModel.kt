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
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.france,
            answer = "France",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country does this flag belongs to?",
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
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.ireland,
            answer = "Ireland",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Which country does this flag belongs to?",
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
            question = "Which country does this flag belongs to?",
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
            question = "Which country does this flag belongs to?",
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
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.flag_palestine,
            answer = "Palestine",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country does this flag belongs to?",
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
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.flag_syria,
            answer = "Syria",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.flag_morocco,
            answer = "Morocco",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.flag_thailand,
            answer = "Thailand",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Which country does this flag belongs to?",
            imageRes = R.drawable.flag_somalia,
            answer = "Somalia",
            points = 400
        ),

        QuizQuestion(
        category = "Flags and Countries",
        difficulty = "hard",
        question = "Which country does this flag belongs to?",
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
            question = "What is approximate the area of Sweden? (nearest answer wins)",
            imageRes = R.drawable.sweden_map,
            answer = "449,964 square kilometers",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "What is the area of Denmark? (nearest answer wins)",
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
            imageRes = R.drawable.huracan
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
            imageRes = R.drawable.quattro
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which company makes the luxury brand Lexus?",
            answer = "Toyota",
            points = 400,
            imageRes = R.drawable.lexus
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which BMW car has a V10 engine?",
            answer = " BMW M5 E60",
            points = 400,
            imageRes = R.drawable.e60
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which car uses the 4MATIC all-wheel drive system?",
            answer = "Mercedes-Benz",
            points = 400,
            imageRes = R.drawable.mercedes_4matic
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Which brand's logo features a trident?",
            answer = "Maserati",
            points = 400,
            imageRes = R.drawable.maserati
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
            imageRes = R.drawable.bugatti_chiron
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which company did Nils Bohlin work for when he invented the three-point seatbelt?",
            answer = "Volvo",
            points = 600,
            imageRes = R.drawable.volvo
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "When did the Hummer brand stop production?",
            answer = "2010",
            points = 600,
            imageRes = R.drawable.hummer
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which brand produced the rare supercar named the 'F1' in the 1990s?",
            answer = "McLaren",
            points = 600,
            imageRes = R.drawable.f1_1990s
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Which company was the first to use front windshield wipers?",
            answer = "Cadillac",
            points = 600,
            imageRes = R.drawable.cadillac
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Toyota model?",
            answer = "RAV4",
            points = 600,
            imageRes = R.drawable.rav4
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Audi model?",
            answer = "Audi RQ8",
            points = 600,
            imageRes = R.drawable.audi_rq8
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "What is the name of this Mercedes model?",
            answer = "GLE Coupe",
            points = 600,
            imageRes = R.drawable.gle
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
            question = "What is the largest planet in the solar system?",
            imageRes = R.drawable.solar_system,
            answer = "Jupiter",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the largest organ in the human body?",
            imageRes = R.drawable.skin,
            answer = "Skin",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which country is the largest by land area in the world?",
            imageRes = R.drawable.map_of_world,
            answer = "Russia",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which bird is known for its impressive mimicry skills and intelligence?",
            imageRes = R.drawable.animals,
            answer = "Parrot",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the chemical formula of table salt?",
            imageRes = R.drawable.periodic_table,
            answer = "NaCl",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which natural disaster is measured with a Richter scale?",
            imageRes = R.drawable.natural_disater,
            answer = "Earthquake",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which ocean is the Bermuda Triangle located in?",
            imageRes = R.drawable.oceans,
            answer = "Atlantic Ocean",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "What is the smallest prime number?",
            imageRes = R.drawable.math,
            answer = "2",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which famous scientist introduced the three laws of motion?",
            imageRes = R.drawable.three_laws,
            answer = "Isaac Newton",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Which country is the world’s largest producer of rice",
            imageRes = R.drawable.rice,
            answer = "China",
            points = 200
        )
    )

    val commonKnowledgeMedium = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "In which year was Palestine fully occupied by Israel",
            imageRes = R.drawable.palestine1948,
            answer = "1948",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which language has the most native speakers worldwide?",
            imageRes = R.drawable.mandarin,
            answer = "Mandarin Chinese",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "When did the Syrian uprising against Bashar al-Assad begin?",
            imageRes = R.drawable.syrian_uprising,
            answer = "March 2011",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Who was the first person to attempt flight using artificial wings in the 9th century",
            imageRes = R.drawable.abbas,
            answer = "Abbas Ibn Firnas",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "In which year did the first human land on the Moon?",
            imageRes = R.drawable.moon,
            answer = "1969",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which are the main Scandinavian countries",
            imageRes = R.drawable.scandinavian,
            answer = "Sweden, Norway, Denmark، Finland and Iceland",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "What compound do plants produce during photosynthesis that serves as an energy source ?",
            imageRes = R.drawable.photosynthesis,
            answer = "Glucose",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which country invented Bluetooth technology",
            imageRes = R.drawable.bluetooth,
            answer = "Sweden",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "When was the last time Sweden participated in an actual war?",
            imageRes = R.drawable.sweden1814,
            answer = "1814",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Which country is considered the capital of luxury perfumes?",
            imageRes = R.drawable.perfumes,
            answer = "France",
            points = 400
        )
    )

    val commonKnowledgeHard = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which philosopher is famous for the statement 'I think, therefore I am'?",
            imageRes = R.drawable.rene_descartes,
            answer = "René Descartes",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "What is the rarest naturally occurring element on Earth?",
            imageRes = R.drawable.periodic_table,
            answer = "Astatine",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which city is the headquarters of the European Union?",
            imageRes = R.drawable.eu,
            answer = "Brussels",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which mammal is capable of true flight?",
            imageRes = R.drawable.animals,
            answer = "Bat",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which is the only continent without reptiles or snakes?",
            imageRes = R.drawable.oceans,
            answer = "Antarctica",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "In which year did Napoleon Bonaparte die?",
            imageRes = R.drawable.napoleon,
            answer = "1821",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which vitamin is produced when skin is exposed to sunlight?",
            imageRes = R.drawable.sun,
            answer = "Vitamin D",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Which European country has the longest continuous coastline?",
            imageRes = R.drawable.coastline,
            answer = "Norway",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "What is the largest internal organ by mass in the human body?",
            imageRes = R.drawable.skin,
            answer = "Liver",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "During which years did World War I take place",
            imageRes = R.drawable.world_war1,
            answer = "1914 – 1918",
            points = 600
        )
    )


    val sportsEasy = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport is known as 'the beautiful game'?",
            imageRes = R.drawable.allsports,
            answer = "Football",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "In which sport is a 'slam dunk' performed?",
            imageRes = R.drawable.allsports,
            answer = "Basketball",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "How many players are there in a standard volleyball team on the court?",
            imageRes = R.drawable.volleyball,
            answer = "Six",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport uses a shuttlecock?",
            imageRes = R.drawable.shuttlecock,
            answer = "Badminton",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which football club has won the most UEFA Champions League titles?",
            imageRes = R.drawable.champions,
            answer = "Real Madrid",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "What do the five rings in the Olympic logo represent?",
            imageRes = R.drawable.olympic,
            answer = "The five major continents",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport is played on an ice rink with a puck?",
            imageRes = R.drawable.ice_rink,
            answer = "Ice Hockey",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which country has won the most FIFA World Cup titles?",
            imageRes = R.drawable.world_cup,
            answer = "Brazil",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "How many losses has Islam Makhachev suffered in his UFC career so far?",
            imageRes = R.drawable.islam,
            answer = "One loss",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Which sport features the 'Heisman Trophy'?",
            imageRes = R.drawable.heisman_trophy,
            answer = "American Football",
            points = 200
        )
    )

    val sportsMedium = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which country won the FIFA World Cup in 2018?",
            imageRes = R.drawable.world_cup,
            answer = "France",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "How many UEFA Champions League titles has AC Milan won to date?",
            imageRes = R.drawable.ac_milan,
            answer = "7",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "When did FC Barcelona last win the UEFA Champions League?",
            imageRes = R.drawable.barca,
            answer = "2015",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which team does basketball player LeBron James currently play for?",
            imageRes = R.drawable.lebron_james,
            answer = "Los Angeles Lakers",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "In which country did the sport of judo originate?",
            imageRes = R.drawable.judo,
            answer = "Japan",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which club has won the most titles since the league was rebranded in 1992 ?",
            imageRes = R.drawable.premier_league,
            answer = "Manchester United",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "What is it called when a football player scores three goals in a single match?",
            imageRes = R.drawable.hat_trick,
            answer = "Hat-trick",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which basketball team has won the most NBA championships?",
            imageRes = R.drawable.nba_championship,
            answer = "Boston Celtics",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Which country hosts the famous cycling race 'Tour de France'?",
            imageRes = R.drawable.tour_de_france,
            answer = "France",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "What is the second most popular and widely played sport in Sweden after football?",
            imageRes = R.drawable.allsports,
            answer = "Ice Hockey",
            points = 400
        )
    )

    val sportsHard = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Who is the Swedish athlete who won a gold medal at the most recent Olympic Games?",
            imageRes = R.drawable.armand_duplantis,
            answer = "Armand Duplantis",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Where was the 2010 FIFA World Cup held?",
            imageRes = R.drawable.world_cup,
            answer = "South Africa",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "In which season did Cristiano Ronaldo score the most goals across all competitions?",
            imageRes = R.drawable.cr7,
            answer = "2014–2015",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Who is the all-time top scorer for the Swedish national football team?",
            imageRes = R.drawable.swedish_team,
            answer = "Zlatan Ibrahimović",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which Scandinavian national team has won the UEFA European Championship?",
            imageRes = R.drawable.european_championship,
            answer = "Denmark",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which country won the first ever FIFA World Cup in 1930?",
            imageRes = R.drawable.world_cup,
            answer = "Uruguay",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which Swedish club ranks second in most Allsvenskan (Swedish league) titles after Malmö?",
            imageRes = R.drawable.allsvenska,
            answer = "IFK Göteborg",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Which coach led Real Madrid to win three consecutive UEFA Champions League titles?",
            imageRes = R.drawable.champions,
            answer = "Zinedine Zidane",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "How many times has the Spanish national football team won the FIFA World Cup?",
            imageRes = R.drawable.world_cup,
            answer = "Once",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "In boxing, what is the term for a fight where no gloves are worn?",
            imageRes = R.drawable.bare_knuckle_boxing,
            answer = "Bare-knuckle boxing",
            points = 600
        )
    )

}


/// SWEDISH TRANSLATION #############################################################################################################################################

object QuizDataSV {

    val flagsEasy = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.france,
            answer = "Frankrike",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.canda,
            answer = "Kanada",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vad heter Japans huvudstad?",
            imageRes = R.drawable.tokyo,
            answer = "Tokyo",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.ireland,
            answer = "Irland",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.japanflag,
            answer = "Japan",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land har Brasília som huvudstad?",
            imageRes = R.drawable.brazilia,
            answer = "Brasilien",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.usa_flag,
            answer = "USA",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vad heter Egyptens huvudstad?",
            imageRes = R.drawable.cairo,
            answer = "Kairo",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_cuba,
            answer = "Kuba",
            points = 200
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "easy",
            question = "Australiens huvudstad är inte Sydney. Vad heter den?",
            imageRes = R.drawable.canberra,
            answer = "Canberra",
            points = 200
        )
    )

    val flagsMedium = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket afrikanskt land har en flagga med en gyllene stjärna i en blå triangel samt gröna och röda ränder?",
            imageRes = R.drawable.flag_mozambique,
            answer = "Moçambique",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Kazakstans huvudstad har bytt namn flera gånger – vad är dess nuvarande namn?",
            imageRes = R.drawable.astana,
            answer = "Astana",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_palestine,
            answer = "Palestina",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_iraq,
            answer = "Irak",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vad är Turkiets administrativa huvudstad?",
            imageRes = R.drawable.ankara,
            answer = "Ankara",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_syria,
            answer = "Syrien",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_morocco,
            answer = "Marocko",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_thailand,
            answer = "Thailand",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_somalia,
            answer = "Somalia",
            points = 400
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Vilket land tillhör denna flagga?",
            imageRes = R.drawable.flag_sweden,
            answer = "Sverige",
            points = 400
        )
    )

    val flagsHard = listOf(
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vad heter Nya Zeelands huvudstad?",
            imageRes = R.drawable.wellington,
            answer = "Wellington",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket är det enda landet i världen utan en officiell huvudstad?",
            imageRes = R.drawable.nauru,
            answer = "Nauru",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket land har flest öar i världen?",
            imageRes = R.drawable.island_sweden,
            answer = "Sverige",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilket hav är mest salt?",
            imageRes = R.drawable.ocean,
            answer = "Atlanten",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Denna svart-gul-vita trefärgade flagga tillhörde vilket tidigare imperium?",
            imageRes = R.drawable.flag_of_russian_empire,
            answer = "Ryska imperiet",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Vad heter Libanons huvudstad?",
            imageRes = R.drawable.beriut,
            answer = "Beirut",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Var ligger staden Betlehem?",
            imageRes = R.drawable.betlahim,
            answer = "I Palestina",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Var ligger världens första universitet?",
            imageRes = R.drawable.uni_morocco,
            answer = "I Marocko",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "hard",
            question = "Vad heter Colombias huvudstad?",
            imageRes = R.drawable.bogota,
            answer = "Bogotá",
            points = 600
        ),
        QuizQuestion(
            category = "Flags and Countries",
            difficulty = "medium",
            question = "Vilken är världens äldsta huvudstad?",
            imageRes = R.drawable.damascus,
            answer = "Damaskus",
            points = 600
        )
    )
    val geographyEasy = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilken stad är hem till Eiffeltornet?",
            imageRes = R.drawable.eiffel,
            answer = "Paris",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilket land är känt för pyramiderna i Giza?",
            imageRes = R.drawable.pyramids,
            answer = "Egypten",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Mount Everest ligger på gränsen mellan Nepal och vilket land?",
            imageRes = R.drawable.mount_everest,
            answer = "Kina",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "På vilken kontinent ligger Saharaöknen?",
            imageRes = R.drawable.sahara,
            answer = "Afrika",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vad är Italiens huvudstad?",
            imageRes = R.drawable.rome,
            answer = "Rom",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilken berömd staty står i New Yorks hamn?",
            imageRes = R.drawable.statue_hero,
            answer = "Frihetsgudinnan",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilket land kallas Solens uppgångs land?",
            imageRes = R.drawable.sun,
            answer = "Japan",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilket är det största havet på jorden?",
            imageRes = R.drawable.ocean,
            answer = "Stilla havet",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilken är världens största stad sett till befolkning?",
            imageRes = R.drawable.japan1,
            answer = "Tokyo",
            points = 200
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "easy",
            question = "Vilken är världens minsta kontinent?",
            imageRes = R.drawable.map7,
            answer = "Australien",
            points = 200
        )
    )

    val geographyMedium = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilket afrikanskt land har störst befolkning?",
            imageRes = R.drawable.map_africa,
            answer = "Nigeria",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilken är den största delstaten i USA?",
            imageRes = R.drawable.usa_map,
            answer = "Alaska",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilken är världens längsta flod?",
            imageRes = R.drawable.nile_river,
            answer = "Nilen",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilken flod är längst i Europa?",
            imageRes = R.drawable.volga,
            answer = "Volga",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilket land äger ön Grönland?",
            imageRes = R.drawable.grenland,
            answer = "Danmark",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilket land har flest tidszoner?",
            imageRes = R.drawable.timezone,
            answer = "Frankrike",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilket land har världens största muslimska befolkning?",
            imageRes = R.drawable.muslim,
            answer = "Indonesien",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilket land har den största delen av Amazonas regnskog?",
            imageRes = R.drawable.amazon,
            answer = "Brasilien",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "Vilken europeisk bergskedja sträcker sig genom Schweiz, Frankrike och Italien?",
            imageRes = R.drawable.alps,
            answer = "Alperna",
            points = 400
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "medium",
            question = "I vilket land ligger den antika staden Petra?",
            imageRes = R.drawable.petra,
            answer = "Jordanien",
            points = 400
        )
    )

    val geographyHard = listOf(
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilket land ligger berget K2 i?",
            imageRes = R.drawable.k2,
            answer = "Pakistan",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilket är världens minst befolkade självständiga land?",
            imageRes = R.drawable.vatican_city,
            answer = "Vatikanstaten",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilken flod rinner genom Grand Canyon?",
            imageRes = R.drawable.colorado_river,
            answer = "Coloradofloden",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilken är världens största icke-polära öken?",
            imageRes = R.drawable.sahara,
            answer = "Saharaöknen",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilket land har flest UNESCO-världsarv?",
            imageRes = R.drawable.itlay,
            answer = "Italien",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Vilken stad ligger där Blå Nilen och Vita Nilen möts?",
            imageRes = R.drawable.khartoum,
            answer = "Khartoum",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Hur stor är Sveriges yta?",
            imageRes = R.drawable.sweden_map,
            answer = "449 964 kvadratkilometer",
            points = 600
        ),
        QuizQuestion(
            category = "Geography",
            difficulty = "hard",
            question = "Hur stor är Danmarks yta?",
            imageRes = R.drawable.denmark_map,
            answer = "42 933 kvadratkilometer (närmaste svar vinner)",
            points = 600
        )
    )
    //sv cars

    val carsEasy = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket företag tillverkar Civic?",
            answer = "Honda",
            points = 200,
            imageRes = R.drawable.honda_civic
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket bilmärke har en stegrande häst som logotyp?",
            answer = "Ferrari",
            points = 200,
            imageRes = R.drawable.ferrari
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket tyskt bilmärke tillverkar 3-serien?",
            answer = "BMW",
            points = 200,
            imageRes = R.drawable.bmw3series
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket bilmärke använder fyra sammanlänkade ringar?",
            answer = "Audi",
            points = 200,
            imageRes = R.drawable.audi
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket företag producerar Mustang?",
            answer = "Ford",
            points = 200,
            imageRes = R.drawable.mustang
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket bilmärke är känt för modellen Beetle?",
            answer = "Volkswagen",
            points = 200,
            imageRes = R.drawable.beetle
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "I vilket land har Tesla sitt ursprung?",
            answer = "USA",
            points = 200,
            imageRes = R.drawable.tesla
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilken typ av bil är Toyota Prius känd för att vara?",
            answer = "Hybrid",
            points = 200,
            imageRes = R.drawable.prius
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket italienskt företag tillverkar Huracán?",
            answer = "Lamborghini",
            points = 200,
            imageRes = R.drawable.huracan
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "easy",
            question = "Vilket bilmärke tillverkar Corolla?",
            answer = "Toyota",
            points = 200,
            imageRes = R.drawable.corolla
        )
    )

    val carsMedium = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "I vilket land tillverkas bilmärket Volvo?",
            answer = "Sverige",
            points = 400,
            imageRes = R.drawable.volvo
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vad står \"GTI\" för inom prestandabilar?",
            answer = "Grand Touring Injection",
            points = 400,
            imageRes = R.drawable.gti
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilket bilmärke skapade den ikoniska Countach?",
            answer = "Lamborghini",
            points = 400,
            imageRes = R.drawable.countach
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilket bilmärke använder fyrhjulsdriften Quattro?",
            answer = "Audi",
            points = 400,
            imageRes = R.drawable.quattro
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilket företag äger lyxmärket Lexus?",
            answer = "Toyota",
            points = 400,
            imageRes = R.drawable.lexus
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilken BMW-modell har en V10-motor?",
            answer = "BMW M5 E60",
            points = 400,
            imageRes = R.drawable.e60
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilket bilmärke använder fyrhjulsdriften 4MATIC?",
            answer = "Mercedes-Benz",
            points = 400,
            imageRes = R.drawable.mercedes_4matic
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Vilket bilmärkes logotyp har en treudd?",
            answer = "Maserati",
            points = 400,
            imageRes = R.drawable.maserati
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Hur många stora bilmärken ägs av Volkswagen-koncernen?",
            answer = "12",
            points = 400,
            imageRes = R.drawable.vw_group
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "medium",
            question = "Ungefär hur många hästkrafter har BMW F10 M5?",
            answer = "560 hk",
            points = 400,
            imageRes = R.drawable.bmw_f10
        )
    )

    val carsHard = listOf(
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket märke inom Volkswagen-koncernen är känt för hyperbilar som Chiron?",
            answer = "Bugatti",
            points = 600,
            imageRes = R.drawable.f1_1990s
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vad är den exakta topphastigheten för Bugatti Chiron Super Sport 300+ i km/h?",
            answer = "490 km/h",
            points = 600,
            imageRes = R.drawable.bugatti_chiron
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket företag arbetade Nils Bohlin för när han uppfann trepunktsbältet?",
            answer = "Volvo",
            points = 600,
            imageRes = R.drawable.volvo
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket år slutade Hummer-märket sin produktion?",
            answer = "2010",
            points = 600,
            imageRes = R.drawable.hummer
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket bilmärke producerade den sällsynta superbilen \"F1\" på 1990-talet?",
            answer = "McLaren",
            points = 600,
            imageRes = R.drawable.f1_1990s
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket företag var först med vindrutetorkare fram?",
            answer = "Cadillac",
            points = 600,
            imageRes = R.drawable.cadillac
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vad heter denna Toyota-modell?",
            answer = "RAV4",
            points = 600,
            imageRes = R.drawable.rav4
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vad heter denna Audi-modell?",
            answer = "Audi RQ8",
            points = 600,
            imageRes = R.drawable.audi_rq8
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vad heter denna Mercedes-modell?",
            answer = "GLE Coupé",
            points = 600,
            imageRes = R.drawable.gle
        ),
        QuizQuestion(
            category = "Cars",
            difficulty = "hard",
            question = "Vilket italienskt bilmärke byggde den sällsynta hyperbilen \"MC12\"?",
            answer = "Maserati",
            points = 600,
            imageRes = R.drawable.mc12
        )
    )
    val commonKnowledgeEasy = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilken är den största planeten i solsystemet?",
            imageRes = R.drawable.solar_system,
            answer = "Jupiter",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilket är det största organet i människokroppen?",
            imageRes = R.drawable.skin,
            answer = "Huden",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilket land är störst till ytan i världen?",
            imageRes = R.drawable.map_of_world,
            answer = "Ryssland",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilken fågel är känd för sin imponerande förmåga att härma ljud och sin intelligens?",
            imageRes = R.drawable.animals,
            answer = "Papegoja",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vad är den kemiska formeln för bordssalt?",
            imageRes = R.drawable.periodic_table,
            answer = "NaCl",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilken naturkatastrof mäts med Richterskalan?",
            imageRes = R.drawable.natural_disater,
            answer = "Jordbävning",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "I vilket hav ligger Bermudatriangeln?",
            imageRes = R.drawable.oceans,
            answer = "Atlanten",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilket är det minsta primtalet?",
            imageRes = R.drawable.math,
            answer = "2",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilken berömd vetenskapsman formulerade de tre rörelselagarna?",
            imageRes = R.drawable.three_laws,
            answer = "Isaac Newton",
            points = 200
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "easy",
            question = "Vilket land är världens största producent av ris?",
            imageRes = R.drawable.rice,
            answer = "Kina",
            points = 200
        )
    )

    val commonKnowledgeMedium = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "År vilket år blev Palestina fullt ockuperat av Israel?",
            imageRes = R.drawable.palestine1948,
            answer = "1948",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilket språk har flest modersmålstalare i världen?",
            imageRes = R.drawable.mandarin,
            answer = "Mandarinkinesiska",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "När började det syriska upproret mot Bashar al-Assad?",
            imageRes = R.drawable.syrian_uprising,
            answer = "Mars 2011",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vem var den första personen som försökte flyga med konstgjorda vingar på 800-talet?",
            imageRes = R.drawable.abbas,
            answer = "Abbas Ibn Firnas",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilket år landade den första människan på månen?",
            imageRes = R.drawable.moon,
            answer = "1969",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilka länder räknas som de skandinaviska länderna?",
            imageRes = R.drawable.scandinavian,
            answer = "Sverige, Norge, Danmark, Finland och Island",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilken förening producerar växter under fotosyntesen som fungerar som energikälla?",
            imageRes = R.drawable.photosynthesis,
            answer = "Glukos",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilket land uppfann Bluetooth-tekniken?",
            imageRes = R.drawable.bluetooth,
            answer = "Sverige",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "När deltog Sverige senast i ett verkligt krig?",
            imageRes = R.drawable.sweden1814,
            answer = "1814",
            points = 400
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "medium",
            question = "Vilket land betraktas som världens huvudstad för lyxparfymer?",
            imageRes = R.drawable.perfumes,
            answer = "Frankrike",
            points = 400
        )
    )

    val commonKnowledgeHard = listOf(
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilken filosof är känd för uttrycket \"Jag tänker, alltså finns jag\"?",
            imageRes = R.drawable.rene_descartes,
            answer = "René Descartes",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket är det mest sällsynta naturligt förekommande grundämnet på jorden?",
            imageRes = R.drawable.periodic_table,
            answer = "Astat",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilken stad är Europeiska unionens högkvarter beläget i?",
            imageRes = R.drawable.eu,
            answer = "Bryssel",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket däggdjur kan verkligen flyga?",
            imageRes = R.drawable.animals,
            answer = "Fladdermus",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilken är den enda kontinenten utan reptiler eller ormar?",
            imageRes = R.drawable.oceans,
            answer = "Antarktis",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket år dog Napoleon Bonaparte?",
            imageRes = R.drawable.napoleon,
            answer = "1821",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket vitamin bildas när huden exponeras för solljus?",
            imageRes = R.drawable.sun,
            answer = "Vitamin D",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket europeiskt land har den längsta sammanhängande kustlinjen?",
            imageRes = R.drawable.coastline,
            answer = "Norge",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Vilket är det största inre organet i människokroppen sett till vikt?",
            imageRes = R.drawable.skin,
            answer = "Levern",
            points = 600
        ),
        QuizQuestion(
            category = "Common Knowledge",
            difficulty = "hard",
            question = "Under vilka år pågick första världskriget?",
            imageRes = R.drawable.world_war1,
            answer = "1914–1918",
            points = 600
        )
    )
    val sportsEasy = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vilken sport kallas \"det vackra spelet\"?",
            imageRes = R.drawable.allsports,
            answer = "Fotboll",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "I vilken sport gör man en \"slam dunk\"?",
            imageRes = R.drawable.allsports,
            answer = "Basket",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Hur många spelare är det i ett vanligt volleybollag på planen?",
            imageRes = R.drawable.volleyball,
            answer = "Sex",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vilken sport använder en fjäderboll?",
            imageRes = R.drawable.shuttlecock,
            answer = "Badminton",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vilken fotbollsklubb har vunnit flest UEFA Champions League-titlar?",
            imageRes = R.drawable.champions,
            answer = "Real Madrid",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vad representerar de fem ringarna i OS-loggan?",
            imageRes = R.drawable.olympic,
            answer = "De fem världsdelarna",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vilken sport spelas på en isrink med en puck?",
            imageRes = R.drawable.ice_rink,
            answer = "Ishockey",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Vilket land har vunnit flest VM-titlar i fotboll?",
            imageRes = R.drawable.world_cup,
            answer = "Brasilien",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "Hur många förluster har Islam Makhachev haft i sin UFC-karriär hittills?",
            imageRes = R.drawable.islam,
            answer = "En förlust",
            points = 200
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "easy",
            question = "I vilken sport finns \"Heisman Trophy\"?",
            imageRes = R.drawable.heisman_trophy,
            answer = "Amerikansk fotboll",
            points = 200
        )
    )

    val sportsMedium = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilket land vann fotbolls-VM 2018?",
            imageRes = R.drawable.world_cup,
            answer = "Frankrike",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Hur många UEFA Champions League-titlar har AC Milan vunnit totalt?",
            imageRes = R.drawable.ac_milan,
            answer = "7",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "När vann FC Barcelona senast UEFA Champions League?",
            imageRes = R.drawable.barca,
            answer = "2015",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilket lag spelar basketspelaren LeBron James i just nu?",
            imageRes = R.drawable.lebron_james,
            answer = "Los Angeles Lakers",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "I vilket land uppstod sporten judo?",
            imageRes = R.drawable.judo,
            answer = "Japan",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilken klubb har vunnit flest ligatitlar sedan ligan bytte namn 1992?",
            imageRes = R.drawable.premier_league,
            answer = "Manchester United",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vad kallas det när en fotbollsspelare gör tre mål i en och samma match?",
            imageRes = R.drawable.hat_trick,
            answer = "Hattrick",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilket basketlag har vunnit flest NBA-mästerskap?",
            imageRes = R.drawable.nba_championship,
            answer = "Boston Celtics",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilket land är värd för den berömda cykeltävlingen \"Tour de France\"?",
            imageRes = R.drawable.tour_de_france,
            answer = "Frankrike",
            points = 400
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "medium",
            question = "Vilken är den näst mest populära och mest spelade sporten i Sverige efter fotboll?",
            imageRes = R.drawable.allsports,
            answer = "Ishockey",
            points = 400
        )
    )

    val sportsHard = listOf(
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilken svensk idrottare vann ett guld på de senaste Olympiska spelen?",
            imageRes = R.drawable.armand_duplantis,
            answer = "Armand Duplantis",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Var hölls fotbolls-VM 2010?",
            imageRes = R.drawable.world_cup,
            answer = "Sydafrika",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilken säsong gjorde Cristiano Ronaldo flest mål i alla tävlingar?",
            imageRes = R.drawable.cr7,
            answer = "2014–2015",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vem är bästa målskytt genom tiderna i Sveriges herrlandslag i fotboll?",
            imageRes = R.drawable.swedish_team,
            answer = "Zlatan Ibrahimović",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilket skandinaviskt landslag har vunnit fotbolls-EM (UEFA European Championship)?",
            imageRes = R.drawable.european_championship,
            answer = "Danmark",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilket land vann det allra första fotbolls-VM år 1930?",
            imageRes = R.drawable.world_cup,
            answer = "Uruguay",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilken svensk klubb har näst flest SM-guld/Allsvenska-titlar efter Malmö?",
            imageRes = R.drawable.allsvenska,
            answer = "IFK Göteborg",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Vilken tränare ledde Real Madrid till tre raka Champions League-titlar?",
            imageRes = R.drawable.champions,
            answer = "Zinedine Zidane",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Hur många gånger har Spaniens herrlandslag vunnit fotbolls-VM?",
            imageRes = R.drawable.world_cup,
            answer = "En gång",
            points = 600
        ),
        QuizQuestion(
            category = "Sports",
            difficulty = "hard",
            question = "Inom boxning: vad kallas en match där man inte använder handskar?",
            imageRes = R.drawable.bare_knuckle_boxing,
            answer = "Barhandsboxning",
            points = 600
        )
    )

}
