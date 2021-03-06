package com.example.agribizz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agribizz.data.user
import kotlinx.android.synthetic.main.item.view.*

public class UserAdapter: RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    private var userList = emptyList<user>()


    override fun getItemCount(): Int {
        return  userList.size
    }

    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstname_txt.text = currentItem.FirstName
        holder.itemView.email_txt.text = currentItem.Email.toString()
    }
    fun setData(user: List<user>){
        this.userList = user
        notifyDataSetChanged()
    }
}
