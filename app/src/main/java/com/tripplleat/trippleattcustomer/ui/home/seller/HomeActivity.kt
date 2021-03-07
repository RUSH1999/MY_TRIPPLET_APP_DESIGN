package com.tripplleat.trippleattcustomer.ui.home.seller

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.tripplleat.trippleattcustomer.R
import com.tripplleat.trippleattcustomer.ui.auth.customer.AuthActivity
import kotlinx.android.synthetic.main.activity_main.*
/*
* This the main activity which feed all fragments inside it
*/
class HomeActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var coordinatorLayout : CoordinatorLayout
    lateinit var navigationView : NavigationView
    lateinit var drawerLayout : DrawerLayout
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        navigationView = findViewById(R.id.navigationView)
        drawerLayout = findViewById(R.id.homeDrawerLayout)
        firebaseAuth = FirebaseAuth.getInstance()

        setupToolBar()

        val actionBarToggle = ActionBarDrawerToggle(
            this@HomeActivity,
            drawerLayout,
            R.string.drawerOpen,
            R.string.drawerClose
        )
        drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()

        navigationView.setupWithNavController(homeActivitynavHostFragment.findNavController())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val id = item.itemId
        if (id == android.R.id.home)
            drawerLayout.openDrawer(GravityCompat.START)

        return super.onOptionsItemSelected(item)
    }



    fun setupToolBar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Trippleatt"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}
