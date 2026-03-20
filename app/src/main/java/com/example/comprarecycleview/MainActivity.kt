    package com.example.comprarecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var productManager: ProductManager
    private lateinit var productAdapter: ProductAdapter
    private lateinit var totalPriceText: TextView
    private lateinit var totalItemsText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        productManager = (application as? MyApplication)?.productManager ?: ProductManager()
        
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        totalPriceText = findViewById(R.id.totalPriceText)
        totalItemsText = findViewById(R.id.totalItemsText)
        val cartButton = findViewById<Button>(R.id.cartButton)
        
        // Inicializar productos
        if (productManager.getProducts().isEmpty()) {
            initializeProducts()
        }
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(productManager.getProducts()) { position ->
            updateTotals()
        }
        recyclerView.adapter = productAdapter
        
        updateTotals()
        
        cartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
    
    override fun onResume() {
        super.onResume()
        updateTotals()
    }
    
    private fun initializeProducts() {
        productManager.addProduct(Product("Laptop", "$1200", R.drawable.laptop))
        productManager.addProduct(Product("Smartphone", "$800", R.drawable.smartphone))
        productManager.addProduct(Product("Headphones", "$100", R.drawable.headphones))
        productManager.addProduct(Product("Smartwatch", "$200", R.drawable.smartwatch))
        productManager.addProduct(Product("Mouse", "$60", R.drawable.mouse))
        productManager.addProduct(Product("Keyboard", "$80", R.drawable.keyboard))
        productManager.addProduct(Product("Monitor", "$300", R.drawable.monitor))
        productManager.addProduct(Product("Webcam", "$50", R.drawable.webcam))
        productManager.addProduct(Product("Sound System", "$220", R.drawable.sound_system))
        productManager.addProduct(Product("Laptop Stand", "$40", R.drawable.laptop_stand))
    }
    
    private fun updateTotals() {
        totalPriceText.text = "Precio Total: $${"%.2f".format(productManager.getTotalPrice())}"
        totalItemsText.text = "Items: ${productManager.getTotalItems()}"
    }
}