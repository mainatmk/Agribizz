package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.buyer.Buyer
import com.example.agribizz.buyer.BuyerViewModel
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_buyer.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_supplier.*

class BuyerActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: BuyerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer)

        val counties = resources.getStringArray(R.array.counties)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
        buyer_target.setAdapter(arrayAdapter)

        Register.setOnClickListener{
            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(BuyerViewModel::class.java)

    }

    private fun InsertData()  {
        val ProductName = buyer_product_name.text.toString()
        val ProductDescription = buyer_description.text.toString()
        val PriceRange = buyer_price_range.text.toString()
        val AreasTargetted = buyer_target.text.toString()
        val PhoneNumber = phonenumber_buyer.text.toString()
        val buyer = Buyer(0, ProductName,ProductDescription, PriceRange, AreasTargetted, PhoneNumber )

        mUserViewModel.addUser(buyer)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@BuyerActivity, SupplierMapsActivity::class.java))
    }

}