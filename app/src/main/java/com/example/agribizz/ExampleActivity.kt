package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
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

        //get user input
        val name : String= FirstName.text.toString()

        var mysharedpref = PreferenceManager.getDefaultSharedPreferences(this )
        var editor = mysharedpref.edit()



        Register.setOnClickListener {
            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun InsertData() {
        val Firstname = FirstName.text.toString()
        val Lastname = LastName.text.toString()
        val Email = Email.text.toString()
        val Password = Password.text.toString()
        val user = user(0, Firstname, Lastname, Email, Password)
        mUserViewModel.addUser(user)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@ExampleActivity, LoginActivity::class.java))
    }




 }



