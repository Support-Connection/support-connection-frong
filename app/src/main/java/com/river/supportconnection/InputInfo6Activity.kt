package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info6.*

class InputInfo6Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info6)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried",0)
        var haveChild = intent.getIntExtra("haveChild",0)
        var childAge = intent.getIntExtra("childAge",0)


        // back intent 처리
        beforebtn9.setOnClickListener {
            finish()
        }

        info6_button1.setOnClickListener {
            val intent = Intent(this, InputInfo7Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup)
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried)
            intent.putExtra("haveChild", haveChild)
            intent.putExtra("childAge", childAge)
            intent.putExtra("isPregnant", 1)
            startActivity(intent)
        }

        info6_button2.setOnClickListener {
            val intent = Intent(this, InputInfo7Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", 0)
            startActivity(intent)
        }
    }
}