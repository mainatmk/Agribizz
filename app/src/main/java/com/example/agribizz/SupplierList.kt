package com.example.agribizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agribizz.SupplierProduct.SGoods
import com.example.agribizz.SupplierProduct.SViewModel
import com.example.agribizz.buyer.BuyerViewModel
import com.example.agribizz.register.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register_list.*
import kotlinx.android.synthetic.main.activity_supplier_list.*

class SupplierList : AppCompatActivity() {

    private  lateinit var mUserViewModel: SViewModel
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_list)

        //place the recycler view here11
        val adapter = SupplierAdapter()
        val recyclerView =SupplierRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        //supplier viewmodel
        mUserViewModel = ViewModelProvider(this).get(SViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer {  SGoods ->
            adapter.setData(SGoods, this)
        })
    }
}