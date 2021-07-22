package com.example.agribizz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agribizz.data.user
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item.view.firstname_txt

public class RegisterAdapter: RecyclerView.Adapter<RegisterAdapter.MyViewHolder>()  {

    private var registerlist = emptyList<UserRegister>()


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

    fun setData(register: List<UserRegister>){
        this.registerlist = register
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentItem = registerlist[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
         holder.itemView.firstname_txt.text = currentItem.Name.toString()
         holder.itemView.last_name_txt.text = currentItem.Address
        holder.itemView.email_txt.text = currentItem.Email.toString()
        holder.itemView.Phonenumber_txt.text = currentItem.Address
        holder.itemView.Occupation_txt.text = currentItem.Occupation
    }

}