package com.example.comprarecycleview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        
        val cartRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)
        val totalPriceText = findViewById<TextView>(R.id.totalPriceText)
        val backButton = findViewById<Button>(R.id.backButton)
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        
        val productManager = (application as? MyApplication)?.productManager ?: ProductManager()
        val cartItems = productManager.getCartItems()
        
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = CartAdapter(cartItems)
        
        val totalPrice = productManager.getTotalPrice()
        totalPriceText.text = "Precio Total: $${"%.2f".format(totalPrice)}"
        
        backButton.setOnClickListener {
            finish()
        }
        
        confirmButton.setOnClickListener {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show()
            } else {
                showPurchaseConfirmation(cartItems, totalPrice)
            }
        }
    }
    
    private fun showPurchaseConfirmation(items: List<Product>, totalPrice: Double) {
        val purchaseMessage = buildPurchaseMessage(items, totalPrice)
        
        // Log a consola
        Log.d("COMPRA_CONFIRMADA", purchaseMessage)
        
        // Dialog
        AlertDialog.Builder(this)
            .setTitle("✓ ¡Compra Confirmada!")
            .setMessage(purchaseMessage)
            .setPositiveButton("Aceptar") { _, _ ->
                Toast.makeText(
                    this,
                    "Gracias por tu compra de $${String.format("%.2f", totalPrice)}",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
            .setCancelable(false)
            .show()
    }
    
    private fun buildPurchaseMessage(items: List<Product>, totalPrice: Double): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale("es"))
        val currentDate = dateFormat.format(Date())
        
        val sb = StringBuilder()
        sb.append("📦 RESUMEN DE COMPRA\n")
        sb.append("─".repeat(30)).append("\n")
        sb.append("Fecha: $currentDate\n")
        sb.append("─".repeat(30)).append("\n\n")
        
        items.forEach { product ->
            val subtotal = (product.price.replace("$", "").toDoubleOrNull() ?: 0.0) * product.quantity
            sb.append("• ${product.name}\n")
            sb.append("  Cantidad: ${product.quantity}\n")
            sb.append("  Precio unitario: ${product.price}\n")
            sb.append("  Subtotal: $${"%.2f".format(subtotal)}\n\n")
        }
        
        sb.append("─".repeat(30)).append("\n")
        sb.append("TOTAL: $${"%.2f".format(totalPrice)}\n")
        sb.append("─".repeat(30))
        
        return sb.toString()
    }
}
