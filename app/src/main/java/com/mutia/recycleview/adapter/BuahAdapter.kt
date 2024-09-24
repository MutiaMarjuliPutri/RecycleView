package com.mutia.recycleview.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mutia.recycleview.DetailBuahActivity
import com.mutia.recycleview.R
import com.mutia.recycleview.model.ModelBuah

class BuahAdapter  (
    val itemList: ArrayList<ModelBuah>,
    private val onItemClick : (ModelBuah) -> Unit) :
    RecyclerView.Adapter<BuahAdapter.ModelViewHolder>() {
    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //deklarasi widget dari item layout
        var ItemImage: ImageView = itemView.findViewById(R.id.gambar) as ImageView
        var ItemText: TextView = itemView.findViewById(R.id.nama) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_image, parent, false)
        return ModelViewHolder(nview)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.ItemImage.setImageResource(currentItem.image)
        holder.ItemText.text=currentItem.deskripsi

        //set listener pada item
        holder.itemView.setOnClickListener(){
            onItemClick(currentItem)
        }
    }

}


