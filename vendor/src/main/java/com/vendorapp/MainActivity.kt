package com.vendorapp

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        startActivity(
            Intent(
                this,
                com.mylibrary.MainActivity::class.java
            ).putExtra("packageId", 2)
        )

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        finish()
    }
}