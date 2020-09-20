package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info4.*

class InputInfo4Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info4)

        val userId = intent.getIntExtra("user_id",0)
        val age = intent.getIntExtra("age",0)
        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getIntExtra("income",0)


        // back intent 처리
        beforebtn6.setOnClickListener {
            finish()
        }

        info4_button1.setOnClickListener {
            val intent = Intent(this, InputInfo5Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup)
            intent.putExtra("income",income)
            intent.putExtra("isMarried", 1);
            startActivity(intent)
        }

        info4_button2.setOnClickListener {
            val intent = Intent(this, InputInfo5Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", 0);
            startActivity(intent)
        }
    }
}