package com.tripplleat.trippleattcustomer

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.waiting_delivery_partner.*

class progressbar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.waiting_delivery_partner)

        simpleProgressBar.max = 100
        val currentProgress = 60

        ObjectAnimator.ofInt(simpleProgressBar,"progress", currentProgress)
            .setDuration(2000)
            .start()

    }

}