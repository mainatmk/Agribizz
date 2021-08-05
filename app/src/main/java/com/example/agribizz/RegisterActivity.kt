package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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

        Register.setOnClickListener{
           InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    private fun InsertData()  {
        val FirstName = name_register.text.toString()
        val LastName = lastname.text.toString()
        val Email = email_register.text.toString()
        val PhoneNumber = phonenumber_register.text.toString()
        val Password = password.text.toString()
        val Address = address_register.text.toString()
        val Occupation = occupation.text.toString()
        val UserRegister = UserRegister(0, FirstName,LastName, Email, PhoneNumber, Password, Address, Occupation )

        mUserViewModel.addUser(UserRegister)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }

    fun login(view: View) {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))

    }

}

