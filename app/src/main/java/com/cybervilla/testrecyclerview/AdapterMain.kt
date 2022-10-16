package com.cybervilla.testrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMain(var listMain:ArrayList<String>,var onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<AdapterMain.myViewHolder>() {
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main,parent,false)
        return myViewHolder(view,onItemClickListener)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = listMain[position]
        holder.txtMain.text = item
    }

    override fun getItemCount(): Int {
     return listMain.size
    }
    class myViewHolder(itemView: View, onItemClickListener: OnItemClickListener)
        :RecyclerView.ViewHolder(itemView){
        val txtMain = itemView.findViewById<TextView>(R.id.txt_main)
        init {
            itemView.setOnClickListener{
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
    }
}