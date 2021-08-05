package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_supplier.*

class SupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier)

        val products = resources.getStringArray(R.array.products)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, products)
        supplier_product_name.setAdapter(arrayAdapter)


        val counties = resources.getStringArray(R.array.counties)

        val SupplierAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
        supplier_target.setAdapter(arrayAdapter)


    }

    fun supplierfinish(view: View) {
        startActivity(Intent(this@SupplierActivity, SupplierMapsActivity::class.java))
    }

}