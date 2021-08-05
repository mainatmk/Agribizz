package com.example.agribizz


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_register_list.*

class RegisterList : AppCompatActivity() {
    private lateinit var mUserViewModel: RegisterViewModel
    private lateinit var lifecycleOwner: LifecycleOwner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_list)

        //place the recycler view here11
        val adapter = RegisterAdapter()
        val recyclerView =RegisterRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //users viewmodel
        mUserViewModel =ViewModelProvider(this).get(RegisterViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer {  UserRegister ->
            adapter.setData(UserRegister, this)
        })

    }
}