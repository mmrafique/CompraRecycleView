package com.example.comprarecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val cartItems: List<Product>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.cartProductName)
        val productPrice: TextView = itemView.findViewById(R.id.cartProductPrice)
        val productImage: ImageView = itemView.findViewById(R.id.cartProductImage)
        val quantityText: TextView = itemView.findViewById(R.id.cartQuantity)
        val totalText: TextView = itemView.findViewById(R.id.cartTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = cartItems[position]
        val priceValue = product.price.replace("$", "").toDoubleOrNull() ?: 0.0
        val total = priceValue * product.quantity
        
        holder.productName.text = product.name
        holder.productPrice.text = product.price
        holder.productImage.setImageResource(product.imageResId)
        holder.quantityText.text = "Cantidad: ${product.quantity}"
        holder.totalText.text = "Total: $${"%.2f".format(total)}"
    }

    override fun getItemCount(): Int = cartItems.size
}
