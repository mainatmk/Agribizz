package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.data.UserViewModel
import com.example.agribizz.data.user
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)


        Register.setOnClickListener {
            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun InsertData() {
        val Firstname = FirstName.text.toString()
        val Lastname = LastName.text.toString()
        val Email = Email.text.toString()
        val user = user(0, Firstname, Lastname, Email)
        mUserViewModel.addUser(user)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@ExampleActivity, DisplayActivity::class.java))
    }
}

