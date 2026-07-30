package se.jumomo24wv.menuactivity.data

import se.jumomo24wv.menuactivity.R
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

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
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.france, "France", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.canda, "Canada", 200),
        QuizQuestion("Flags and Countries", "easy", "What is the capital city of Japan?", R.drawable.tokyo, "Tokyo", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.ireland, "Ireland", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.japanflag, "Japan", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country has Brasília as its capital?", R.drawable.brazilia, "Brazil", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.usa_flag, "United States", 200),
        QuizQuestion("Flags and Countries", "easy", "What is the capital city of Egypt?", R.drawable.cairo, "Cairo", 200),
        QuizQuestion("Flags and Countries", "easy", "Which country does this flag belongs to?", R.drawable.flag_cuba, "Cuba", 200),
        QuizQuestion("Flags and Countries", "easy", "The capital of Australia is not Sydney. What is it?", R.drawable.canberra, "Canberra", 200)
    )
    val flagsMedium = listOf(
        QuizQuestion("Flags and Countries", "medium", "Which African country’s flag features a golden star within a blue triangle and green–red stripes?", R.drawable.flag_mozambique, "Mozambique", 400),
        QuizQuestion("Flags and Countries", "medium", "The capital city of Kazakhstan was renamed several times; what is its current official name?", R.drawable.astana, "Astana", 400),
        QuizQuestion("Flags and Countries", "medium", "Which country does this flag belongs to?", R.drawable.flag_palestine, "Palestine", 400),
        QuizQuestion("Flags and Countries", "medium", "Which country does this flag belongs to?", R.drawable.flag_iraq, "Irak", 400),
        QuizQuestion("Flags and Countries", "medium", "What is the administrative capital of Turkey?", R.drawable.ankara, "Ankara", 400),
        QuizQuestion("Flags and Countries", "medium", "Which country does this flag belongs to?", R.drawable.flag_syria, "Syria", 400),
        QuizQuestion("Flags and Countries", "hard", "Which country does this flag belongs to?", R.drawable.flag_morocco, "Morocco", 400),
        QuizQuestion("Flags and Countries", "medium", "Which country does this flag belongs to?", R.drawable.flag_thailand, "Thailand", 400),
        QuizQuestion("Flags and Countries", "medium", "Which country does this flag belongs to?", R.drawable.flag_somalia, "Somalia", 400),
        QuizQuestion("Flags and Countries", "hard", "Which country does this flag belongs to?", R.drawable.flag_sweden, "Sweden", 400)
    )
    val flagsHard = listOf(
        QuizQuestion("Flags and Countries", "medium", "What is the capital of New Zealand?", R.drawable.wellington, "Wellington", 600),
        QuizQuestion("Flags and Countries", "medium", "Which is the only country in the world with no official capital city?", R.drawable.nauru, "Nauru", 600),
        QuizQuestion("Flags and Countries", "medium", "Which country contains the most islands in the world?", R.drawable.island_sweden, "Sweden", 600),
        QuizQuestion("Flags and Countries", "medium", "Which ocean is the saltiest?", R.drawable.ocean, "The Atlantic Ocean", 600),
        QuizQuestion("Flags and Countries", "hard", "This black, yellow, and white tricolor flag belonged to which former empire?", R.drawable.flag_of_russian_empire, "Russian Empire", 600),
        QuizQuestion("Flags and Countries", "hard", "What is the capital of Lebanon?", R.drawable.beriut, "Beirut", 600),
        QuizQuestion("Flags and Countries", "hard", "Where is the city of Bethlehem located?", R.drawable.betlahim, "In Palestine", 600),
        QuizQuestion("Flags and Countries", "hard", "Where is the first university in the world located?", R.drawable.uni_morocco, "In Morocco ", 600),
        QuizQuestion("Flags and Countries", "hard", "What is the capital city of Colombia?", R.drawable.bogota, "Bogota", 600),
        QuizQuestion("Flags and Countries", "medium", "What is the oldest capital in the world?", R.drawable.damascus, "Damascus", 600)
    )
    val geographyEasy = listOf(
        QuizQuestion("Geography", "easy", "Which city is home to the Eiffel Tower?", R.drawable.eiffel, "Paris", 200),
        QuizQuestion("Geography", "easy", "Which country is famous for the pyramids of Giza?", R.drawable.pyramids, "Egypt", 200),
        QuizQuestion("Geography", "easy", "Mount Everest lies on the border of Nepal and which country?", R.drawable.mount_everest, "China", 200),
        QuizQuestion("Geography", "easy", "Which continent is the Sahara Desert located in?", R.drawable.sahara, "Africa", 200),
        QuizQuestion("Geography", "easy", "What is the capital of Italy?", R.drawable.rome, "Rome", 200),
        QuizQuestion("Geography", "easy", "Which famous statue stands in New York Harbor?", R.drawable.statue_hero, "Statue of Liberty", 200),
        QuizQuestion("Geography", "easy", "Which country is known as the Land of the Rising Sun?", R.drawable.sun, "Japan", 200),
        QuizQuestion("Geography", "easy", "What is the largest ocean on Earth?", R.drawable.ocean, "Pacific Ocean", 200),
        QuizQuestion("Geography", "easy", "What is biggest city in the world?", R.drawable.japan1, "Tokyo", 200),
        QuizQuestion("Geography", "easy", "What is the smallest continent in the world?", R.drawable.map7, "Australia", 200)
    )
    val geographyMedium = listOf(
        QuizQuestion("Geography", "medium", "Which African country has the highest population?", R.drawable.map_africa, "Nigeria", 400),
        QuizQuestion("Geography", "medium", "What is the largest state in the United States?", R.drawable.usa_map, "Alaska", 400),
        QuizQuestion("Geography", "medium", "What is the world’s longest river?", R.drawable.nile_river, "Nile River", 400),
        QuizQuestion("Geography", "medium", "Which river is the longest in Europe?", R.drawable.volga, "Volga River", 400),
        QuizQuestion("Geography", "medium", "Which country owns the island of Greenland?", R.drawable.grenland, "Denmark", 400),
        QuizQuestion("Geography", "medium", "Which country has the most time zones?", R.drawable.timezone, "France", 400),
        QuizQuestion("Geography", "medium", "Which country has the largest Muslim population in the world?", R.drawable.muslim, "Indonesia", 400),
        QuizQuestion("Geography", "medium", "What country is home to the Amazon Rainforest (largest portion)?", R.drawable.amazon, "Brazil", 400),
        QuizQuestion("Geography", "medium", "Which European mountain range runs through Switzerland, France, and Italy?", R.drawable.alps, "The Alps", 400),
        QuizQuestion("Geography", "medium", "In which country can you find the ancient city of Petra?", R.drawable.petra, "Jordan", 400)
    )
    val geographyHard = listOf(
        QuizQuestion("Geography", "hard", "Which country is home to the K2 mountain peak?", R.drawable.k2, "Pakistan", 600),
        QuizQuestion("Geography", "hard", "What is the least populated sovereign country in the world?", R.drawable.vatican_city, "Vatikanstaten", 600),
        QuizQuestion("Geography", "hard", "Which river flows through the Grand Canyon?", R.drawable.colorado_river, "Colorado River", 600),
        QuizQuestion("Geography", "hard", "What is the world’s largest non-polar desert?", R.drawable.sahara, "Sahara Desert", 600),
        QuizQuestion("Geography", "hard", "Which country has the most UNESCO World Heritage Sites?", R.drawable.itlay, "Italy", 600),
        QuizQuestion("Geography", "hard", "Which city is located exactly where the Blue Nile and White Nile meet?", R.drawable.khartoum, "Khartoum", 600),
        QuizQuestion("Flags and Countries", "hard", "What is approximate the area of Sweden? (nearest answer wins)", R.drawable.sweden_map, "449,964 square kilometers", 600),
        QuizQuestion("Flags and Countries", "hard", "What is the area of Denmark? (nearest answer wins)", R.drawable.denmark_map, "42,933 square kilometers", 600)
    )
    val carsEasy = listOf(
        QuizQuestion("Cars", "easy", "Which company manufactures the Civic?", R.drawable.honda_civic, "Honda", 200),
        QuizQuestion("Cars", "easy", "Which car brand has a prancing horse as its logo?", R.drawable.ferrari, "Ferrari", 200),
        QuizQuestion("Cars", "easy", "Which German brand makes the 3 Series?", R.drawable.bmw3series, "BMW", 200),
        QuizQuestion("Cars", "easy", "What car brand uses four interlocking rings?", R.drawable.audi, "Audi", 200),
        QuizQuestion("Cars", "easy", "What company produces the Mustang?", R.drawable.mustang, "Ford", 200),
        QuizQuestion("Cars", "easy", "Which brand is known for the Beetle?", R.drawable.beetle, "Volkswagen", 200),
        QuizQuestion("Cars", "easy", "Which country is Tesla based in?", R.drawable.tesla, "United States", 200),
        QuizQuestion("Cars", "easy", "What type of car is the Toyota Prius known as?", R.drawable.prius, "Hybrid", 200),
        QuizQuestion("Cars", "easy", "Which Italian company produces the Huracán?", R.drawable.huracan, "Lamborghini", 200),
        QuizQuestion("Cars", "easy", "Which brand makes the Corolla?", R.drawable.corolla, "Toyota", 200)
    )
    val carsMedium = listOf(
        QuizQuestion("Cars", "medium", "What country manufactures the brand Volvo?", R.drawable.volvo, "Sweden", 400),
        QuizQuestion("Cars", "medium", "What does 'GTI' stand for in performance cars?", R.drawable.gti, "Grand Touring Injection", 400),
        QuizQuestion("Cars", "medium", "Which brand created the iconic Countach?", R.drawable.countach, "Lamborghini", 400),
        QuizQuestion("Cars", "medium", "Which car uses the Quattro all-wheel drive system?", R.drawable.quattro, "Audi", 400),
        QuizQuestion("Cars", "medium", "Which company makes the luxury brand Lexus?", R.drawable.lexus, "Toyota", 400),
        QuizQuestion("Cars", "medium", "Which BMW car has a V10 engine?", R.drawable.e60, " BMW M5 E60", 400),
        QuizQuestion("Cars", "medium", "Which car uses the 4MATIC all-wheel drive system?", R.drawable.mercedes_4matic, "Mercedes-Benz", 400),
        QuizQuestion("Cars", "medium", "Which brand's logo features a trident?", R.drawable.maserati, "Maserati", 400),
        QuizQuestion("Cars", "medium", "How many major car brands are owned by the Volkswagen Group ?", R.drawable.vw_group, "12", 400),
        QuizQuestion("Cars", "medium", "Approximately how much horsepower does the BMW F10 M5 have?", R.drawable.bmw_f10, "560 hp", 400)
    )
    val carsHard = listOf(
        QuizQuestion("Cars", "hard", "Which Volkswagen Group brand is known for producing luxury hypercars like the Chiron?", R.drawable.f1_1990s, "Bugatti", 600),
        QuizQuestion("Cars", "hard", "What is the exact top speed of the Bugatti Chiron Super Sport 300+ in km/h?", R.drawable.bugatti_chiron, "490 km/h", 600),
        QuizQuestion("Cars", "hard", "Which company did Nils Bohlin work for when he invented the three-point seatbelt?", R.drawable.volvo, "Volvo", 600),
        QuizQuestion("Cars", "hard", "When did the Hummer brand stop production?", R.drawable.hummer, "2010", 600),
        QuizQuestion("Cars", "hard", "Which brand produced the rare supercar named the 'F1' in the 1990s?", R.drawable.f1_1990s, "McLaren", 600),
        QuizQuestion("Cars", "hard", "Which company was the first to use front windshield wipers?", R.drawable.cadillac, "Cadillac", 600),
        QuizQuestion("Cars", "hard", "What is the name of this Toyota model?", R.drawable.rav4, "RAV4", 600),
        QuizQuestion("Cars", "hard", "What is the name of this Audi model?", R.drawable.audi_rq8, "Audi RQ8", 600),
        QuizQuestion("Cars", "hard", "What is the name of this Mercedes model?", R.drawable.gle, "GLE Coupe", 600),
        QuizQuestion("Cars", "hard", "Which Italian brand built the rare hypercar 'MC12'?", R.drawable.mc12, "Maserati", 600)
    )
    val commonKnowledgeEasy = listOf(
        QuizQuestion("Common Knowledge", "easy", "What is the largest planet in the solar system?", R.drawable.solar_system, "Jupiter", 200),
        QuizQuestion("Common Knowledge", "easy", "What is the largest organ in the human body?", R.drawable.skin, "Skin", 200),
        QuizQuestion("Common Knowledge", "easy", "Which country is the largest by land area in the world?", R.drawable.map_of_world, "Russia", 200),
        QuizQuestion("Common Knowledge", "easy", "Which bird is known for its impressive mimicry skills and intelligence?", R.drawable.animals, "Parrot", 200),
        QuizQuestion("Common Knowledge", "easy", "What is the chemical formula of table salt?", R.drawable.periodic_table, "NaCl", 200),
        QuizQuestion("Common Knowledge", "easy", "Which natural disaster is measured with a Richter scale?", R.drawable.natural_disater, "Earthquake", 200),
        QuizQuestion("Common Knowledge", "easy", "Which ocean is the Bermuda Triangle located in?", R.drawable.oceans, "Atlantic Ocean", 200),
        QuizQuestion("Common Knowledge", "easy", "What is the smallest prime number?", R.drawable.math, "2", 200),
        QuizQuestion("Common Knowledge", "easy", "Which famous scientist introduced the three laws of motion?", R.drawable.three_laws, "Isaac Newton", 200),
        QuizQuestion("Common Knowledge", "easy", "Which country is the world’s largest producer of rice", R.drawable.rice, "China", 200)
    )
    val commonKnowledgeMedium = listOf(
        QuizQuestion("Common Knowledge", "medium", "In which year was Palestine occupied by Israel", R.drawable.palestine1948, "1948", 400),
        QuizQuestion("Common Knowledge", "medium", "Which language has the most native speakers worldwide?", R.drawable.mandarin, "Mandarin Chinese", 400),
        QuizQuestion("Common Knowledge", "medium", "When did the Syrian uprising against Bashar al-Assad begin?", R.drawable.syrian_uprising, "March 2011", 400),
        QuizQuestion("Common Knowledge", "medium", "Who was the first person to attempt flight using artificial wings in the 9th century", R.drawable.abbas, "Abbas Ibn Firnas", 400),
        QuizQuestion("Common Knowledge", "medium", "In which year did the first human land on the Moon?", R.drawable.moon, "1969", 400),
        QuizQuestion("Common Knowledge", "medium", "Which are the main Scandinavian countries", R.drawable.scandinavian, "Sweden, Norway, Denmark، Finland and Iceland", 400),
        QuizQuestion("Common Knowledge", "medium", "What compound do plants produce during photosynthesis that serves as an energy source ?", R.drawable.photosynthesis, "Glucose", 400),
        QuizQuestion("Common Knowledge", "medium", "Which country invented Bluetooth technology", R.drawable.bluetooth, "Sweden", 400),
        QuizQuestion("Common Knowledge", "medium", "When was the last time Sweden participated in an actual war?", R.drawable.sweden1814, "1814", 400),
        QuizQuestion("Common Knowledge", "medium", "Which country is considered the capital of luxury perfumes?", R.drawable.perfumes, "France", 400)
    )
    val commonKnowledgeHard = listOf(
        QuizQuestion("Common Knowledge", "hard", "Which philosopher is famous for the statement 'I think, therefore I am'?", R.drawable.rene_descartes, "René Descartes", 600),
        QuizQuestion("Common Knowledge", "hard", "What is the rarest naturally occurring element on Earth?", R.drawable.periodic_table, "Astatine", 600),
        QuizQuestion("Common Knowledge", "hard", "Which city is the headquarters of the European Union?", R.drawable.eu, "Brussels", 600),
        QuizQuestion("Common Knowledge", "hard", "Which mammal is capable of true flight?", R.drawable.animals, "Bat", 600),
        QuizQuestion("Common Knowledge", "hard", "Which is the only continent without reptiles or snakes?", R.drawable.oceans, "Antarctica", 600),
        QuizQuestion("Common Knowledge", "hard", "In which year did Napoleon Bonaparte die?", R.drawable.napoleon, "1821", 600),
        QuizQuestion("Common Knowledge", "hard", "Which vitamin is produced when skin is exposed to sunlight?", R.drawable.sun, "Vitamin D", 600),
        QuizQuestion("Common Knowledge", "hard", "Which European country has the longest continuous coastline?", R.drawable.coastline, "Norway", 600),
        QuizQuestion("Common Knowledge", "hard", "What is the largest internal organ by mass in the human body?", R.drawable.skin, "Liver", 600),
        QuizQuestion("Common Knowledge", "hard", "During which years did World War I take place", R.drawable.world_war1, "1914 – 1918", 600)
    )
    val sportsEasy = listOf(
        QuizQuestion("Sports", "easy", "Which sport is known as 'the beautiful game'?", R.drawable.allsports, "Football", 200),
        QuizQuestion("Sports", "easy", "In which sport is a 'slam dunk' performed?", R.drawable.allsports, "Basketball", 200),
        QuizQuestion("Sports", "easy", "How many players are there in a standard volleyball team on the court?", R.drawable.volleyball, "Six", 200),
        QuizQuestion("Sports", "easy", "Which sport uses a shuttlecock?", R.drawable.shuttlecock, "Badminton", 200),
        QuizQuestion("Sports", "easy", "Which football club has won the most UEFA Champions League titles?", R.drawable.champions, "Real Madrid", 200),
        QuizQuestion("Sports", "easy", "What do the five rings in the Olympic logo represent?", R.drawable.olympic, "The five major continents", 200),
        QuizQuestion("Sports", "easy", "Which sport is played on an ice rink with a puck?", R.drawable.ice_rink, "Ice Hockey", 200),
        QuizQuestion("Sports", "easy", "Which country has won the most FIFA World Cup titles?", R.drawable.world_cup, "Brazil", 200),
        QuizQuestion("Sports", "easy", "How many losses has Islam Makhachev suffered in his UFC career so far?", R.drawable.islam, "One loss", 200),
        QuizQuestion("Sports", "easy", "Which sport features the 'Heisman Trophy'?", R.drawable.heisman_trophy, "American Football", 200)
    )
    val sportsMedium = listOf(
        QuizQuestion("Sports", "medium", "Which country won the FIFA World Cup in 2018?", R.drawable.world_cup, "France", 400),
        QuizQuestion("Sports", "medium", "How many UEFA Champions League titles has AC Milan won to date?", R.drawable.ac_milan, "7", 400),
        QuizQuestion("Sports", "medium", "When did FC Barcelona last win the UEFA Champions League?", R.drawable.barca, "2015", 400),
        QuizQuestion("Sports", "medium", "Which team does basketball player LeBron James currently play for?", R.drawable.lebron_james, "Los Angeles Lakers", 400),
        QuizQuestion("Sports", "medium", "In which country did the sport of judo originate?", R.drawable.judo, "Japan", 400),
        QuizQuestion("Sports", "medium", "Which club has won the most titles since the league was rebranded in 1992 ?", R.drawable.premier_league, "Manchester United", 400),
        QuizQuestion("Sports", "medium", "What is it called when a football player scores three goals in a single match?", R.drawable.hat_trick, "Hat-trick", 400),
        QuizQuestion("Sports", "medium", "Which basketball team has won the most NBA championships?", R.drawable.nba_championship, "Boston Celtics", 400),
        QuizQuestion("Sports", "medium", "Which country hosts the famous cycling race 'Tour de France'?", R.drawable.tour_de_france, "France", 400),
        QuizQuestion("Sports", "medium", "What is the second most popular and widely played sport in Sweden after football?", R.drawable.allsports, "Ice Hockey", 400)
    )
    val sportsHard = listOf(
        QuizQuestion("Sports", "hard", "Who is the Swedish athlete who won a gold medal at the most recent Olympic Games?", R.drawable.armand_duplantis, "Armand Duplantis", 600),
        QuizQuestion("Sports", "hard", "Where was the 2010 FIFA World Cup held?", R.drawable.world_cup, "South Africa", 600),
        QuizQuestion("Sports", "hard", "In which season did Cristiano Ronaldo score the most goals across all competitions?", R.drawable.cr7, "2014–2015", 600),
        QuizQuestion("Sports", "hard", "Who is the all-time top scorer for the Swedish national football team?", R.drawable.swedish_team, "Zlatan Ibrahimović", 600),
        QuizQuestion("Sports", "hard", "Which Scandinavian national team has won the UEFA European Championship?", R.drawable.european_championship, "Denmark", 600),
        QuizQuestion("Sports", "hard", "Which country won the first ever FIFA World Cup in 1930?", R.drawable.world_cup, "Uruguay", 600),
        QuizQuestion("Sports", "hard", "Which Swedish club ranks second in most Allsvenskan (Swedish league) titles after Malmö?", R.drawable.allsvenska, "IFK Göteborg", 600),
        QuizQuestion("Sports", "hard", "Which coach led Real Madrid to win three consecutive UEFA Champions League titles?", R.drawable.champions, "Zinedine Zidane", 600),
        QuizQuestion("Sports", "hard", "How many times has the Spanish national football team won the FIFA World Cup?", R.drawable.world_cup, "Once", 600),
        QuizQuestion("Sports", "hard", "In boxing, what is the term for a fight where no gloves are worn?", R.drawable.bare_knuckle_boxing, "Bare-knuckle boxing", 600)
    )
    val historyEasy = listOf(
        QuizQuestion("History", "easy", "Who was the first president of the United States?", null, "George Washington", 200),
        QuizQuestion("History", "easy", "In which year did World War II end?", null, "1945", 200),
        QuizQuestion("History", "easy", "Which ancient civilization built the pyramids of Giza?", null, "The Ancient Egyptians", 200),
        QuizQuestion("History", "easy", "Who was the British Prime Minister during most of World War II?", null, "Winston Churchill", 200),
        QuizQuestion("History", "easy", "Which wall divided East and West Berlin until 1989?", null, "The Berlin Wall", 200),
        QuizQuestion("History", "easy", "In which year did the Titanic sink?", null, "1912", 200)
    )
    val historyMedium = listOf(
        QuizQuestion("History", "medium", "Which empire was ruled by Genghis Khan?", null, "The Mongol Empire", 400),
        QuizQuestion("History", "medium", "In which year did the French Revolution begin?", null, "1789", 400),
        QuizQuestion("History", "medium", "Who was the first Caliph of Islam after the Prophet Muhammad?", null, "Abu Bakr", 400),
        QuizQuestion("History", "medium", "Which country was the first to grant women the right to vote nationally, in 1893?", null, "New Zealand", 400),
        QuizQuestion("History", "medium", "What was the name of the ship that brought the Pilgrims to America in 1620?", null, "The Mayflower", 400),
        QuizQuestion("History", "medium", "Which ancient empire built the Colosseum in Rome?", null, "The Roman Empire", 400)
    )
    val historyHard = listOf(
        QuizQuestion("History", "hard", "Which Swedish king died at the Battle of Fredrikshald in 1718?", null, "Charles XII (Karl XII)", 600),
        QuizQuestion("History", "hard", "In which year did the Ottoman Empire officially come to an end?", null, "1922", 600),
        QuizQuestion("History", "hard", "What was the name of the treaty that officially ended World War I?", null, "The Treaty of Versailles", 600),
        QuizQuestion("History", "hard", "Which Islamic dynasty, ruling from Baghdad, is known for a golden age of science and learning?", null, "The Abbasid Caliphate", 600),
        QuizQuestion("History", "hard", "Who was the first emperor to unify China, in 221 BC?", null, "Qin Shi Huang", 600),
        QuizQuestion("History", "hard", "Who was the last active pharaoh of Ptolemaic Egypt?", null, "Cleopatra VII", 600)
    )
    val moviesEasy = listOf(
        QuizQuestion("Movies", "easy", "Which movie franchise features a boy wizard named Harry Potter?", null, "Harry Potter", 200),
        QuizQuestion("Movies", "easy", "Who directed the movie \"Titanic\" (1997)?", null, "James Cameron", 200),
        QuizQuestion("Movies", "easy", "Which animation studio created \"Toy Story\"?", null, "Pixar", 200),
        QuizQuestion("Movies", "easy", "What is the name of the ring in \"The Lord of the Rings\"?", null, "The One Ring", 200),
        QuizQuestion("Movies", "easy", "Which superhero is known as the \"Man of Steel\"?", null, "Superman", 200),
        QuizQuestion("Movies", "easy", "In which movie franchise does the character Luke Skywalker appear?", null, "Star Wars", 200)
    )
    val moviesMedium = listOf(
        QuizQuestion("Movies", "medium", "Which actor played the Joker in \"The Dark Knight\" (2008)?", null, "Heath Ledger", 400),
        QuizQuestion("Movies", "medium", "Which 1994 movie tells the story of a man named Forrest Gump?", null, "Forrest Gump", 400),
        QuizQuestion("Movies", "medium", "Which movie won the Academy Award for Best Picture in 2020, the first non-English-language film to do so?", null, "Parasite", 400),
        QuizQuestion("Movies", "medium", "Who composed the music score for \"Star Wars\"?", null, "John Williams", 400),
        QuizQuestion("Movies", "medium", "What is the name of the fictional African country in \"Black Panther\"?", null, "Wakanda", 400),
        QuizQuestion("Movies", "medium", "Which studio produces the James Bond film series?", null, "Eon Productions", 400)
    )
    val moviesHard = listOf(
        QuizQuestion("Movies", "hard", "Who directed the movie \"Inception\" (2010)?", null, "Christopher Nolan", 600),
        QuizQuestion("Movies", "hard", "Which film was the first ever to win the Academy Award for Best Picture, in 1929?", null, "Wings", 600),
        QuizQuestion("Movies", "hard", "Which 1975 movie, directed by Steven Spielberg, is considered the first summer blockbuster?", null, "Jaws", 600),
        QuizQuestion("Movies", "hard", "Who played the lead role in the 1962 film \"Lawrence of Arabia\"?", null, "Peter O'Toole", 600),
        QuizQuestion("Movies", "hard", "Which actress has received the most Academy Award nominations in history?", null, "Meryl Streep", 600),
        QuizQuestion("Movies", "hard", "What was the name of the first feature-length animated movie ever released, by Disney in 1937?", null, "Snow White and the Seven Dwarfs", 600)
    )
    val scienceEasy = listOf(
        QuizQuestion("Science", "easy", "What planet is known as the Red Planet?", null, "Mars", 200),
        QuizQuestion("Science", "easy", "What gas do humans need to breathe to survive?", null, "Oxygen", 200),
        QuizQuestion("Science", "easy", "What is the boiling point of water in Celsius?", null, "100°C", 200),
        QuizQuestion("Science", "easy", "How many bones are in the adult human body?", null, "206", 200),
        QuizQuestion("Science", "easy", "What is the powerhouse of the cell called?", null, "Mitochondria", 200),
        QuizQuestion("Science", "easy", "What force pulls objects toward the Earth?", null, "Gravity", 200)
    )
    val scienceMedium = listOf(
        QuizQuestion("Science", "medium", "What is the chemical symbol for gold?", null, "Au", 400),
        QuizQuestion("Science", "medium", "Which scientist developed the theory of relativity?", null, "Albert Einstein", 400),
        QuizQuestion("Science", "medium", "What is the hardest natural substance on Earth?", null, "Diamond", 400),
        QuizQuestion("Science", "medium", "What type of animal is a Komodo dragon?", null, "A lizard (reptile)", 400),
        QuizQuestion("Science", "medium", "Which planet has the most known moons in the solar system?", null, "Saturn", 400),
        QuizQuestion("Science", "medium", "What is the study of earthquakes called?", null, "Seismology", 400)
    )
    val scienceHard = listOf(
        QuizQuestion("Science", "hard", "What is the name of the process by which stars produce energy?", null, "Nuclear fusion", 600),
        QuizQuestion("Science", "hard", "Which particle, discovered in 2012, is linked to giving mass to other particles?", null, "The Higgs boson", 600),
        QuizQuestion("Science", "hard", "What is the speed of light in a vacuum (approximately)?", null, "Approximately 300,000 km/second", 600),
        QuizQuestion("Science", "hard", "Which scientist first proposed the laws of genetic inheritance?", null, "Gregor Mendel", 600),
        QuizQuestion("Science", "hard", "What is the name of the galaxy that contains our solar system?", null, "The Milky Way", 600),
        QuizQuestion("Science", "hard", "Which element has the atomic number 1?", null, "Hydrogen", 600)
    )
}

