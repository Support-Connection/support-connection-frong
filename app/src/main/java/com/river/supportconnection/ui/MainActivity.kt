package com.river.supportconnection.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import com.river.supportconnection.ui.register.Register1Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startbtn.setOnClickListener {
            val intent= Intent(this, Register1Activity::class.java)
            startActivity(intent)
        }
    }
}