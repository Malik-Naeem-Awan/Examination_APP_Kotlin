package com.example.quizapp_v2


import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class DrawingBoardActivity : AppCompatActivity() {

    private var paintView: PaintView? = null
    private var mUserName: String? = null
    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing_board)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mCurrentPosition = Constants.current_Position
        mSelectedOptionPosition= Constants.SelectedOptionP
        mCorrectAnswers= Constants.CorrectAnswers

        paintView = findViewById(R.id.paintView)
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView!!.init(metrics)
    }

    override fun onRestart() {
        val intent =
            Intent(this@DrawingBoardActivity , ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, 10)
        startActivity(intent)
        finish()
        super.onRestart()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.normal -> {
                paintView!!.normal()
                return true
            }
            R.id.blur -> {
                paintView!!.blur()
                return true
            }
            R.id.clear -> {
                paintView!!.clear()
                return true
            }
            R.id.main -> {
                Constants.check=true
                val intent = Intent(this@DrawingBoardActivity, MainActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START

                // END
                startActivity(intent)
                finish()
                return true
            }
            R.id.quiz -> {
                val intent = Intent(this@DrawingBoardActivity, QuizQuestionsActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START
                Constants.check=false
                Constants.current_Position= mCurrentPosition
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
}