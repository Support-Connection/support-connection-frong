package com.river.supportconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_jasaninput_activity.*
import org.jetbrains.anko.startActivity

class Jasaninput_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jasaninput_activity)

        var yunsodeuk="0"
        var jasan="0"

        jasan_btn1.setOnClickListener {
            jasan = jasan_edit1.text.toString()
            yunsodeuk = jasan_edit2.text.toString()
            startActivity<RealMainActivity>(
                "jasan" to jasan,
                "yunsodeuk" to yunsodeuk
            )
        }
    }
}