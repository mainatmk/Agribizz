 package com.example.agribizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared.*

 class Shared : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_shared)

            //instantiate the preference class
            val preferences: SharedPreference = SharedPreference()

            //declared shared preference
            val preference = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)

            val username = preference.getString(preferences.username, "")
            Toast.makeText(this, "Welcome" + username, Toast.LENGTH_SHORT).show()

        val lastname = preference.getString(preferences.lastname, "")
        val email = preference.getString(preferences.email, "")
        val password = preference.getString(preferences.password, "")


        user_shared.setText("Your First Name is  " + username)
        LastName_shared.setText("Your Last Name is  " + lastname)
        Shared_email.setText("Your E-mail is  " + email )
        Shared_Password.setText("Your Password is  " + password )





        }
}