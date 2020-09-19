package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.Fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_input_info7.*

class InputInfo7Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried",0)
        var haveChild = intent.getIntExtra("haveChild",0)
        var childAge = intent.getIntExtra("childAge",0)
        var isPregnant = intent.getIntExtra("isPregnant",0)

        // back intent 처리
        beforebtn10.setOnClickListener {
            finish()
        }

        info7_button1.setOnClickListener {
            val intent = Intent(this, RealMainActivity::class.java)
            /*
             ("occupation", 0)
             ("isTemporary", 0)
             "isUnemployed", 0)
             ("businessType", "")
             ("businessScale", 0)
             ("annualSale", 0)
             */
            startActivity(intent)
        }

        info7_button2.setOnClickListener {
            val intent = Intent(this, InputInfo7_1Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",1)
            startActivity(intent)
        }

        info7_button3.setOnClickListener {
            val intent = Intent(this, InputInfo7_2Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",2)
            startActivity(intent)
        }

        info7_button4.setOnClickListener {
            val intent = Intent(this, InputInfo7_3Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",3)
            startActivity(intent)
        }

        info7_button5.setOnClickListener {
            val intent = Intent(this, RealMainActivity::class.java)
            /*
             ("occupation", 4)
             ("isTemporary", 0)
             "isUnemployed", 0)
             ("businessType", "")
             ("businessScale", 0)
             ("annualSale", 0)
             */
            startActivity(intent)
        }

    }
}