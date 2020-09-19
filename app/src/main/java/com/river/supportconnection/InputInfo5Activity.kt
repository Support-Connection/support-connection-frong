package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info5.*

class InputInfo5Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info5)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getStringExtra("income")
        var isMarried = intent.getIntExtra("isMarried",0)


        // back intent 처리
        beforebtn7.setOnClickListener {
            finish()
        }

        info5_button1.setOnClickListener {
            val intent = Intent(this, InputInfo5_1Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup)
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            startActivity(intent)
        }

        info5_button2.setOnClickListener {
            val intent = Intent(this, InputInfo6Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            startActivity(intent)
        }
    }
}