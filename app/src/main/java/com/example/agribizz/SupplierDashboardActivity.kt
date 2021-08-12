package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SupplierDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier_dashboard)
    }

    fun supplier_list(view: View) {
        startActivity(Intent(this@SupplierDashboardActivity, SupplierList::class.java))

    }
    fun seller_logout(view: View) {

        startActivity(Intent(this@SupplierDashboardActivity, LoginActivity::class.java))
    }

    fun sell_supplier(view: View) {

        startActivity(Intent(this@SupplierDashboardActivity, SupplierActivity::class.java))
    }
}