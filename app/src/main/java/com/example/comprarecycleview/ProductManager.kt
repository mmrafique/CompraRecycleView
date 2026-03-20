package com.example.comprarecycleview

class ProductManager {
    private val products = mutableListOf<Product>()
    
    fun addProduct(product: Product) {
        products.add(product)
    }
    
    fun getProducts(): List<Product> {
        return products.toList()
    }
    
    fun getTotalPrice(): Double {
        return products.sumOf { product ->
            (product.price.replace("$", "").toDoubleOrNull() ?: 0.0) * product.quantity
        }
    }
    
    fun getTotalItems(): Int {
        return products.sumOf { it.quantity }
    }
    
    fun getCartItems(): List<Product> {
        return products.filter { it.quantity > 0 }
    }
}
