package com.example.quizapp_v2

object Constants {

    // TODO (STEP 1: Create a constant variables which we required in the result screen.)
    // START
    const val USER_NAME: String = "user_name"
    var current_Position: Int = 1
    var SelectedOptionP: Int = 0
    var CorrectAnswers: Int = 0
    var initialCountDown:  Long= 600000
    var check : Boolean= false
    var quiz_type : Boolean= false
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val maths_Questions_List = ArrayList<Question>()
        // 1
        val q1 = Question(
            1, "Question 1. The average of first 50 natural numbers is?",
            R.drawable.ic_math_quiz ,
            " A. 25.30", " B. 25.5",
            " C. 25.00", " D. 12.25", 2
        )

        maths_Questions_List.add(q1)

        // 2
        val q2 = Question(
            2, "Question 2. A fraction which bears the same ratio to 1/27 as 3/11 bear to 5/9 is equal to?",
            R.drawable.ic_math_quiz ,
            " A. 1/55", " B. 55",
            " C. 3/11", " D. 1/11", 1
        )

        maths_Questions_List.add(q2)

        // 3
        val q3 = Question(
            3, "Question 3. The number of 3-digit numbers divisible by 6, is?",
            R.drawable.ic_math_quiz ,
            " A. 149", " B. 166",
            " C. 150", " D. 151", 3
        )

        maths_Questions_List.add(q3)

        // 4
        val q4 = Question(
            4, "Question 4. What is 1004 divided by 2?",
            R.drawable.ic_math_quiz ,
            " A. 52", " B. 502",
            " C. 520", " D. 5002", 2
        )

        maths_Questions_List.add(q4)

        // 5
        val q5 = Question(
            5, "Question 5. A clock strikes once at 1 o’clock," +
                    " twice at 2 o’clock, thrice at 3 o’clock and so on. " +
                    "How many times will it strike in 24 hours?",
            R.drawable.ic_math_quiz ,
            " A. 78", " B. 136",
            " C. 156", " D. 196", 3
        )

        maths_Questions_List.add(q5)

        // 6
        val q6 = Question(
            6, "Question 6. 125 gallons of a mixture contains 20% water." +
                    " What amount of additional water should be added such that water content be raised to 25%?",
            R.drawable.ic_math_quiz ,
            " A. 15/2 gallons", " B. 17/2 gallons",
            " C. 19/2 gallons", " D. 81/3 gallons", 4
        )

        maths_Questions_List.add(q6)

        // 7
        val q7 = Question(
            7, "Question 7. 106 × 106 – 94 × 94 = ??",
            R.drawable.ic_math_quiz ,
            " A. 2004", " B. 2400",
            " C. 1904", " D. 1906", 2
        )

        maths_Questions_List.add(q7)

        // 8
        val q8 = Question(
            8, "Question 8. Which of the following numbers gives 240 when added to its own square?",
            R.drawable.ic_math_quiz ,
            " A. 15", " B. 16",
            " C. 18", " D. 20", 1
        )

        maths_Questions_List.add(q8)

        // 9
        val q9 = Question(
            9, "Question 9. Evaluation of 83 × 82 × 8-5 is ?",
            R.drawable.ic_math_quiz ,
            " A. 1", " B. 0",
            " C. 8", " D. None of these", 1
        )

        maths_Questions_List.add(q9)

        // 10
        val q10 = Question(
            10, "Question 10. The simplest form of 1.5 : 2.5 is ?",
            R.drawable.ic_math_quiz ,
            " A. 6 : 10", " B. 15 : 25",
            " C. 0.75 : 1.25", " D. 3 : 5", 4
        )

        maths_Questions_List.add(q10)


        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.pk_flag  ,
            "Ireland", "Iran",
            "Hungary", "Pakistan", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )
        questionsList.add(que10)

        if  (quiz_type==true) {
            return maths_Questions_List
        }
        else{
            return questionsList
        }
    }
}