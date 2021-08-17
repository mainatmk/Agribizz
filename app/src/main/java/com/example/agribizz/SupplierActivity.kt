package com.example.agribizz

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.SupplierProduct.SGoods
import com.example.agribizz.SupplierProduct.SViewModel
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_buyer.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_supplier.*

class SupplierActivity : AppCompatActivity() {

    private lateinit var supplier_product_nam: EditText
    private lateinit var seller_description: EditText
    private lateinit var price_seller: EditText
    private lateinit var supplier_targt: EditText
    private lateinit var phonenumber_seller: EditText
    private lateinit var sell_maps: Button
    private lateinit var mUserViewModel: SViewModel
    private var our_request_code : Int= 123



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier)


        supplier_product_nam = findViewById(R.id.supplier_product_name)
        seller_description = findViewById(R.id.seller_description)
        price_seller = findViewById(R.id.price_seller)
        supplier_targt = findViewById(R.id.supplier_target)
        phonenumber_seller = findViewById(R.id.phonenumber_seller)
        sell_maps = findViewById(R.id.sell_maps)



            val products = resources.getStringArray(R.array.products)
            val myAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, products)
            supplier_product_name.setAdapter(myAdapter)


            val counties = resources.getStringArray(R.array.counties)
            val arrayAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, counties)
            supplier_target.setAdapter(arrayAdapter)


            sell_maps.setOnClickListener {

                val name = supplier_product_nam.text.toString().trim()
                val description = seller_description.text.toString().trim()
                val price = price_seller.text.toString().trim()



                if  (name.isEmpty()) {
                    supplier_product_name.error = "ProductName required"
                    return@setOnClickListener
                } else if (description.isEmpty()) {
                    seller_description.error = "Description required"
                } else if (price.isEmpty()) {
                    price_seller.error = "Price required"
                } else {
                    startActivity(Intent(this@SupplierActivity, SupplierMapsActivity::class.java))
                }


                InsertData()
            }

            mUserViewModel = ViewModelProvider(this).get(SViewModel::class.java)
        }
        private fun InsertData() {
            val ProductName = supplier_product_name.text.toString()
            val ProductDescription = seller_description.text.toString()
            val Price = price_seller.text.toString()
            val AreasTargetted = supplier_target.text.toString()
            val PhoneNumber = phonenumber_seller.text.toString()
            val sellerproduct = SGoods(0, ProductName, ProductDescription, Price, AreasTargetted,PhoneNumber
            )

            mUserViewModel.addUser(sellerproduct)
            Toast.makeText(this, "Product Added...", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@SupplierActivity, SupplierMapsActivity::class.java))
        }

    fun TakePhoto(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager) != null){
            startActivityForResult(intent, our_request_code)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == our_request_code && resultCode == RESULT_OK){
            val imageView : ImageView = findViewById(R.id.image_product)
            val bitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
        }
    }


}

