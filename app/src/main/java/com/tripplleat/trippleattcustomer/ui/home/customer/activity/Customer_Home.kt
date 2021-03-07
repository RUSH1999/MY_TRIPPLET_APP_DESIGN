package com.tripplleat.trippleattcustomer.ui.home.customer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.navigation.findNavController
import com.tripplleat.trippleattcustomer.R
import com.tripplleat.trippleattcustomer.ui.home.customer.fragments.CartFragment

/*
* This is the main activity for the customer part of the application
* */

class Customer_Home : AppCompatActivity() {
    lateinit var imgCart : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer__home)

        imgCart = findViewById(R.id.imgCart)

        imgCart.setOnClickListener {
            findNavController(R.id.customerActivitynavHostFragment).navigate(R.id.cartFragment)
        }
    }
}
