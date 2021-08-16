package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
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
    private lateinit var product_nam: EditText
    private lateinit var buyer_description: EditText
    private lateinit var buyer_price_range: EditText
    private lateinit var buy_maps: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer)

        product_nam = findViewById(R.id.buyer_product_name)
        buyer_description = findViewById(R.id.buyer_description)
        buyer_price_range = findViewById(R.id.buyer_price_range)
        buy_maps = findViewById(R.id.buy_maps)



        val products = resources.getStringArray(R.array.products)
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, products)
        buyer_product_name.setAdapter(myAdapter)




        val counties = resources.getStringArray(R.array.counties)
      val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
        buyer_target.setAdapter(arrayAdapter)




        buy_maps.setOnClickListener {

            val name = buyer_product_name.text.toString().trim()
            val description = buyer_description.text.toString().trim()
            val price = buyer_price_range.text.toString().trim()


            if (name.isEmpty()) {
                buyer_product_name.error = "ProductName required"
                return@setOnClickListener
            } else if (description.isEmpty()) {
                buyer_description.error = "Description required"
            } else if (price.isEmpty()) {
                buyer_price_range.error = "Price required"
            } else {
                startActivity(Intent(this@BuyerActivity, SupplierMapsActivity::class.java))
            }


            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(BuyerViewModel::class.java)

    }

    private fun InsertData() {
        val ProductName = buyer_product_name.text.toString()
        val ProductDescription = buyer_description.text.toString()
        val PriceRange = buyer_price_range.text.toString()
        val AreasTargetted = buyer_target.text.toString()
        val PhoneNumber = phonenumber_buyer.text.toString()
        val buyer =
            Buyer(0, ProductName, ProductDescription, PriceRange, AreasTargetted, PhoneNumber)

        mUserViewModel.addUser(buyer)
        Toast.makeText(this, "Searching for a match.....", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@BuyerActivity, SupplierMapsActivity::class.java))
    }
}


