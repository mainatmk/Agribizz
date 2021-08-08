package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.SupplierProduct.SGoods
import com.example.agribizz.SupplierProduct.SViewModel
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_supplier.*

class SupplierActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: SViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier)

        val products = resources.getStringArray(R.array.products)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, products)
        supplier_product_name.setAdapter(arrayAdapter)


        val counties = resources.getStringArray(R.array.counties)

        val SupplierAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
        supplier_target.setAdapter(arrayAdapter)

        supplier.setOnClickListener{
            InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(SViewModel::class.java)
    }
    private fun InsertData()  {
        val ProductName = supplier_product_name.text.toString()
        val Photo = photo.text.toString()
        val ProductDescription = seller_description.text.toString()
        val Price = price.text.toString()
        val AreasTargetted = supplier_target.text.toString()
        val PhoneNumber = phonenumber_seller.text.toString()
        val sellerproduct = SGoods(0, ProductName,Photo, ProductDescription, Price, AreasTargetted, PhoneNumber)

        mUserViewModel.addUser(sellerproduct)
        Toast.makeText(this, "Products Added", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@SupplierActivity, SupplierMapsActivity::class.java))
    }




}