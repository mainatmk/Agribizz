package com.example.agribizz

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agribizz.SupplierProduct.SDao
import com.example.agribizz.SupplierProduct.SGoods
import com.example.agribizz.buyer.Buyer
import com.example.agribizz.buyer.BuyerDao
import com.example.agribizz.data.database
import kotlinx.android.synthetic.main.buyeritem.view.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.supplieritem.view.*

public class BuyerAdapter: RecyclerView.Adapter<BuyerAdapter.MyViewHolder>() {

    private var buyerlist = emptyList<Buyer>()
    private lateinit var context : Context

    override fun getItemCount(): Int {
        return  buyerlist.size
    }

    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyerAdapter.MyViewHolder {
        return BuyerAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.buyeritem, parent, false)
        )
    }

    fun setData(buyer: List<Buyer>, context: Context){
        this.buyerlist = buyer
        this.context = context
        notifyDataSetChanged()
    }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentItem = buyerlist[position]
        var id: Int = currentItem.id
        holder.itemView.id_buyer.text = currentItem.id.toString()
        holder.itemView.buyer_txt.text = currentItem.ProductName.toString()
         holder.itemView.description_buyer_txt.text = currentItem.ProductDescription.toString()
        holder.itemView.price_buyer.text = currentItem.PriceRange.toString()
        holder.itemView.areas_buyer_txt.text = currentItem.AreasTargetted.toString()
        holder.itemView.phone_buyer_txt.text = currentItem.PhoneNumber.toString()


        //onclick listener for delete button
        holder.itemView.delete_buyer_goods.setOnClickListener{

            //instantiate the database
            val database_register : database = database.getDatabase(context)

            //go to the database and access dao
            val buyerdao : BuyerDao = database_register.buyerDao()

            Thread{
                //prepare your query to execute in the background
                Looper.prepare()
                val selected: Int = buyerdao.delete(id);
                Toast.makeText(context, "DELETED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

                //execute looper
                Looper.loop()
            }.start()
        }
    }


}