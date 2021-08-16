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
import com.example.agribizz.data.database
import com.example.agribizz.register.RegisterDao
import com.example.agribizz.register.UserRegister
import kotlinx.android.synthetic.main.activity_supplier.view.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item.view.delete_user
import kotlinx.android.synthetic.main.supplieritem.view.*

public class SupplierAdapter: RecyclerView.Adapter<SupplierAdapter.MyViewHolder>() {

    private var supplierlist = emptyList<SGoods>()
    private lateinit var context : Context



    override fun getItemCount(): Int {
        return  supplierlist.size
    }
    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierAdapter.MyViewHolder {
        return SupplierAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.supplieritem, parent, false)
        )
    }

    fun setData(supplier: List<SGoods>, context: Context){
        this.supplierlist = supplier
        this.context = context
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentItem = supplierlist[position]
        var id: Int = currentItem.id
        holder.itemView.id_supplier.text = currentItem.id.toString()
        holder.itemView.supplier_txt.text = currentItem.ProductName.toString()
        holder.itemView.description_txt.text = currentItem.ProductDescription.toString()
        holder.itemView.price.text = currentItem.Price.toString()
        holder.itemView.areas_txt.text = currentItem.AreasTargetted.toString()
        holder.itemView.phone_txt.text = currentItem.PhoneNumber.toString()


        //onclick listener for delete button
        holder.itemView.delete_supplier_goods.setOnClickListener{

            //instantiate the database
            val database_register : database = database.getDatabase(context)

            //go to the database and access dao
            val supplierdao : SDao = database_register.supplierDao()

            Thread{
                //prepare your query to execute in the background
                Looper.prepare()
                val selected: Int = supplierdao.delete(id);
                Toast.makeText(context, "DELETED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

                //execute looper
                Looper.loop()
            }.start()
        }
    }
}