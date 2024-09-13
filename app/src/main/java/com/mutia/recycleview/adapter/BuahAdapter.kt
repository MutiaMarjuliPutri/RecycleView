package com.mutia.recycleview.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mutia.recycleview.R
import com.mutia.recycleview.model.ModelBuah

class BuahAdapter(val itemList: ArrayList<ModelBuah>) :
    RecyclerView.Adapter<BuahAdapter.ModelViewHolder>(){
    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var ItemImage : ImageView
        lateinit var  ItemText : TextView

        init {
            ItemImage = itemView.findViewById(R.id.gambar) as ImageView
            ItemText = itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_custom_image, parent, false
            )
        return ModelViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.ItemImage.setImageResource(itemList[position].image)
        holder.ItemText.setText(itemList[position].deskripsi)
    }
}