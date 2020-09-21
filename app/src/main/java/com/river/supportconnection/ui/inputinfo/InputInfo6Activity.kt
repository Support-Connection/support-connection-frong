package com.river.supportconnection.ui.inputinfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info6.*
import org.jetbrains.anko.startActivity

class InputInfo6Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info6)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
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
            startActivity<InputInfo7Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to haveChild,
                "childAge" to childAge,
                "isPregnant" to 1
            )
        }

        info6_button2.setOnClickListener {
            val intent = Intent(this, InputInfo7Activity::class.java)
            startActivity<InputInfo7Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to 0,
                "childAge" to 0,
                "isPregnant" to 0
            )
        }
    }
}