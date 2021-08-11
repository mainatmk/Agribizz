package com.example.agribizz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agribizz.SupplierProduct.SGoods
import com.example.agribizz.buyer.Buyer

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
            LayoutInflater.from(parent.context).inflate(R.layout.supplieritem, parent, false)
        )
    }


}