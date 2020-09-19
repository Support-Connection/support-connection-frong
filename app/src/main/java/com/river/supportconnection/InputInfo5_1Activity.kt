package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info5_1.*

class InputInfo5_1Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info5_1)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried",0)


        // back intent 처리
        beforebtn8.setOnClickListener {
            finish()
        }


        next_info5_1.setOnClickListener {
            val intent = Intent(this, InputInfo6Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup)
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried)
            intent.putExtra("haveChild", 1)
            intent.putExtra("childAge",child_age_edit.text.toString())
            startActivity(intent)
        }


    }
}