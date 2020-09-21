package com.river.supportconnection.ui.inputinfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.ui.Jasaninput_activity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info7_3.*

class InputInfo7_3Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7_3)

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
        var isPregnant = intent.getIntExtra("isPregnant",0)
        var occupation = intent.getIntExtra("occupation",2)

        // back intent 처리
        beforebtn13.setOnClickListener {
            finish()
        }

        next_info7_3.setOnClickListener {
            val intent = Intent(this, Jasaninput_activity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("userId",userId)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", haveChild);
            intent.putExtra("childAge",childAge);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",occupation)
            intent.putExtra("isTemporary", 0)
            intent.putExtra("isUnemployed", 0)
            intent.putExtra("businessType", business_type_edit.text.toString())
            intent.putExtra("businessScale", 0)
            intent.putExtra("annualSale", 0)
            startActivity(intent)
        }


    }
}