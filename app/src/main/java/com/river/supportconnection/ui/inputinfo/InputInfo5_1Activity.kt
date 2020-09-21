package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info5_1.*
import org.jetbrains.anko.startActivity

class InputInfo5_1Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info5_1)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
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
            startActivity<InputInfo6Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to 1,
                "childAge" to child_age_edit.text.toString()
            )
        }


    }
}