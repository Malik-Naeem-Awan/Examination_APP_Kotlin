package com.example.quizapp_v2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator : AppCompatActivity() {


    private var mUserName: String? = null
    private var mCurrentPosition: Int = 1 // Default and the first question position

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mCurrentPosition = Constants.current_Position
        mSelectedOptionPosition= Constants.SelectedOptionP
        mCorrectAnswers= Constants.CorrectAnswers

        //Numbers
        tvOne.setOnClickListener {
            appendOnExpresstion("1", true)
        }
        tvTwo.setOnClickListener {
            appendOnExpresstion("2", true)
        }
        tvThree.setOnClickListener {
            appendOnExpresstion("3", true)
        }
        tvFour.setOnClickListener {
            appendOnExpresstion("4", true)
        }
        tvFive.setOnClickListener {
            appendOnExpresstion("5", true)
        }
        tvSix.setOnClickListener {
            appendOnExpresstion("6", true)
        }
        tvSeven.setOnClickListener {
            appendOnExpresstion("7", true)
        }
        tvEight.setOnClickListener {
            appendOnExpresstion("8", true)
        }
        tvNine.setOnClickListener {
            appendOnExpresstion("9", true)
        }
        tvZero.setOnClickListener {
            appendOnExpresstion("0", true)
        }
        tvDot.setOnClickListener {
            appendOnExpresstion(".", true)
        }

        //Operators
        tvPlus.setOnClickListener {
            appendOnExpresstion("+", false)
        }
        tvMinus.setOnClickListener {
            appendOnExpresstion("-", false)
        }
        tvMul.setOnClickListener {
            appendOnExpresstion("*", false)
        }
        tvDivide.setOnClickListener {
            appendOnExpresstion("/", false)
        }
        tvOpen.setOnClickListener {
            appendOnExpresstion("(", false)
        }
        tvClose.setOnClickListener {
            appendOnExpresstion(")", false)
        }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e: Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    override fun onRestart() {
        val intent =
            Intent(this@Calculator , ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, 10)
        startActivity(intent)
        finish()
        super.onRestart()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.calc_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.rw -> {
                val intent = Intent(this@Calculator, DrawingBoardActivity::class.java)
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
                Constants.initialCountDown = 600000
                Constants.current_Position = 1
                Constants.SelectedOptionP = 0
                Constants.CorrectAnswers = 0
                Constants.initialCountDown = 600000
                Constants.check =true
                val intent = Intent(this@Calculator, chooseQuiz::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START
                // END
                startActivity(intent)
                finish()
                return true
            }

            R.id.main -> {
                Constants.initialCountDown = 600000
                Constants.current_Position = 1
                Constants.SelectedOptionP = 0
                Constants.CorrectAnswers = 0
                Constants.initialCountDown = 600000
                Constants.check =true
                val intent = Intent(this@Calculator, MainActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // END
                startActivity(intent)
                finish()
                return true
            }

            R.id.quiz -> {
                val intent = Intent(this@Calculator, QuizQuestionsActivity::class.java)
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



    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}
