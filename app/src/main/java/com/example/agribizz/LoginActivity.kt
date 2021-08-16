package com.example.agribizz

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.agribizz.R
import com.example.agribizz.data.UserDao
import com.example.agribizz.data.database
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var email_login : EditText
    private lateinit var login_password : EditText
    private lateinit var login_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        email_login = findViewById(R.id.email_login)
        login_password = findViewById(R.id.login_password)
        login_btn = findViewById(R.id.login_btn)

        login_btn.setOnClickListener{

            val email = email_login.text.toString().trim()
            val password = login_password.text.toString().trim()

            if (email.isEmpty()) {
                email_login.error = "E-mail required"
                return@setOnClickListener
            }
            else if (password.isEmpty()){
                login_password.error = "Password required"
            }
            else{
                startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
            }
        }

    }


    fun supplier(view: View) {
        val email_login = email_login.text.toString()
        val password_login = login_password.text.toString()
        val database: database = database.getDatabase(this)
        val registerdao: RegisterDao = database.RegisterDao()
        val thread: Thread
        Thread {
            Looper.prepare();
            val user: UserRegister = registerdao.loginuser(email_login, password_login)
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            Looper.loop();
        }.start()
        startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
    }

    fun register_login(view: View) {

        startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

    }

}


