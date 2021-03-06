package com.example.agribizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.data.UserViewModel
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        mUserViewModel.observeuser().observe(this, Observer {
            fname.text = it.FirstName
            lname.text = it.LastName
            email.text = it.Email
        })

    }

}