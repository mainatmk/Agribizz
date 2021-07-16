package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.data.UserViewModel
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Register.setOnClickListener {
            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    private fun InsertData() {
        val Name = name_register.text.toString()
        val Email = email_register.text.toString()
        val PhoneNumber = phonenumber_register.text.toString()
        val Password = password_register.text.toString()
        val Address = address_register.text.toString()
        val UserRegister = UserRegister(0, Name, Email, Password, Address)

        mUserViewModel.addUser(register)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }

}

