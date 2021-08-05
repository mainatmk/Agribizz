package com.example.agribizz

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agribizz.data.database
import com.example.agribizz.data.user
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item.view.firstname_txt

public class RegisterAdapter: RecyclerView.Adapter<RegisterAdapter.MyViewHolder>()  {

    private var registerlist = emptyList<UserRegister>()
    private lateinit var context : Context



    override fun getItemCount(): Int {
        return  registerlist.size
    }
    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterAdapter.MyViewHolder {
        return RegisterAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    fun setData(register: List<UserRegister>,context: Context){
        this.registerlist = register
        this.context = context
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentItem = registerlist[position]
        var id: Int = currentItem.id
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstname_txt.text = currentItem.FirstName.toString()
        holder.itemView.email_txt.text = currentItem.Email.toString()
        holder.itemView.Occupation_txt.text = currentItem.Occupation


        //onclick listener for delete button
        holder.itemView.delete_user.setOnClickListener{

            //instantiate the database
            val database_register : database= database.getDatabase(context)

            //go to the database and access dao
            val registerdao : RegisterDao = database_register.RegisterDao()

            Thread{
                //prepare your query to execute in the background
                    Looper.prepare()
                val selected: Int = registerdao.delete(id);
                Toast.makeText(context, "DELETED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

                //execute looper
                Looper.loop()
            }.start()
        }
    }


}