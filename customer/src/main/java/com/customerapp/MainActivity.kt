package com.customerapp

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_customer)

        startActivity(
            Intent(
                this,
                com.mylibrary.MainActivity::class.java
            ).putExtra("packageId", 1)
        )

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

        finish()
    }
}