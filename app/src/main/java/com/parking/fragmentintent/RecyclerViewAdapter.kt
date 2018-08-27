package com.parking.fragmentintent

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class RecyclerViewAdapter (var itemList: ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listener: Listener? = null

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent , false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.text.text = itemList[position]

        holder.constraint.setOnClickListener{
            listener!!.onClick(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text = itemView.findViewById<TextView>(R.id.textView)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val constraint = itemView.findViewById<ConstraintLayout>(R.id.constraint)
    }
}