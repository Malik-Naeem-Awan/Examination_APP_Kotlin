package com.example.quizapp_v2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.view.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // TODO (STEP 6: Hide the status bar and get the details from intent and set it to the UI. And also add a click event to the finish button.)
        // START
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        if(correctAnswers >=4 && correctAnswers <= 6){
            tv_congratulations.text="Passes Successfuly! Keep It UP!"
        }

        if(correctAnswers<4){
            iv_trophy.setImageResource(R.drawable.failed)
            tv_congratulations.text="Failed! Try Again!"
        }

        if(correctAnswers>6){
            iv_trophy.setImageResource(R.drawable.ic_trophy)
            tv_congratulations.text="Congratulations! You have Passed!"
        }

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions."

        Constants.initialCountDown = 600000
        Constants.current_Position = 1
        Constants.SelectedOptionP = 0
        Constants.CorrectAnswers = 0
        Constants.initialCountDown = 600000
        Constants.check =false
        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
        // END
    }
}
