package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun supplier_dashboard(view: View) {

        startActivity(Intent(this@DashboardActivity, SupplierDashboardActivity::class.java))


    }
    fun buyer_dashboard(view: View) {

        startActivity(Intent(this@DashboardActivity, BuyerDashboardActivity::class.java))

    }
}