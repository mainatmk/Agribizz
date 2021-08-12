package com.example.agribizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agribizz.SupplierProduct.SViewModel
import com.example.agribizz.buyer.BuyerViewModel
import kotlinx.android.synthetic.main.activity_buyer_list.*
import kotlinx.android.synthetic.main.activity_supplier_list.*

class BuyerListActivity : AppCompatActivity() {

    private  lateinit var mUserViewModel: BuyerViewModel
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer_list)

        //place the recycler view here11
        val adapter = BuyerAdapter()
        val recyclerView =Buyer_Recycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        //supplier viewmodel
        mUserViewModel = ViewModelProvider(this).get(BuyerViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer {  Buyer ->
            adapter.setData(Buyer, this)
        })


    }
}