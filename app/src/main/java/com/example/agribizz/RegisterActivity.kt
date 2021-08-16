package com.example.agribizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.agribizz.data.UserViewModel
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterViewModel
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_buyer.*
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: RegisterViewModel

    private lateinit var name_register : EditText
    private lateinit var lastname_r : EditText
    private lateinit var email_register: EditText
    private lateinit var phonenumber_register : EditText
    private lateinit var password_r : EditText
    private lateinit var buyer_produc_name : EditText
    private lateinit var address_register : EditText
    private lateinit var Register : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_register = findViewById(R.id.name_register)
        lastname_r = findViewById(R.id.lastname_r)
        email_register = findViewById(R.id.email_register)
        phonenumber_register = findViewById(R.id.phonenumber_register)
        password_r = findViewById(R.id.password_r)
        buyer_produc_name = findViewById(R.id.buyer_prduc_name)
        address_register = findViewById(R.id.address_register)
        Register = findViewById(R.id.Register)



        val occupation = resources.getStringArray(R.array.occupation)
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, occupation)
        buyer_prduc_name.setAdapter(myAdapter)

        Register.setOnClickListener{

            val firstname = name_register.text.toString().trim()
            val lastname = lastname_r.text.toString().trim()
            val email= email_register.text.toString().trim()
            val phone = phonenumber_register.text.toString().trim()
            val password = password_r.text.toString().trim()
            val prd = buyer_prduc_name.text.toString().trim()
            val address = address_register.text.toString().trim()

            if (firstname.isEmpty()) {
                name_register.error = "FirstName required"
                return@setOnClickListener
            }
            else if (lastname.isEmpty()){
                lastname_r.error = "LastName required"
            }
            else if (email.isEmpty()){
                email_register.error = "E-mail required"
            }
            else if (phone.isEmpty()){
                phonenumber_register.error = "Phone required"
            }
            else if (password.isEmpty()){
                password_r.error = "Password required"
            }
            else if (prd.isEmpty()){
                buyer_prduc_name.error = "Occupation required"
            }
            else if (address.isEmpty()){
                address_register.error = "Address required"
            }
            else{
                startActivity(Intent(this@RegisterActivity, DashboardActivity::class.java))
            }
           InsertData()
        }


        mUserViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    private fun InsertData()  {
        val FirstName = name_register.text.toString()
        val LastName = lastname_r.text.toString()
        val Email = email_register.text.toString()
        val PhoneNumber = phonenumber_register.text.toString()
        val Password = password_r.text.toString()
        val Address = address_register.text.toString()
        val Occupation = buyer_prduc_name.text.toString()
        val UserRegister = UserRegister(0, FirstName,LastName, Email, PhoneNumber, Password, Address, Occupation )

        mUserViewModel.addUser(UserRegister)
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }

    fun login(view: View) {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))

    }

}

