package com.example.agribizz

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agribizz.R
import com.example.agribizz.data.UserDao
import com.example.agribizz.data.database
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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
        startActivity(Intent(this@LoginActivity, SupplierActivity::class.java))
    }

    fun buyer(view: View) {
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
        startActivity(Intent(this@LoginActivity, BuyerActivity::class.java))
    }

    }


