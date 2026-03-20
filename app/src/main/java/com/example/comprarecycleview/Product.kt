package com.example.comprarecycleview

data class Product(
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int = 0
)
