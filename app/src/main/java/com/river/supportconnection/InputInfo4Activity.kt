package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info4.*
import org.jetbrains.anko.startActivity

class InputInfo4Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info4)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getStringExtra("income")?.toInt()


        // back intent 처리
        beforebtn6.setOnClickListener {
            finish()
        }

        info4_button1.setOnClickListener {
            startActivity<InputInfo5Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to 1
            )
        }

        info4_button2.setOnClickListener {
            startActivity<InputInfo5Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to 0
            )
        }
    }
}