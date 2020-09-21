package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info2.*
import org.jetbrains.anko.startActivity

class InputInfo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info2)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")


        // back intent 처리
        beforebtn4.setOnClickListener {
            finish()
        }

        info2_button1.setOnClickListener {
            startActivity<InputInfo3Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to 0
            )
        }

        info2_button2.setOnClickListener {
            startActivity<InputInfo3Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to 1
            )
        }

        info2_button3.setOnClickListener {
            startActivity<InputInfo3Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to 2
            )
        }


    }
}