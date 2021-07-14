package com.example.agribizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agribizz.data.UserViewModel
import kotlinx.android.synthetic.main.activity_list_users.*


class ListUsersActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        //place the recycler view here
        val adapter = UserAdapter()
        val recyclerView =userRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //users viewmodel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer {  user ->
            adapter.setData(user)
        })


    }
}


