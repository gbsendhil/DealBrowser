package com.target.sendhil.deals.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.target.sendhil.R

import com.target.sendhil.deals.model.Data
import kotlinx.android.synthetic.main.list_item.view.*

class ProductListAdapter(val context: Context,val items : List<Data>?) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {

        return items?.size?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvProductTitle.text = items?.get(position)?.title
        holder.tvProductPrice.text = items?.get(position)?.price
        Glide.with(holder.ivProductImage).load(items?.get(position)?.image).into(holder.ivProductImage)
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val ivProductImage = view.ivIcon
    val tvProductTitle = view.tvTitle
    val tvProductPrice = view.tvPrice
}