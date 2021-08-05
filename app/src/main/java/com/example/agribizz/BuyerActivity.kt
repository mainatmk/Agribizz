package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_buyer.*
import kotlinx.android.synthetic.main.activity_supplier.*

class BuyerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer)

        val counties = resources.getStringArray(R.array.counties)

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
        buyer_target.setAdapter(arrayAdapter)


    }

    fun buyerfinish(view: View) {
        startActivity(Intent(this@BuyerActivity, SupplierMapsActivity::class.java))
    }
}