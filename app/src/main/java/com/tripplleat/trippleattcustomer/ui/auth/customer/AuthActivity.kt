package com.tripplleat.trippleattcustomer.ui.auth.customer


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth


import com.tripplleat.trippleattcustomer.R
import com.tripplleat.trippleattcustomer.ui.home.customer.activity.Customer_Home
import com.tripplleat.trippleattcustomer.ui.home.seller.HomeActivity


class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = FirebaseAuth.getInstance().currentUser
        if(user != null){
            startActivity(Intent(this, Customer_Home::class.java))
        }
    }
}
