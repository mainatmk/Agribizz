package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BuyerDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer_dashboard)
    }

    fun buyer_product(view: View) {

        startActivity(Intent(this@BuyerDashboardActivity, BuyerActivity::class.java))

    }
    fun buyer_basket(view: View) {

        startActivity(Intent(this@BuyerDashboardActivity, BuyerListActivity::class.java))
    }
    fun buyer_logout(view: View) {

        startActivity(Intent(this@BuyerDashboardActivity, LoginActivity::class.java))


    }
}