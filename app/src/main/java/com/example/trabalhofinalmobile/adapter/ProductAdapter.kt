package com.example.trabalhofinalmobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhofinalmobile.R
import com.example.trabalhofinalmobile.data.Datasource

class ProductAdapter(private val context: Context, private val dataset: Datasource)
    : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val productTitle: TextView = view.findViewById(R.id.product_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = dataset.products[position]
        holder.productTitle.text = product.title
    }

    override fun getItemCount(): Int {
        return dataset.products.size
    }
}
