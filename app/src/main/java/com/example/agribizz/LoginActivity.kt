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

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }



    fun supplier(view: View) {
        startActivity(Intent(this@LoginActivity, SupplierProductActivity::class.java))
    }
}

//        login_btn.setOnClickListener {
//
//            val firstName_login = first_name_login.text.toString()
//            val lastName_login =login_age.text.toString()
//            val userDatabase: UserDatabase = UserDatabase.getDatabase(this)
//            val userdao: UserDao = userDatabase.userDao()
//
//            val thread: Thread
//            Thread{
//                Looper.prepare();
//                val user: User = userdao.login(firstName_login,lastName_login)
//                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                Looper.loop();
//            }.start()
//
//
//
//
//      }