package com.example.comprarecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val onQuantityChanged: (Int) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val quantityText: TextView = itemView.findViewById(R.id.quantityText)
        val addButton: TextView = itemView.findViewById(R.id.addButton)
        val removeButton: TextView = itemView.findViewById(R.id.removeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        
        holder.productName.text = product.name
        holder.productPrice.text = product.price
        holder.productImage.setImageResource(product.imageResId)
        holder.quantityText.text = product.quantity.toString()
        
        holder.addButton.setOnClickListener {
            product.quantity++
            holder.quantityText.text = product.quantity.toString()
            onQuantityChanged(position)
        }
        
        holder.removeButton.setOnClickListener {
            if (product.quantity > 0) {
                product.quantity--
                holder.quantityText.text = product.quantity.toString()
                onQuantityChanged(position)
            }
        }
    }

    override fun getItemCount(): Int = productList.size
}
