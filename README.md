Q&A Home Screen Game
App name (Google Play): Question & Answer – Home Screen (Q&A)
A team-based quiz and party game designed for playing together on one Android device in landscape mode.

1. Problem Statement
   Most quiz apps focus on single-player gameplay or strict rules. This app instead enables a social, flexible, team-based experience where players decide their own pacing and rules.

2. Solution Overview
   The app offers: - A category-based quiz board - Team scoring with fixed points - Acting challenges using QR codes - Dark / light theme support - English and Swedish language support

3. How the Application Works
   •	Animated loading screen on launch.
   •	Game locked to landscape mode.
   •	Shared abstract Game class for scoring and logic.
   •	ViewModels keep game state during rotation.



4. Gameplay Overview
   Categories
1.	Flags & Countries
2.	Geography
3.	Cars
4.	No Word (Act Game)
5.	Common Knowledge
6.	Sports
      Questions
      Each category contains: - Easy (200 pts) - Medium (400 pts) - Hard (600 pts) - One Bonus question
      Answered questions turn gray and cannot be reused.

5. Timer
   •	Timer starts when a question is selected.
   •	It is informational only.
   •	Players decide their own time limits.

6. Answer & Scoring Flow
1.	Teams discuss and lock answers.
2.	Players reveal the correct answer.
3.	Correct team (or no one) is selected.
4.	Points are added automatically.

7. Bonus Mechanic
   •	Bonus buttons are locked initially.
   •	They activate only after all normal questions are answered.
   •	Each bonus can be used once per category.

8. Category Highlights
   •	Flags & Geography: image-based questions
   •	Cars: brands, logos, and origins
   •	No Word: QR-based acting challenge
   •	Common Knowledge & Sports: classic trivia

9. End of Game
   •	Game ends when all questions are completed.
   •	Final scores and winner are shown.

10. Grading – Extra Functionalities
    Achieved
    •	Multiple Languages (1p): English and Swedish using string resources.
    •	Runtime Configuration Changes (4p): ViewModels preserve game state.
    •	Loading Indicators (1p): Animated loading screen.
    •	QR Code Creation (0.5p): Used in No Word category.
    •	QR Code Reading (0.5p): Camera scanning affects gameplay.
    Not Implemented
    Widgets, push notifications, foreground services, alarms, encryption, and automated tests were not included to keep focus on local social gameplay.

11. Conclusion
    Q&A Home Screen is a fast, social quiz game combining knowledge, acting, and strategy, optimized for group play on a single device.