object QuizDataSV {
    val flagsEasy = listOf(
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.france, "Frankrike", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.canda, "Kanada", 200),
        QuizQuestion("Flags and Countries", "easy", "Vad heter Japans huvudstad?", R.drawable.tokyo, "Tokyo", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.ireland, "Irland", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.japanflag, "Japan", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land har Brasília som huvudstad?", R.drawable.brazilia, "Brasilien", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.usa_flag, "USA", 200),
        QuizQuestion("Flags and Countries", "easy", "Vad heter Egyptens huvudstad?", R.drawable.cairo, "Kairo", 200),
        QuizQuestion("Flags and Countries", "easy", "Vilket land tillhör denna flagga?", R.drawable.flag_cuba, "Kuba", 200),
        QuizQuestion("Flags and Countries", "easy", "Australiens huvudstad är inte Sydney. Vad heter den?", R.drawable.canberra, "Canberra", 200)
    )
    val flagsMedium = listOf(
        QuizQuestion("Flags and Countries", "medium", "Vilket afrikanskt land har en flagga med en gyllene stjärna i en blå triangel samt gröna och röda ränder?", R.drawable.flag_mozambique, "Moçambique", 400),
        QuizQuestion("Flags and Countries", "medium", "Kazakstans huvudstad har bytt namn flera gånger – vad är dess nuvarande namn?", R.drawable.astana, "Astana", 400),
        QuizQuestion("Flags and Countries", "medium", "Vilket land tillhör denna flagga?", R.drawable.flag_palestine, "Palestina", 400),
        QuizQuestion("Flags and Countries", "medium", "Vilket land tillhör denna flagga?", R.drawable.flag_iraq, "Irak", 400),
        QuizQuestion("Flags and Countries", "medium", "Vad är Turkiets administrativa huvudstad?", R.drawable.ankara, "Ankara", 400),
        QuizQuestion("Flags and Countries", "medium", "Vilket land tillhör denna flagga?", R.drawable.flag_syria, "Syrien", 400),
        QuizQuestion("Flags and Countries", "hard", "Vilket land tillhör denna flagga?", R.drawable.flag_morocco, "Marocko", 400),
        QuizQuestion("Flags and Countries", "medium", "Vilket land tillhör denna flagga?", R.drawable.flag_thailand, "Thailand", 400),
        QuizQuestion("Flags and Countries", "medium", "Vilket land tillhör denna flagga?", R.drawable.flag_somalia, "Somalia", 400),
        QuizQuestion("Flags and Countries", "hard", "Vilket land tillhör denna flagga?", R.drawable.flag_sweden, "Sverige", 400)
    )
    val flagsHard = listOf(
        QuizQuestion("Flags and Countries", "medium", "Vad heter Nya Zeelands huvudstad?", R.drawable.wellington, "Wellington", 600),
        QuizQuestion("Flags and Countries", "medium", "Vilket är det enda landet i världen utan en officiell huvudstad?", R.drawable.nauru, "Nauru", 600),
        QuizQuestion("Flags and Countries", "medium", "Vilket land har flest öar i världen?", R.drawable.island_sweden, "Sverige", 600),
        QuizQuestion("Flags and Countries", "medium", "Vilket hav är mest salt?", R.drawable.ocean, "Atlanten", 600),
        QuizQuestion("Flags and Countries", "hard", "Denna svart-gul-vita trefärgade flagga tillhörde vilket tidigare imperium?", R.drawable.flag_of_russian_empire, "Ryska imperiet", 600),
        QuizQuestion("Flags and Countries", "hard", "Vad heter Libanons huvudstad?", R.drawable.beriut, "Beirut", 600),
        QuizQuestion("Flags and Countries", "hard", "Var ligger staden Betlehem?", R.drawable.betlahim, "I Palestina", 600),
        QuizQuestion("Flags and Countries", "hard", "Var ligger världens första universitet?", R.drawable.uni_morocco, "I Marocko", 600),
        QuizQuestion("Flags and Countries", "hard", "Vad heter Colombias huvudstad?", R.drawable.bogota, "Bogotá", 600),
        QuizQuestion("Flags and Countries", "medium", "Vilken är världens äldsta huvudstad?", R.drawable.damascus, "Damaskus", 600)
    )
    val geographyEasy = listOf(
        QuizQuestion("Geography", "easy", "Vilken stad är hem till Eiffeltornet?", R.drawable.eiffel, "Paris", 200),
        QuizQuestion("Geography", "easy", "Vilket land är känt för pyramiderna i Giza?", R.drawable.pyramids, "Egypten", 200),
        QuizQuestion("Geography", "easy", "Mount Everest ligger på gränsen mellan Nepal och vilket land?", R.drawable.mount_everest, "Kina", 200),
        QuizQuestion("Geography", "easy", "På vilken kontinent ligger Saharaöknen?", R.drawable.sahara, "Afrika", 200),
        QuizQuestion("Geography", "easy", "Vad är Italiens huvudstad?", R.drawable.rome, "Rom", 200),
        QuizQuestion("Geography", "easy", "Vilken berömd staty står i New Yorks hamn?", R.drawable.statue_hero, "Frihetsgudinnan", 200),
        QuizQuestion("Geography", "easy", "Vilket land kallas Solens uppgångs land?", R.drawable.sun, "Japan", 200),
        QuizQuestion("Geography", "easy", "Vilket är det största havet på jorden?", R.drawable.ocean, "Stilla havet", 200),
        QuizQuestion("Geography", "easy", "Vilken är världens största stad sett till befolkning?", R.drawable.japan1, "Tokyo", 200),
        QuizQuestion("Geography", "easy", "Vilken är världens minsta kontinent?", R.drawable.map7, "Australien", 200)
    )
    val geographyMedium = listOf(
        QuizQuestion("Geography", "medium", "Vilket afrikanskt land har störst befolkning?", R.drawable.map_africa, "Nigeria", 400),
        QuizQuestion("Geography", "medium", "Vilken är den största delstaten i USA?", R.drawable.usa_map, "Alaska", 400),
        QuizQuestion("Geography", "medium", "Vilken är världens längsta flod?", R.drawable.nile_river, "Nilen", 400),
        QuizQuestion("Geography", "medium", "Vilken flod är längst i Europa?", R.drawable.volga, "Volga", 400),
        QuizQuestion("Geography", "medium", "Vilket land äger ön Grönland?", R.drawable.grenland, "Danmark", 400),
        QuizQuestion("Geography", "medium", "Vilket land har flest tidszoner?", R.drawable.timezone, "Frankrike", 400),
        QuizQuestion("Geography", "medium", "Vilket land har världens största muslimska befolkning?", R.drawable.muslim, "Indonesien", 400),
        QuizQuestion("Geography", "medium", "Vilket land har den största delen av Amazonas regnskog?", R.drawable.amazon, "Brasilien", 400),
        QuizQuestion("Geography", "medium", "Vilken europeisk bergskedja sträcker sig genom Schweiz, Frankrike och Italien?", R.drawable.alps, "Alperna", 400),
        QuizQuestion("Geography", "medium", "I vilket land ligger den antika staden Petra?", R.drawable.petra, "Jordanien", 400)
    )
    val geographyHard = listOf(
        QuizQuestion("Geography", "hard", "Vilket land ligger berget K2 i?", R.drawable.k2, "Pakistan", 600),
        QuizQuestion("Geography", "hard", "Vilket är världens minst befolkade självständiga land?", R.drawable.vatican_city, "Vatikanstaten", 600),
        QuizQuestion("Geography", "hard", "Vilken flod rinner genom Grand Canyon?", R.drawable.colorado_river, "Coloradofloden", 600),
        QuizQuestion("Geography", "hard", "Vilken är världens största icke-polära öken?", R.drawable.sahara, "Saharaöknen", 600),
        QuizQuestion("Geography", "hard", "Vilket land har flest UNESCO-världsarv?", R.drawable.itlay, "Italien", 600),
        QuizQuestion("Geography", "hard", "Vilken stad ligger där Blå Nilen och Vita Nilen möts?", R.drawable.khartoum, "Khartoum", 600),
        QuizQuestion("Geography", "hard", "Hur stor är Sveriges yta?", R.drawable.sweden_map, "449 964 kvadratkilometer", 600),
        QuizQuestion("Geography", "hard", "Hur stor är Danmarks yta?", R.drawable.denmark_map, "42 933 kvadratkilometer (närmaste svar vinner)", 600)
    )
    val carsEasy = listOf(
        QuizQuestion("Cars", "easy", "Vilket företag tillverkar Civic?", R.drawable.honda_civic, "Honda", 200),
        QuizQuestion("Cars", "easy", "Vilket bilmärke har en stegrande häst som logotyp?", R.drawable.ferrari, "Ferrari", 200),
        QuizQuestion("Cars", "easy", "Vilket tyskt bilmärke tillverkar 3-serien?", R.drawable.bmw3series, "BMW", 200),
        QuizQuestion("Cars", "easy", "Vilket bilmärke använder fyra sammanlänkade ringar?", R.drawable.audi, "Audi", 200),
        QuizQuestion("Cars", "easy", "Vilket företag producerar Mustang?", R.drawable.mustang, "Ford", 200),
        QuizQuestion("Cars", "easy", "Vilket bilmärke är känt för modellen Beetle?", R.drawable.beetle, "Volkswagen", 200),
        QuizQuestion("Cars", "easy", "I vilket land har Tesla sitt ursprung?", R.drawable.tesla, "USA", 200),
        QuizQuestion("Cars", "easy", "Vilken typ av bil är Toyota Prius känd för att vara?", R.drawable.prius, "Hybrid", 200),
        QuizQuestion("Cars", "easy", "Vilket italienskt företag tillverkar Huracán?", R.drawable.huracan, "Lamborghini", 200),
        QuizQuestion("Cars", "easy", "Vilket bilmärke tillverkar Corolla?", R.drawable.corolla, "Toyota", 200)
    )
    val carsMedium = listOf(
        QuizQuestion("Cars", "medium", "I vilket land tillverkas bilmärket Volvo?", R.drawable.volvo, "Sverige", 400),
        QuizQuestion("Cars", "medium", "Vad står \"GTI\" för inom prestandabilar?", R.drawable.gti, "Grand Touring Injection", 400),
        QuizQuestion("Cars", "medium", "Vilket bilmärke skapade den ikoniska Countach?", R.drawable.countach, "Lamborghini", 400),
        QuizQuestion("Cars", "medium", "Vilket bilmärke använder fyrhjulsdriften Quattro?", R.drawable.quattro, "Audi", 400),
        QuizQuestion("Cars", "medium", "Vilket företag äger lyxmärket Lexus?", R.drawable.lexus, "Toyota", 400),
        QuizQuestion("Cars", "medium", "Vilken BMW-modell har en V10-motor?", R.drawable.e60, "BMW M5 E60", 400),
        QuizQuestion("Cars", "medium", "Vilket bilmärke använder fyrhjulsdriften 4MATIC?", R.drawable.mercedes_4matic, "Mercedes-Benz", 400),
        QuizQuestion("Cars", "medium", "Vilket bilmärkes logotyp har en treudd?", R.drawable.maserati, "Maserati", 400),
        QuizQuestion("Cars", "medium", "Hur många stora bilmärken ägs av Volkswagen-koncernen?", R.drawable.vw_group, "12", 400),
        QuizQuestion("Cars", "medium", "Ungefär hur många hästkrafter har BMW F10 M5?", R.drawable.bmw_f10, "560 hk", 400)
    )
    val carsHard = listOf(
        QuizQuestion("Cars", "hard", "Vilket märke inom Volkswagen-koncernen är känt för hyperbilar som Chiron?", R.drawable.f1_1990s, "Bugatti", 600),
        QuizQuestion("Cars", "hard", "Vad är den exakta topphastigheten för Bugatti Chiron Super Sport 300+ i km/h?", R.drawable.bugatti_chiron, "490 km/h", 600),
        QuizQuestion("Cars", "hard", "Vilket företag arbetade Nils Bohlin för när han uppfann trepunktsbältet?", R.drawable.volvo, "Volvo", 600),
        QuizQuestion("Cars", "hard", "Vilket år slutade Hummer-märket sin produktion?", R.drawable.hummer, "2010", 600),
        QuizQuestion("Cars", "hard", "Vilket bilmärke producerade den sällsynta superbilen \"F1\" på 1990-talet?", R.drawable.f1_1990s, "McLaren", 600),
        QuizQuestion("Cars", "hard", "Vilket företag var först med vindrutetorkare fram?", R.drawable.cadillac, "Cadillac", 600),
        QuizQuestion("Cars", "hard", "Vad heter denna Toyota-modell?", R.drawable.rav4, "RAV4", 600),
        QuizQuestion("Cars", "hard", "Vad heter denna Audi-modell?", R.drawable.audi_rq8, "Audi RQ8", 600),
        QuizQuestion("Cars", "hard", "Vad heter denna Mercedes-modell?", R.drawable.gle, "GLE Coupé", 600),
        QuizQuestion("Cars", "hard", "Vilket italienskt bilmärke byggde den sällsynta hyperbilen \"MC12\"?", R.drawable.mc12, "Maserati", 600)
    )
    val commonKnowledgeEasy = listOf(
        QuizQuestion("Common Knowledge", "easy", "Vilken är den största planeten i solsystemet?", R.drawable.solar_system, "Jupiter", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilket är det största organet i människokroppen?", R.drawable.skin, "Huden", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilket land är störst till ytan i världen?", R.drawable.map_of_world, "Ryssland", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilken fågel är känd för sin imponerande förmåga att härma ljud och sin intelligens?", R.drawable.animals, "Papegoja", 200),
        QuizQuestion("Common Knowledge", "easy", "Vad är den kemiska formeln för bordssalt?", R.drawable.periodic_table, "NaCl", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilken naturkatastrof mäts med Richterskalan?", R.drawable.natural_disater, "Jordbävning", 200),
        QuizQuestion("Common Knowledge", "easy", "I vilket hav ligger Bermudatriangeln?", R.drawable.oceans, "Atlanten", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilket är det minsta primtalet?", R.drawable.math, "2", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilken berömd vetenskapsman formulerade de tre rörelselagarna?", R.drawable.three_laws, "Isaac Newton", 200),
        QuizQuestion("Common Knowledge", "easy", "Vilket land är världens största producent av ris?", R.drawable.rice, "Kina", 200)
    )
    val commonKnowledgeMedium = listOf(
        QuizQuestion("Common Knowledge", "medium", "År vilket år blev Palestina fullt ockuperat av Israel?", R.drawable.palestine1948, "1948", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilket språk har flest modersmålstalare i världen?", R.drawable.mandarin, "Mandarinkinesiska", 400),
        QuizQuestion("Common Knowledge", "medium", "När började det syriska upproret mot Bashar al-Assad?", R.drawable.syrian_uprising, "Mars 2011", 400),
        QuizQuestion("Common Knowledge", "medium", "Vem var den första personen som försökte flyga med konstgjorda vingar på 800-talet?", R.drawable.abbas, "Abbas Ibn Firnas", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilket år landade den första människan på månen?", R.drawable.moon, "1969", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilka länder räknas som de skandinaviska länderna?", R.drawable.scandinavian, "Sverige, Norge, Danmark, Finland och Island", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilken förening producerar växter under fotosyntesen som fungerar som energikälla?", R.drawable.photosynthesis, "Glukos", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilket land uppfann Bluetooth-tekniken?", R.drawable.bluetooth, "Sverige", 400),
        QuizQuestion("Common Knowledge", "medium", "När deltog Sverige senast i ett verkligt krig?", R.drawable.sweden1814, "1814", 400),
        QuizQuestion("Common Knowledge", "medium", "Vilket land betraktas som världens huvudstad för lyxparfymer?", R.drawable.perfumes, "Frankrike", 400)
    )
    val commonKnowledgeHard = listOf(
        QuizQuestion("Common Knowledge", "hard", "Vilken filosof är känd för uttrycket \"Jag tänker, alltså finns jag\"?", R.drawable.rene_descartes, "René Descartes", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket är det mest sällsynta naturligt förekommande grundämnet på jorden?", R.drawable.periodic_table, "Astat", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilken stad är Europeiska unionens högkvarter beläget i?", R.drawable.eu, "Bryssel", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket däggdjur kan verkligen flyga?", R.drawable.animals, "Fladdermus", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilken är den enda kontinenten utan reptiler eller ormar?", R.drawable.oceans, "Antarktis", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket år dog Napoleon Bonaparte?", R.drawable.napoleon, "1821", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket vitamin bildas när huden exponeras för solljus?", R.drawable.sun, "Vitamin D", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket europeiskt land har den längsta sammanhängande kustlinjen?", R.drawable.coastline, "Norge", 600),
        QuizQuestion("Common Knowledge", "hard", "Vilket är det största inre organet i människokroppen sett till vikt?", R.drawable.skin, "Levern", 600),
        QuizQuestion("Common Knowledge", "hard", "Under vilka år pågick första världskriget?", R.drawable.world_war1, "1914–1918", 600)
    )
    val sportsEasy = listOf(
        QuizQuestion("Sports", "easy", "Vilken sport kallas \"det vackra spelet\"?", R.drawable.allsports, "Fotboll", 200),
        QuizQuestion("Sports", "easy", "I vilken sport gör man en \"slam dunk\"?", R.drawable.allsports, "Basket", 200),
        QuizQuestion("Sports", "easy", "Hur många spelare är det i ett vanligt volleybollag på planen?", R.drawable.volleyball, "Sex", 200),
        QuizQuestion("Sports", "easy", "Vilken sport använder en fjäderboll?", R.drawable.shuttlecock, "Badminton", 200),
        QuizQuestion("Sports", "easy", "Vilken fotbollsklubb har vunnit flest UEFA Champions League-titlar?", R.drawable.champions, "Real Madrid", 200),
        QuizQuestion("Sports", "easy", "Vad representerar de fem ringarna i OS-loggan?", R.drawable.olympic, "De fem världsdelarna", 200),
        QuizQuestion("Sports", "easy", "Vilken sport spelas på en isrink med en puck?", R.drawable.ice_rink, "Ishockey", 200),
        QuizQuestion("Sports", "easy", "Vilket land har vunnit flest VM-titlar i fotboll?", R.drawable.world_cup, "Brasilien", 200),
        QuizQuestion("Sports", "easy", "Hur många förluster har Islam Makhachev haft i sin UFC-karriär hittills?", R.drawable.islam, "En förlust", 200),
        QuizQuestion("Sports", "easy", "I vilken sport finns \"Heisman Trophy\"?", R.drawable.heisman_trophy, "Amerikansk fotboll", 200)
    )
    val sportsMedium = listOf(
        QuizQuestion("Sports", "medium", "Vilket land vann fotbolls-VM 2018?", R.drawable.world_cup, "Frankrike", 400),
        QuizQuestion("Sports", "medium", "Hur många UEFA Champions League-titlar har AC Milan vunnit totalt?", R.drawable.ac_milan, "7", 400),
        QuizQuestion("Sports", "medium", "När vann FC Barcelona senast UEFA Champions League?", R.drawable.barca, "2015", 400),
        QuizQuestion("Sports", "medium", "Vilket lag spelar basketspelaren LeBron James i just nu?", R.drawable.lebron_james, "Los Angeles Lakers", 400),
        QuizQuestion("Sports", "medium", "I vilket land uppstod sporten judo?", R.drawable.judo, "Japan", 400),
        QuizQuestion("Sports", "medium", "Vilken klubb har vunnit flest ligatitlar sedan ligan bytte namn 1992?", R.drawable.premier_league, "Manchester United", 400),
        QuizQuestion("Sports", "medium", "Vad kallas det när en fotbollsspelare gör tre mål i en och samma match?", R.drawable.hat_trick, "Hattrick", 400),
        QuizQuestion("Sports", "medium", "Vilket basketlag har vunnit flest NBA-mästerskap?", R.drawable.nba_championship, "Boston Celtics", 400),
        QuizQuestion("Sports", "medium", "Vilket land är värd för den berömda cykeltävlingen \"Tour de France\"?", R.drawable.tour_de_france, "Frankrike", 400),
        QuizQuestion("Sports", "medium", "Vilken är den näst mest populära och mest spelade sporten i Sverige efter fotboll?", R.drawable.allsports, "Ishockey", 400)
    )
    val sportsHard = listOf(
        QuizQuestion("Sports", "hard", "Vilken svensk idrottare vann ett guld på de senaste Olympiska spelen?", R.drawable.armand_duplantis, "Armand Duplantis", 600),
        QuizQuestion("Sports", "hard", "Var hölls fotbolls-VM 2010?", R.drawable.world_cup, "Sydafrika", 600),
        QuizQuestion("Sports", "hard", "Vilken säsong gjorde Cristiano Ronaldo flest mål i alla tävlingar?", R.drawable.cr7, "2014–2015", 600),
        QuizQuestion("Sports", "hard", "Vem är bästa målskytt genom tiderna i Sveriges herrlandslag i fotboll?", R.drawable.swedish_team, "Zlatan Ibrahimović", 600),
        QuizQuestion("Sports", "hard", "Vilket skandinaviskt landslag har vunnit fotbolls-EM (UEFA European Championship)?", R.drawable.european_championship, "Danmark", 600),
        QuizQuestion("Sports", "hard", "Vilket land vann det allra första fotbolls-VM år 1930?", R.drawable.world_cup, "Uruguay", 600),
        QuizQuestion("Sports", "hard", "Vilken svensk klubb har näst flest SM-guld/Allsvenska-titlar efter Malmö?", R.drawable.allsvenska, "IFK Göteborg", 600),
        QuizQuestion("Sports", "hard", "Vilken tränare ledde Real Madrid till tre raka Champions League-titlar?", R.drawable.champions, "Zinedine Zidane", 600),
        QuizQuestion("Sports", "hard", "Hur många gånger har Spaniens herrlandslag vunnit fotbolls-VM?", R.drawable.world_cup, "En gång", 600),
        QuizQuestion("Sports", "hard", "Inom boxning: vad kallas en match där man inte använder handskar?", R.drawable.bare_knuckle_boxing, "Barhandsboxning", 600)
    )
    val historyEasy = listOf(
        QuizQuestion("History", "easy", "Vem var USA:s förste president?", null, "George Washington", 200),
        QuizQuestion("History", "easy", "Vilket år tog andra världskriget slut?", null, "1945", 200),
        QuizQuestion("History", "easy", "Vilken forntida civilisation byggde pyramiderna i Giza?", null, "De forntida egyptierna", 200),
        QuizQuestion("History", "easy", "Vem var Storbritanniens premiärminister under större delen av andra världskriget?", null, "Winston Churchill", 200),
        QuizQuestion("History", "easy", "Vilken mur delade Öst- och Västberlin fram till 1989?", null, "Berlinmuren", 200),
        QuizQuestion("History", "easy", "Vilket år sjönk Titanic?", null, "1912", 200)
    )
    val historyMedium = listOf(
        QuizQuestion("History", "medium", "Vilket imperium styrdes av Djingis khan?", null, "Mongolväldet", 400),
        QuizQuestion("History", "medium", "Vilket år bröt franska revolutionen ut?", null, "1789", 400),
        QuizQuestion("History", "medium", "Vem var den första kalifen inom islam efter profeten Muhammed?", null, "Abu Bakr", 400),
        QuizQuestion("History", "medium", "Vilket land var först i världen med att ge kvinnor rösträtt på nationell nivå, år 1893?", null, "Nya Zeeland", 400),
        QuizQuestion("History", "medium", "Vad hette skeppet som förde pilgrimerna till Amerika 1620?", null, "Mayflower", 400),
        QuizQuestion("History", "medium", "Vilket forntida imperium byggde Colosseum i Rom?", null, "Romerska riket", 400)
    )
    val historyHard = listOf(
        QuizQuestion("History", "hard", "Vilken svensk kung dog i slaget vid Fredrikshald 1718?", null, "Karl XII", 600),
        QuizQuestion("History", "hard", "Vilket år upphörde Osmanska riket officiellt att existera?", null, "1922", 600),
        QuizQuestion("History", "hard", "Vad hette freden som officiellt avslutade första världskriget?", null, "Versaillesfreden", 600),
        QuizQuestion("History", "hard", "Vilken islamisk dynasti, med säte i Bagdad, är känd för en guldålder inom vetenskap och lärdom?", null, "Abbasidkalifatet", 600),
        QuizQuestion("History", "hard", "Vem var den förste kejsaren att ena Kina, år 221 f.Kr.?", null, "Qin Shi Huang", 600),
        QuizQuestion("History", "hard", "Vem var den siste aktiva faraon i det ptolemaiska Egypten?", null, "Kleopatra VII", 600)
    )
    val moviesEasy = listOf(
        QuizQuestion("Movies", "easy", "Vilken filmserie handlar om en ung trollkarl vid namn Harry Potter?", null, "Harry Potter", 200),
        QuizQuestion("Movies", "easy", "Vem regisserade filmen \"Titanic\" (1997)?", null, "James Cameron", 200),
        QuizQuestion("Movies", "easy", "Vilken animationsstudio skapade \"Toy Story\"?", null, "Pixar", 200),
        QuizQuestion("Movies", "easy", "Vad heter ringen i \"Sagan om ringen\"?", null, "Den enda ringen", 200),
        QuizQuestion("Movies", "easy", "Vilken superhjälte kallas \"Stålmannen\"?", null, "Superman", 200),
        QuizQuestion("Movies", "easy", "I vilken filmserie förekommer karaktären Luke Skywalker?", null, "Star Wars", 200)
    )
    val moviesMedium = listOf(
        QuizQuestion("Movies", "medium", "Vilken skådespelare spelade Jokern i \"The Dark Knight\" (2008)?", null, "Heath Ledger", 400),
        QuizQuestion("Movies", "medium", "Vilken film från 1994 handlar om en man vid namn Forrest Gump?", null, "Forrest Gump", 400),
        QuizQuestion("Movies", "medium", "Vilken film vann Oscar för bästa film 2020 och blev den första icke-engelskspråkiga filmen att göra det?", null, "Parasite", 400),
        QuizQuestion("Movies", "medium", "Vem komponerade filmmusiken till \"Star Wars\"?", null, "John Williams", 400),
        QuizQuestion("Movies", "medium", "Vad heter det fiktiva afrikanska landet i \"Black Panther\"?", null, "Wakanda", 400),
        QuizQuestion("Movies", "medium", "Vilken studio producerar filmserien om James Bond?", null, "Eon Productions", 400)
    )
    val moviesHard = listOf(
        QuizQuestion("Movies", "hard", "Vem regisserade filmen \"Inception\" (2010)?", null, "Christopher Nolan", 600),
        QuizQuestion("Movies", "hard", "Vilken film var den första någonsin att vinna en Oscar för bästa film, 1929?", null, "Wings", 600),
        QuizQuestion("Movies", "hard", "Vilken film från 1975, regisserad av Steven Spielberg, räknas som den första sommarblockbustern?", null, "Jaws (Hajen)", 600),
        QuizQuestion("Movies", "hard", "Vem spelade huvudrollen i filmen \"Lawrence of Arabia\" från 1962?", null, "Peter O'Toole", 600),
        QuizQuestion("Movies", "hard", "Vilken skådespelerska har fått flest Oscarsnomineringar genom tiderna?", null, "Meryl Streep", 600),
        QuizQuestion("Movies", "hard", "Vad hette den första animerade långfilmen någonsin, utgiven av Disney 1937?", null, "Snövit och de sju dvärgarna", 600)
    )
    val scienceEasy = listOf(
        QuizQuestion("Science", "easy", "Vilken planet kallas den röda planeten?", null, "Mars", 200),
        QuizQuestion("Science", "easy", "Vilken gas behöver människor andas för att överleva?", null, "Syre", 200),
        QuizQuestion("Science", "easy", "Vid vilken temperatur i Celsius kokar vatten?", null, "100°C", 200),
        QuizQuestion("Science", "easy", "Hur många ben har en vuxen människa i kroppen?", null, "206", 200),
        QuizQuestion("Science", "easy", "Vad kallas cellens kraftverk?", null, "Mitokondrier", 200),
        QuizQuestion("Science", "easy", "Vilken kraft drar föremål mot jorden?", null, "Gravitation", 200)
    )
    val scienceMedium = listOf(
        QuizQuestion("Science", "medium", "Vilken kemisk symbol har guld?", null, "Au", 400),
        QuizQuestion("Science", "medium", "Vilken vetenskapsman utvecklade relativitetsteorin?", null, "Albert Einstein", 400),
        QuizQuestion("Science", "medium", "Vilket är det hårdaste naturligt förekommande ämnet på jorden?", null, "Diamant", 400),
        QuizQuestion("Science", "medium", "Vilken typ av djur är en komodovaran?", null, "En ödla (reptil)", 400),
        QuizQuestion("Science", "medium", "Vilken planet har flest kända månar i solsystemet?", null, "Saturnus", 400),
        QuizQuestion("Science", "medium", "Vad kallas läran om jordbävningar?", null, "Seismologi", 400)
    )
    val scienceHard = listOf(
        QuizQuestion("Science", "hard", "Vad kallas processen där stjärnor producerar energi?", null, "Kärnfusion", 600),
        QuizQuestion("Science", "hard", "Vilken partikel, upptäckt 2012, är kopplad till att ge massa åt andra partiklar?", null, "Higgsbosonen", 600),
        QuizQuestion("Science", "hard", "Vad är ljusets hastighet i vakuum (ungefär)?", null, "Cirka 300 000 km/sekund", 600),
        QuizQuestion("Science", "hard", "Vilken vetenskapsman lade grunden för de genetiska nedärvningslagarna?", null, "Gregor Mendel", 600),
        QuizQuestion("Science", "hard", "Vad heter galaxen som vårt solsystem tillhör?", null, "Vintergatan", 600),
        QuizQuestion("Science", "hard", "Vilket grundämne har atomnummer 1?", null, "Väte", 600)
    )
}

object QuizDataAR {
    val flagsEasy = listOf(
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.france, "فرنسا", 200),
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.canda, "كندا", 200),
        QuizQuestion("الأعلام والدول", "easy", "ما هي عاصمة اليابان؟", R.drawable.tokyo, "طوكيو", 200),
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.ireland, "إيرلندا", 200),
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.japanflag, "اليابان", 200),
        QuizQuestion("الأعلام والدول", "easy", "أي دولة عاصمتها برازيليا؟", R.drawable.brazilia, "البرازيل", 200),
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.usa_flag, "الولايات المتحدة", 200),
        QuizQuestion("الأعلام والدول", "easy", "ما هي عاصمة مصر؟", R.drawable.cairo, "القاهرة", 200),
        QuizQuestion("الأعلام والدول", "easy", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_cuba, "كوبا", 200),
        QuizQuestion("الأعلام والدول", "easy", "عاصمة أستراليا ليست سيدني، ما هي؟", R.drawable.canberra, "كانبيرا", 200)
    )
    val flagsMedium = listOf(
        QuizQuestion("الأعلام والدول", "medium", "أي دولة إفريقية يحتوي علمها على نجمة ذهبية داخل مثلث أزرق وخطوط خضراء وحمراء؟", R.drawable.flag_mozambique, "موزمبيق", 400),
        QuizQuestion("الأعلام والدول", "medium", "ما الاسم الرسمي الحالي لعاصمة كازاخستان بعد إعادة تسميتها عدة مرات؟", R.drawable.astana, "أستانا", 400),
        QuizQuestion("الأعلام والدول", "medium", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_palestine, "فلسطين", 400),
        QuizQuestion("الأعلام والدول", "medium", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_iraq, "العراق", 400),
        QuizQuestion("الأعلام والدول", "medium", "ما هي العاصمة الإدارية لتركيا؟", R.drawable.ankara, "أنقرة", 400),
        QuizQuestion("الأعلام والدول", "medium", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_syria, "سوريا", 400),
        QuizQuestion("الأعلام والدول", "hard", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_morocco, "المغرب", 400),
        QuizQuestion("الأعلام والدول", "medium", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_thailand, "تايلاند", 400),
        QuizQuestion("الأعلام والدول", "medium", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_somalia, "الصومال", 400),
        QuizQuestion("الأعلام والدول", "hard", "إلى أي دولة ينتمي هذا العلم؟", R.drawable.flag_sweden, "السويد", 400)
    )
    val flagsHard = listOf(
        QuizQuestion("الأعلام والدول", "hard", "ما هي عاصمة نيوزيلندا؟", R.drawable.wellington, "ويلينغتون", 600),
        QuizQuestion("الأعلام والدول", "hard", "أي دولة في العالم ليس لديها عاصمة رسمية؟", R.drawable.nauru, "ناورو", 600),
        QuizQuestion("الأعلام والدول", "hard", "أي دولة تحتوي على أكبر عدد من الجزر في العالم؟", R.drawable.island_sweden, "السويد", 600),
        QuizQuestion("الأعلام والدول", "hard", "ما هو المحيط الأكثر ملوحة؟", R.drawable.ocean, "المحيط الأطلسي", 600),
        QuizQuestion("الأعلام والدول", "hard", "هذا العلم ثلاثي الألوان الأسود والأصفر والأبيض كان تابعًا لأي إمبراطورية سابقة؟", R.drawable.flag_of_russian_empire, "الإمبراطورية الروسية", 600),
        QuizQuestion("الأعلام والدول", "hard", "ما هي عاصمة لبنان؟", R.drawable.beriut, "بيروت", 600),
        QuizQuestion("الأعلام والدول", "hard", "أين تقع مدينة بيت لحم؟", R.drawable.betlahim, "فلسطين", 600),
        QuizQuestion("الأعلام والدول", "hard", "أين تقع أول جامعة في العالم؟", R.drawable.uni_morocco, "المغرب", 600),
        QuizQuestion("الأعلام والدول", "hard", "ما هي عاصمة كولومبيا؟", R.drawable.bogota, "بوغوتا", 600),
        QuizQuestion("الأعلام والدول", "hard", "ما هي أقدم عاصمة في العالم؟", R.drawable.damascus, "دمشق", 600)
    )
    val geographyEasy = listOf(
        QuizQuestion("الجغرافيا", "easy", "أي مدينة تحتوي على برج إيفل؟", R.drawable.eiffel, "باريس", 200),
        QuizQuestion("الجغرافيا", "easy", "أي دولة مشهورة بأهرامات الجيزة؟", R.drawable.pyramids, "مصر", 200),
        QuizQuestion("الجغرافيا", "easy", "يقع جبل إيفرست على حدود نيبال وأي دولة؟", R.drawable.mount_everest, "الصين", 200),
        QuizQuestion("الجغرافيا", "easy", "في أي قارة يقع صحراء الصحراء الكبرى؟", R.drawable.sahara, "أفريقيا", 200),
        QuizQuestion("الجغرافيا", "easy", "ما هي عاصمة إيطاليا؟", R.drawable.rome, "روما", 200),
        QuizQuestion("الجغرافيا", "easy", "أي تمثال شهير يقف في ميناء نيويورك؟", R.drawable.statue_hero, "تمثال الحرية", 200),
        QuizQuestion("الجغرافيا", "easy", "أي دولة تعرف باسم أرض الشمس المشرقة؟", R.drawable.sun, "اليابان", 200),
        QuizQuestion("الجغرافيا", "easy", "ما هو أكبر محيط على الأرض؟", R.drawable.ocean, "المحيط الهادئ", 200),
        QuizQuestion("الجغرافيا", "easy", "ما هي أكبر مدينة في العالم؟", R.drawable.japan1, "طوكيو", 200),
        QuizQuestion("الجغرافيا", "easy", "ما هي أصغر قارة في العالم؟", R.drawable.map7, "أستراليا", 200)
    )
    val geographyMedium = listOf(
        QuizQuestion("الجغرافيا", "medium", "أي دولة إفريقية لديها أكبر عدد من السكان؟", R.drawable.map_africa, "نيجيريا", 400),
        QuizQuestion("الجغرافيا", "medium", "ما هي أكبر ولاية في الولايات المتحدة؟", R.drawable.usa_map, "ألاسكا", 400),
        QuizQuestion("الجغرافيا", "medium", "ما هو أطول نهر في العالم؟", R.drawable.nile_river, "نهر النيل", 400),
        QuizQuestion("الجغرافيا", "medium", "ما هو أطول نهر في أوروبا؟", R.drawable.volga, "نهر الفولغا", 400),
        QuizQuestion("الجغرافيا", "medium", "أي دولة تملك جزيرة جرينلاند؟", R.drawable.grenland, "الدنمارك", 400),
        QuizQuestion("الجغرافيا", "medium", "أي دولة لديها أكبر عدد من المناطق الزمنية؟", R.drawable.timezone, "فرنسا", 400),
        QuizQuestion("الجغرافيا", "medium", "أي دولة لديها أكبر عدد من المسلمين في العالم؟", R.drawable.muslim, "إندونيسيا", 400),
        QuizQuestion("الجغرافيا", "medium", "أي دولة تحتوي على أكبر جزء من غابات الأمازون؟", R.drawable.amazon, "البرازيل", 400),
        QuizQuestion("الجغرافيا", "medium", "أي سلسلة جبال أوروبية تمر عبر سويسرا وفرنسا وإيطاليا؟", R.drawable.alps, "جبال الألب", 400),
        QuizQuestion("الجغرافيا", "medium", "في أي دولة تقع مدينة البتراء القديمة؟", R.drawable.petra, "الأردن", 400)
    )
    val geographyHard = listOf(
        QuizQuestion("الجغرافيا", "hard", "أي دولة تحتوي على قمة جبل K2؟", R.drawable.k2, "باكستان", 600),
        QuizQuestion("الجغرافيا", "hard", "ما هي الدولة ذات أقل عدد سكان بين الدول المستقلة؟", R.drawable.vatican_city, "مدينة الفاتيكان", 600),
        QuizQuestion("الجغرافيا", "hard", "أي نهر يمر عبر غراند كانيون؟", R.drawable.colorado_river, "نهر كولورادو", 600),
        QuizQuestion("الجغرافيا", "hard", "ما هو أكبر صحراء غير قطبية في العالم؟", R.drawable.sahara, "صحراء الصحراء الكبرى", 600),
        QuizQuestion("الجغرافيا", "hard", "أي دولة لديها أكبر عدد من مواقع التراث العالمي لليونسكو؟", R.drawable.itlay, "إيطاليا", 600),
        QuizQuestion("الجغرافيا", "hard", "أي مدينة تقع عند التقاء النيل الأزرق والأبيض؟", R.drawable.khartoum, "الخرطوم", 600),
        QuizQuestion("الجغرافيا", "hard", "ما هي مساحة السويد التقريبية؟", R.drawable.sweden_map, "449,964 كيلومتر مربع", 600),
        QuizQuestion("الجغرافيا", "hard", "ما هي مساحة الدنمارك التقريبية؟", R.drawable.denmark_map, "42,933 كيلومتر مربع", 600)
    )
    val carsEasy = listOf(
        QuizQuestion("السيارات", "easy", "أي شركة تصنع سيارة Civic؟", R.drawable.honda_civic, "هوندا", 200),
        QuizQuestion("السيارات", "easy", "أي ماركة سيارات لديها حصان واقف كشعار لها؟", R.drawable.ferrari, "فيراري", 200),
        QuizQuestion("السيارات", "easy", "أي شركة ألمانية تصنع الفئة 3 Series؟", R.drawable.bmw3series, "بي إم دبليو", 200),
        QuizQuestion("السيارات", "easy", "أي ماركة سيارات تستخدم أربعة حلقات متشابكة كشعار؟", R.drawable.audi, "أودي", 200),
        QuizQuestion("السيارات", "easy", "أي شركة تنتج سيارة Mustang؟", R.drawable.mustang, "فورد", 200),
        QuizQuestion("السيارات", "easy", "أي ماركة معروفة بسيارة Beetle؟", R.drawable.beetle, "فولكس فاجن", 200),
        QuizQuestion("السيارات", "easy", "أي دولة تتخذ منها تسلا مقرًا لها؟", R.drawable.tesla, "الولايات المتحدة", 200),
        QuizQuestion("السيارات", "easy", "ما نوع سيارة تويوتا بريوس؟", R.drawable.prius, "هجينة", 200),
        QuizQuestion("السيارات", "easy", "أي شركة إيطالية تصنع Huracán؟", R.drawable.huracan, "لامبورغيني", 200),
        QuizQuestion("السيارات", "easy", "أي ماركة تصنع سيارة Corolla؟", R.drawable.corolla, "تويوتا", 200)
    )
    val carsMedium = listOf(
        QuizQuestion("السيارات", "medium", "أي دولة تصنع ماركة فولفو؟", R.drawable.volvo, "السويد", 400),
        QuizQuestion("السيارات", "medium", "ماذا تعني GTI في سيارات الأداء؟", R.drawable.gti, "Grand Touring Injection", 400),
        QuizQuestion("السيارات", "medium", "أي ماركة صنعت سيارة Countach الشهيرة؟", R.drawable.countach, "لامبورغيني", 400),
        QuizQuestion("السيارات", "medium", "أي سيارة تستخدم نظام الدفع الرباعي Quattro؟", R.drawable.quattro, "أودي", 400),
        QuizQuestion("السيارات", "medium", "أي شركة تنتج الماركة الفاخرة Lexus؟", R.drawable.lexus, "تويوتا", 400),
        QuizQuestion("السيارات", "medium", "أي سيارة بي إم دبليو تحتوي على محرك V10؟", R.drawable.e60, "BMW M5 E60", 400),
        QuizQuestion("السيارات", "medium", "أي سيارة تستخدم نظام الدفع الرباعي 4MATIC؟", R.drawable.mercedes_4matic, "مرسيدس-بنز", 400),
        QuizQuestion("السيارات", "medium", "أي شعار لعلامة تجارية يحتوي على ثلاثية الرمح؟", R.drawable.maserati, "مازيراتي", 400),
        QuizQuestion("السيارات", "medium", "كم عدد الماركات الكبرى التي يمتلكها مجموعة فولكس فاجن؟", R.drawable.vw_group, "12", 400),
        QuizQuestion("السيارات", "medium", "كم قوة حصان تقريبية لدى BMW F10 M5؟", R.drawable.bmw_f10, "560 حصان", 400)
    )
    val carsHard = listOf(
        QuizQuestion("السيارات", "hard", "أي ماركة من مجموعة فولكس فاجن معروفة بإنتاج سيارات فاخرة فائق السرعة مثل Chiron؟", R.drawable.f1_1990s, "بوجاتي", 600),
        QuizQuestion("السيارات", "hard", "ما السرعة القصوى الدقيقة لسيارة Bugatti Chiron Super Sport 300+ بالكيلومتر/الساعة؟", R.drawable.bugatti_chiron, "490 كم/س", 600),
        QuizQuestion("السيارات", "hard", "لأي شركة كان يعمل Nils Bohlin عندما اخترع حزام الأمان ثلاثي النقاط؟", R.drawable.volvo, "فولفو", 600),
        QuizQuestion("السيارات", "hard", "متى توقفت علامة Hummer عن الإنتاج؟", R.drawable.hummer, "2010", 600),
        QuizQuestion("السيارات", "hard", "أي ماركة صنعت سيارة خارقة نادرة باسم 'F1' في التسعينيات؟", R.drawable.f1_1990s, "ماكلارين", 600),
        QuizQuestion("السيارات", "hard", "أي شركة كانت أول من استخدمت مساحات الزجاج الأمامي؟", R.drawable.cadillac, "كاديلاك", 600),
        QuizQuestion("السيارات", "hard", "ما اسم سيارة تويوتا هذه؟", R.drawable.rav4, "RAV4", 600),
        QuizQuestion("السيارات", "hard", "ما اسم سيارة أودي هذه؟", R.drawable.audi_rq8, "Audi RQ8", 600),
        QuizQuestion("السيارات", "hard", "ما اسم سيارة مرسيدس هذه؟", R.drawable.gle, "GLE Coupe", 600),
        QuizQuestion("السيارات", "hard", "أي ماركة إيطالية صنعت السيارة الخارقة النادرة 'MC12'؟", R.drawable.mc12, "مازيراتي", 600)
    )
    val commonKnowledgeEasy = listOf(
        QuizQuestion("المعرفة العامة", "easy", "ما أكبر كوكب في المجموعة الشمسية؟", R.drawable.solar_system, "المشتري", 200),
        QuizQuestion("المعرفة العامة", "easy", "ما أكبر عضو في جسم الإنسان؟", R.drawable.skin, "الجلد", 200),
        QuizQuestion("المعرفة العامة", "easy", "أي دولة هي الأكبر مساحةً في العالم؟", R.drawable.map_of_world, "روسيا", 200),
        QuizQuestion("المعرفة العامة", "easy", "أي طائر معروف بقدرته على تقليد الأصوات وذكائه؟", R.drawable.animals, "ببغاء", 200),
        QuizQuestion("المعرفة العامة", "easy", "ما الصيغة الكيميائية للملح؟", R.drawable.periodic_table, "NaCl", 200),
        QuizQuestion("المعرفة العامة", "easy", "أي كارثة طبيعية يتم قياسها بمقياس ريختر؟", R.drawable.natural_disater, "زلزال", 200),
        QuizQuestion("المعرفة العامة", "easy", "في أي محيط يقع مثلث برمودا؟", R.drawable.oceans, "المحيط الأطلسي", 200),
        QuizQuestion("المعرفة العامة", "easy", "ما هو أصغر عدد أولي؟", R.drawable.math, "2", 200),
        QuizQuestion("المعرفة العامة", "easy", "أي عالم مشهور قدم قوانين الحركة الثلاثة؟", R.drawable.three_laws, "إسحاق نيوتن", 200),
        QuizQuestion("المعرفة العامة", "easy", "أي دولة هي أكبر منتج للأرز في العالم؟", R.drawable.rice, "الصين", 200)
    )
    val commonKnowledgeMedium = listOf(
        QuizQuestion("المعرفة العامة", "medium", "في أي عام احتلت فلسطين من قبل إسرائيل؟", R.drawable.palestine1948, "1948", 400),
        QuizQuestion("المعرفة العامة", "medium", "أي لغة لديها أكبر عدد من المتحدثين الأصليين في العالم؟", R.drawable.mandarin, "الماندرين الصينية", 400),
        QuizQuestion("المعرفة العامة", "medium", "متى بدأ الانتفاضة السورية ضد بشار الأسد؟", R.drawable.syrian_uprising, "مارس 2011", 400),
        QuizQuestion("المعرفة العامة", "medium", "من هو أول شخص حاول الطيران بأجنحة صناعية في القرن التاسع؟", R.drawable.abbas, "عباس بن فرناس", 400),
        QuizQuestion("المعرفة العامة", "medium", "في أي عام هبط أول إنسان على سطح القمر؟", R.drawable.moon, "1969", 400),
        QuizQuestion("المعرفة العامة", "medium", "ما هي الدول الإسكندنافية الرئيسية؟", R.drawable.scandinavian, "السويد، النرويج، الدنمارك، فنلندا وآيسلندا", 400),
        QuizQuestion("المعرفة العامة", "medium", "أي مركب تنتجه النباتات أثناء البناء الضوئي ويستخدم كمصدر للطاقة؟", R.drawable.photosynthesis, "الجلوكوز", 400),
        QuizQuestion("المعرفة العامة", "medium", "أي دولة اخترعت تقنية البلوتوث؟", R.drawable.bluetooth, "السويد", 400),
        QuizQuestion("المعرفة العامة", "medium", "متى كانت آخر مرة شاركت السويد في حرب فعلية؟", R.drawable.sweden1814, "1814", 400),
        QuizQuestion("المعرفة العامة", "medium", "أي دولة تعتبر عاصمة العطور الفاخرة؟", R.drawable.perfumes, "فرنسا", 400)
    )
    val commonKnowledgeHard = listOf(
        QuizQuestion("المعرفة العامة", "hard", "أي فيلسوف مشهور بعبارة 'أنا أفكر، إذن أنا موجود'؟", R.drawable.rene_descartes, "رينيه ديكارت", 600),
        QuizQuestion("المعرفة العامة", "hard", "ما هو أندر عنصر طبيعي على الأرض؟", R.drawable.periodic_table, "أستاتين", 600),
        QuizQuestion("المعرفة العامة", "hard", "أي مدينة هي مقر الاتحاد الأوروبي؟", R.drawable.eu, "بروكسل", 600),
        QuizQuestion("المعرفة العامة", "hard", "أي الثدييات قادرة على الطيران الحقيقي؟", R.drawable.animals, "الخفاش", 600),
        QuizQuestion("المعرفة العامة", "hard", "أي قارة هي الوحيدة التي لا تحتوي على زواحف أو ثعابين؟", R.drawable.oceans, "أنتاركتيكا", 600),
        QuizQuestion("المعرفة العامة", "hard", "في أي عام توفي نابليون بونابرت؟", R.drawable.napoleon, "1821", 600),
        QuizQuestion("المعرفة العامة", "hard", "أي فيتامين يُنتج عندما يتعرض الجلد لأشعة الشمس؟", R.drawable.sun, "فيتامين D", 600),
        QuizQuestion("المعرفة العامة", "hard", "أي دولة أوروبية لديها أطول خط ساحلي متصل؟", R.drawable.coastline, "النرويج", 600),
        QuizQuestion("المعرفة العامة", "hard", "ما هو أكبر عضو داخلي من حيث الكتلة في جسم الإنسان؟", R.drawable.skin, "الكبد", 600),
        QuizQuestion("المعرفة العامة", "hard", "في أي سنوات وقعت الحرب العالمية الأولى؟", R.drawable.world_war1, "1914 – 1918", 600)
    )
    val sportsEasy = listOf(
        QuizQuestion("الرياضة", "easy", "أي رياضة تُعرف باسم 'اللعبة الجميلة'؟", R.drawable.allsports, "كرة القدم", 200),
        QuizQuestion("الرياضة", "easy", "في أي رياضة يُؤدى السلم دانك؟", R.drawable.allsports, "كرة السلة", 200),
        QuizQuestion("الرياضة", "easy", "كم عدد اللاعبين في فريق كرة الطائرة القياسي على الملعب؟", R.drawable.volleyball, "ستة", 200),
        QuizQuestion("الرياضة", "easy", "أي رياضة تستخدم الريشة؟", R.drawable.shuttlecock, "الريشة الطائرة", 200),
        QuizQuestion("الرياضة", "easy", "أي نادي فاز بأكبر عدد من بطولات دوري أبطال أوروبا؟", R.drawable.champions, "ريال مدريد", 200),
        QuizQuestion("الرياضة", "easy", "ماذا تمثل الحلقات الخمس في شعار الألعاب الأولمبية؟", R.drawable.olympic, "القارات الخمس الكبرى", 200),
        QuizQuestion("الرياضة", "easy", "أي رياضة تُلعب على حلبة جليدية باستخدام قرص؟", R.drawable.ice_rink, "هوكي الجليد", 200),
        QuizQuestion("الرياضة", "easy", "أي دولة فازت بأكبر عدد من بطولات كأس العالم لكرة القدم؟", R.drawable.world_cup, "البرازيل", 200),
        QuizQuestion("الرياضة", "easy", "كم خسارة تكبدها إسلام مخاشيف في مسيرته في UFC حتى الآن؟", R.drawable.islam, "خسارة واحدة", 200),
        QuizQuestion("الرياضة", "easy", "أي رياضة تمنح جائزة Heisman Trophy؟", R.drawable.heisman_trophy, "كرة القدم الأمريكية", 200)
    )
    val sportsMedium = listOf(
        QuizQuestion("الرياضة", "medium", "أي دولة فازت بكأس العالم لكرة القدم 2018؟", R.drawable.world_cup, "فرنسا", 400),
        QuizQuestion("الرياضة", "medium", "كم عدد بطولات دوري أبطال أوروبا التي فاز بها نادي ميلان حتى الآن؟", R.drawable.ac_milan, "7", 400),
        QuizQuestion("الرياضة", "medium", "متى فاز نادي برشلونة آخر مرة بدوري أبطال أوروبا؟", R.drawable.barca, "2015", 400),
        QuizQuestion("الرياضة", "medium", "أي فريق يلعب له لاعب كرة السلة ليبرون جيمس حالياً؟", R.drawable.lebron_james, "لوس أنجلوس ليكرز", 400),
        QuizQuestion("الرياضة", "medium", "في أي دولة نشأت رياضة الجودو؟", R.drawable.judo, "اليابان", 400),
        QuizQuestion("الرياضة", "medium", "أي نادي فاز بأكبر عدد من الألقاب منذ إعادة تسمية الدوري في 1992؟", R.drawable.premier_league, "مانشستر يونايتد", 400),
        QuizQuestion("الرياضة", "medium", "ماذا يسمى عندما يسجل لاعب كرة قدم ثلاثة أهداف في مباراة واحدة؟", R.drawable.hat_trick, "هاتريك", 400),
        QuizQuestion("الرياضة", "medium", "أي فريق كرة سلة فاز بأكبر عدد من بطولات NBA؟", R.drawable.nba_championship, "بوسطن سيلتيكس", 400),
        QuizQuestion("الرياضة", "medium", "أي دولة تستضيف سباق الدراجات الشهير 'Tour de France'؟", R.drawable.tour_de_france, "فرنسا", 400),
        QuizQuestion("الرياضة", "medium", "ما هي ثاني الرياضات الأكثر شعبية وممارسة في السويد بعد كرة القدم؟", R.drawable.allsports, "هوكي الجليد", 400)
    )
    val sportsHard = listOf(
        QuizQuestion("الرياضة", "hard", "من هو الرياضي السويدي الذي فاز بميدالية ذهبية في آخر الألعاب الأولمبية؟", R.drawable.armand_duplantis, "أرماند دوبلانتيس", 600),
        QuizQuestion("الرياضة", "hard", "أين أقيم كأس العالم لكرة القدم 2010؟", R.drawable.world_cup, "جنوب أفريقيا", 600),
        QuizQuestion("الرياضة", "hard", "في أي موسم سجل كريستيانو رونالدو أكبر عدد من الأهداف في جميع البطولات؟", R.drawable.cr7, "2014–2015", 600),
        QuizQuestion("الرياضة", "hard", "من هو هداف منتخب السويد لكرة القدم على مر التاريخ؟", R.drawable.swedish_team, "زلاتان إبراهيموفيتش", 600),
        QuizQuestion("الرياضة", "hard", "أي منتخب إسكندنافي فاز ببطولة أمم أوروبا UEFA؟", R.drawable.european_championship, "الدنمارك", 600),
        QuizQuestion("الرياضة", "hard", "أي دولة فازت بأول كأس عالم في تاريخ البطولة عام 1930؟", R.drawable.world_cup, "أوروغواي", 600),
        QuizQuestion("الرياضة", "hard", "أي نادٍ سويدي يحتل المركز الثاني في عدد ألقاب الدوري السويدي بعد مالمو؟", R.drawable.allsvenska, "آي إف كي غوتنبرغ", 600),
        QuizQuestion("الرياضة", "hard", "أي مدرب قاد ريال مدريد للفوز بثلاث بطولات دوري أبطال أوروبا متتالية؟", R.drawable.champions, "زين الدين زيدان", 600),
        QuizQuestion("الرياضة", "hard", "كم مرة فاز المنتخب الإسباني بكأس العالم لكرة القدم؟", R.drawable.world_cup, "مرة واحدة", 600),
        QuizQuestion("الرياضة", "hard", "في الملاكمة، ما المصطلح الخاص بالمباراة التي لا يُرتدى فيها قفازات؟", R.drawable.bare_knuckle_boxing, "ملاكمة بدون قفازات", 600)
    )
    val historyEasy = listOf(
        QuizQuestion("التاريخ", "easy", "من كان أول رئيس للولايات المتحدة؟", null, "جورج واشنطن", 200),
        QuizQuestion("التاريخ", "easy", "في أي عام انتهت الحرب العالمية الثانية؟", null, "1945", 200),
        QuizQuestion("التاريخ", "easy", "أي حضارة قديمة بنت أهرامات الجيزة؟", null, "المصريون القدماء", 200),
        QuizQuestion("التاريخ", "easy", "من كان رئيس وزراء بريطانيا خلال معظم فترة الحرب العالمية الثانية؟", null, "ونستون تشرشل", 200),
        QuizQuestion("التاريخ", "easy", "أي سور فصل بين برلين الشرقية والغربية حتى عام 1989؟", null, "سور برلين", 200),
        QuizQuestion("التاريخ", "easy", "في أي عام غرقت سفينة تيتانيك؟", null, "1912", 200)
    )
    val historyMedium = listOf(
        QuizQuestion("التاريخ", "medium", "أي إمبراطورية حكمها جنكيز خان؟", null, "الإمبراطورية المغولية", 400),
        QuizQuestion("التاريخ", "medium", "في أي عام اندلعت الثورة الفرنسية؟", null, "1789", 400),
        QuizQuestion("التاريخ", "medium", "من كان أول خليفة للمسلمين بعد النبي محمد؟", null, "أبو بكر الصديق", 400),
        QuizQuestion("التاريخ", "medium", "أي دولة كانت أول من منح المرأة حق التصويت على المستوى الوطني عام 1893؟", null, "نيوزيلندا", 400),
        QuizQuestion("التاريخ", "medium", "ما اسم السفينة التي نقلت الحجاج إلى أمريكا عام 1620؟", null, "ماي فلاور", 400),
        QuizQuestion("التاريخ", "medium", "أي إمبراطورية قديمة بنت الكولوسيوم في روما؟", null, "الإمبراطورية الرومانية", 400)
    )
    val historyHard = listOf(
        QuizQuestion("التاريخ", "hard", "أي ملك سويدي توفي في معركة فريدريكسهالد عام 1718؟", null, "تشارلز الثاني عشر (كارل الثاني عشر)", 600),
        QuizQuestion("التاريخ", "hard", "في أي عام انتهت الدولة العثمانية رسميًا؟", null, "1922", 600),
        QuizQuestion("التاريخ", "hard", "ما اسم المعاهدة التي أنهت رسميًا الحرب العالمية الأولى؟", null, "معاهدة فرساي", 600),
        QuizQuestion("التاريخ", "hard", "أي دولة إسلامية، ومقرها بغداد، تشتهر بعصر ذهبي للعلم والمعرفة؟", null, "الخلافة العباسية", 600),
        QuizQuestion("التاريخ", "hard", "من كان أول إمبراطور وحّد الصين عام 221 قبل الميلاد؟", null, "تشين شي هوانغ", 600),
        QuizQuestion("التاريخ", "hard", "من كانت آخر ملكة حاكمة فعليًا في مصر البطلمية؟", null, "كليوباترا السابعة", 600)
    )
    val moviesEasy = listOf(
        QuizQuestion("السينما", "easy", "أي سلسلة أفلام تدور حول ساحر صغير يدعى هاري بوتر؟", null, "هاري بوتر", 200),
        QuizQuestion("السينما", "easy", "من أخرج فيلم \"تايتانيك\" (1997)؟", null, "جيمس كاميرون", 200),
        QuizQuestion("السينما", "easy", "أي استوديو رسوم متحركة أنتج فيلم \"توي ستوري\"؟", null, "بيكسار", 200),
        QuizQuestion("السينما", "easy", "ما اسم الخاتم في سلسلة \"سيد الخواتم\"؟", null, "الخاتم الواحد", 200),
        QuizQuestion("السينما", "easy", "أي بطل خارق يُلقب بـ\"رجل الفولاذ\"؟", null, "سوبرمان", 200),
        QuizQuestion("السينما", "easy", "في أي سلسلة أفلام تظهر شخصية لوك سكاي ووكر؟", null, "حرب النجوم", 200)
    )
    val moviesMedium = listOf(
        QuizQuestion("السينما", "medium", "أي ممثل لعب دور الجوكر في فيلم \"The Dark Knight\" (2008)؟", null, "هيث ليدجر", 400),
        QuizQuestion("السينما", "medium", "أي فيلم من عام 1994 يحكي قصة رجل يدعى فورست غامب؟", null, "فورست غامب", 400),
        QuizQuestion("السينما", "medium", "أي فيلم فاز بجائزة الأوسكار لأفضل فيلم عام 2020، ليصبح أول فيلم غير ناطق بالإنجليزية يفوز بها؟", null, "باراسايت", 400),
        QuizQuestion("السينما", "medium", "من ألّف الموسيقى التصويرية لسلسلة \"حرب النجوم\"؟", null, "جون ويليامز", 400),
        QuizQuestion("السينما", "medium", "ما اسم الدولة الأفريقية الخيالية في فيلم \"Black Panther\"؟", null, "واكاندا", 400),
        QuizQuestion("السينما", "medium", "أي استوديو ينتج سلسلة أفلام جيمس بوند؟", null, "إيون برودكشنز", 400)
    )
    val moviesHard = listOf(
        QuizQuestion("السينما", "hard", "من أخرج فيلم \"Inception\" (2010)؟", null, "كريستوفر نولان", 600),
        QuizQuestion("السينما", "hard", "أي فيلم كان أول فيلم في التاريخ يفوز بجائزة الأوسكار لأفضل فيلم عام 1929؟", null, "Wings", 600),
        QuizQuestion("السينما", "hard", "أي فيلم من عام 1975، من إخراج ستيفن سبيلبرغ، يعتبر أول فيلم بلوكباستر صيفي؟", null, "الفك المفترس (Jaws)", 600),
        QuizQuestion("السينما", "hard", "من لعب دور البطولة في فيلم \"لورنس العرب\" عام 1962؟", null, "بيتر أوتول", 600),
        QuizQuestion("السينما", "hard", "أي ممثلة حصلت على أكبر عدد من ترشيحات الأوسكار في التاريخ؟", null, "ميريل ستريب", 600),
        QuizQuestion("السينما", "hard", "ما اسم أول فيلم رسوم متحركة طويل في التاريخ، أنتجته ديزني عام 1937؟", null, "سنو وايت والأقزام السبعة", 600)
    )
    val scienceEasy = listOf(
        QuizQuestion("العلوم", "easy", "أي كوكب يُعرف بالكوكب الأحمر؟", null, "المريخ", 200),
        QuizQuestion("العلوم", "easy", "أي غاز يحتاج البشر لتنفسه من أجل البقاء على قيد الحياة؟", null, "الأكسجين", 200),
        QuizQuestion("العلوم", "easy", "عند أي درجة حرارة مئوية يغلي الماء؟", null, "100 درجة مئوية", 200),
        QuizQuestion("العلوم", "easy", "كم عدد عظام جسم الإنسان البالغ؟", null, "206", 200),
        QuizQuestion("العلوم", "easy", "ما اسم \"مصنع الطاقة\" داخل الخلية؟", null, "الميتوكوندريا", 200),
        QuizQuestion("العلوم", "easy", "أي قوة تجذب الأجسام نحو الأرض؟", null, "الجاذبية", 200)
    )
    val scienceMedium = listOf(
        QuizQuestion("العلوم", "medium", "ما هو الرمز الكيميائي للذهب؟", null, "Au", 400),
        QuizQuestion("العلوم", "medium", "أي عالم طور نظرية النسبية؟", null, "ألبرت أينشتاين", 400),
        QuizQuestion("العلوم", "medium", "ما هي أصلب مادة طبيعية على وجه الأرض؟", null, "الألماس", 400),
        QuizQuestion("العلوم", "medium", "ما نوع حيوان تنين كومودو؟", null, "زاحف (سحلية)", 400),
        QuizQuestion("العلوم", "medium", "أي كوكب يمتلك أكبر عدد من الأقمار المعروفة في المجموعة الشمسية؟", null, "زحل", 400),
        QuizQuestion("العلوم", "medium", "ما اسم علم دراسة الزلازل؟", null, "علم الزلازل", 400)
    )
    val scienceHard = listOf(
        QuizQuestion("العلوم", "hard", "ما اسم العملية التي تنتج بها النجوم طاقتها؟", null, "الاندماج النووي", 600),
        QuizQuestion("العلوم", "hard", "أي جسيم، اكتُشف عام 2012، يرتبط بإعطاء الكتلة لجسيمات أخرى؟", null, "بوزون هيغز", 600),
        QuizQuestion("العلوم", "hard", "ما هي سرعة الضوء تقريبًا في الفراغ؟", null, "حوالي 300,000 كيلومتر في الثانية", 600),
        QuizQuestion("العلوم", "hard", "أي عالم وضع أسس قوانين الوراثة الجينية؟", null, "غريغور مندل", 600),
        QuizQuestion("العلوم", "hard", "ما اسم المجرة التي يقع فيها نظامنا الشمسي؟", null, "درب التبانة", 600),
        QuizQuestion("العلوم", "hard", "ما هو العنصر الذي رقمه الذري 1؟", null, "الهيدروجين", 600)
    )
}
