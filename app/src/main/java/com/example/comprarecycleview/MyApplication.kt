package com.example.comprarecycleview

import android.app.Application

class MyApplication : Application() {
    val productManager = ProductManager()
    
    override fun onCreate() {
        super.onCreate()
    }
}
