package com.example.quizapp_v2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp_v2.Constants.CorrectAnswers
import com.example.quizapp_v2.Constants.SelectedOptionP
import com.example.quizapp_v2.Constants.check
import com.example.quizapp_v2.Constants.current_Position
import com.example.quizapp_v2.Constants.initialCountDown
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var SavedOptionPosition: Int = 0
    private var SavedCorrectAnswer: Int = 0
    private var SavedCurrentPosition: Int = 0
    internal var timerStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal val countDownInterval: Long = 1000

    // TODO (STEP 3: Create a variable for getting the name from intent.)
    // START
    private var mUserName: String? = null
    private var savedUserName: String? = null
    private var current_p: String = ""
    // END

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_questions)

        // TODO (STEP 4: Get the NAME from intent and assign it the variable.)
        // START


        val initialTimeLeft = initialCountDown / 1000
        val time: String = "Time Left: " + initialTimeLeft.toString()
        timeLeftTextView.text = time

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onFinish() {
                initialCountDown = 600000
                endQuiz()
            }

            override fun onTick(millisUntilFinished: Long) {
                if (check) {
                    initialCountDown = 600000
                } else {
                    initialCountDown = millisUntilFinished
                }
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60

                val timeLeftFormatted: String = "Time Left: " + "%02d:%02d".format(minutes, seconds)
                timeLeftTextView.text = timeLeftFormatted
            }
        }

        mCurrentPosition = 1
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mCurrentPosition = Constants.current_Position
        mSelectedOptionPosition = Constants.SelectedOptionP
        mCorrectAnswers = Constants.CorrectAnswers

        // END
        mQuestionsList = Constants.getQuestions()
        countDownTimer.start()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onRestart() {
        val intent =
            Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
        startActivity(intent)
        finish()
        super.onRestart()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.start, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun endQuiz() {
        initialCountDown = 600000
        val intent =
            Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
        startActivity(intent)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.rw -> {
                val intent = Intent(this@QuizQuestionsActivity, DrawingBoardActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)

                // START
                Constants.current_Position = mCurrentPosition
                Constants.SelectedOptionP = mSelectedOptionPosition
                Constants.CorrectAnswers = mCorrectAnswers
                intent.putExtra(Constants.USER_NAME, mUserName)
                // END
                startActivity(intent)
                finish()
                return true
            }

            R.id.re -> {
                initialCountDown = 600000
                current_Position = 1
                SelectedOptionP = 0
                CorrectAnswers = 0
                initialCountDown = 600000
                check = true
                val intent = Intent(this@QuizQuestionsActivity, chooseQuiz::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START
                // END
                startActivity(intent)
                finish()
                return true
            }

            R.id.main -> {
                initialCountDown = 600000
                current_Position = 1
                SelectedOptionP = 0
                CorrectAnswers = 0
                initialCountDown = 600000
                check = true
                val intent = Intent(this@QuizQuestionsActivity, MainActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // END
                startActivity(intent)
                finish()
                return true
            }

            R.id.calculator -> {

                val intent = Intent(this@QuizQuestionsActivity, Calculator::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                Constants.current_Position = mCurrentPosition
                Constants.SelectedOptionP = mSelectedOptionPosition
                Constants.CorrectAnswers = mCorrectAnswers
                intent.putExtra(Constants.USER_NAME, mUserName)
                // END
                startActivity(intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
                btn_submit.isEnabled= true
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
                btn_submit.isEnabled= true
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
                btn_submit.isEnabled= true
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
                btn_submit.isEnabled= true
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {

                            // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

        val question =
            mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }
        btn_submit.isEnabled= false
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.Image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        enableButtons()
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)


        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
        disbleButtons()
    }

    private fun disbleButtons() {
        tv_option_one.isEnabled = false
        tv_option_two.isEnabled = false
        tv_option_three.isEnabled = false
        tv_option_four.isEnabled = false
    }

    private fun enableButtons() {
        tv_option_one.isEnabled = true
        tv_option_two.isEnabled = true
        tv_option_three.isEnabled = true
        tv_option_four.isEnabled = true
    }

}