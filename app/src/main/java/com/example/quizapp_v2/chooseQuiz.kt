package com.example.quizapp_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_choose_quiz.*
import kotlinx.android.synthetic.main.content_main.*

class chooseQuiz : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mUserName: String? = null
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_quiz)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_Flag_Quiz.setOnClickListener{

            Constants.initialCountDown = 600000
            Constants.current_Position = 1
            Constants.SelectedOptionP = 0
            Constants.CorrectAnswers = 0
            Constants.initialCountDown = 600000
            Constants.check =false
            Constants.quiz_type= false
            if(Constants.quiz_type==false){
            val intent = Intent(this@chooseQuiz, QuizQuestionsActivity::class.java)
            // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
            // START ))
            intent.putExtra(Constants.USER_NAME, mUserName)
            // END
            startActivity(intent)
            finish()
            }
        }
        btn_Math_Quiz.setOnClickListener{

            Constants.initialCountDown = 600000
            Constants.current_Position = 1
            Constants.SelectedOptionP = 0
            Constants.CorrectAnswers = 0
            Constants.initialCountDown = 600000
            Constants.check =false
            Constants.quiz_type=true

            if(Constants.quiz_type==true){
                val intent = Intent(this@chooseQuiz, QuizQuestionsActivity::class.java)
                // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                // START ))
                intent.putExtra(Constants.USER_NAME, mUserName)
                // END
                startActivity(intent)
                finish()
                }
            }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_messages -> {
                Toast.makeText(this, "Messages clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_friends -> {
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



    }

