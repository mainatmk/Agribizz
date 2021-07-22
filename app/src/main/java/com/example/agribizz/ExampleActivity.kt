package com.example.agribizz

import android.content.Intent
import android.content.SharedPreferences
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

        Register.setOnClickListener {
            InsertData()


            //get user input
            val name : String= FirstName.text.toString()
            val lastname : String= LastName.text.toString()
            val email : String= Email.text.toString()
            val password : String= Password.text.toString()



            //instantiate the share preference class
        val share : SharedPreference = SharedPreference()


            //SharedPreferences- is an object that temporarily stores data in an application
        var mysharedpref = PreferenceManager.getDefaultSharedPreferences(this )


            //an editor- is an object that is used to edit data inside the shared preference
            var editor : SharedPreferences.Editor =mysharedpref.edit()


            //put a string to replace the default value of the username
            editor.putString(share.username, name)
            editor.putString(share.lastname, lastname)
            editor.putString(share.email, email)
            editor.putString(share.password, password)



            //save what we have edited
        editor.apply()



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

        startActivity(Intent(this@ExampleActivity, Shared::class.java))
    }




 }



