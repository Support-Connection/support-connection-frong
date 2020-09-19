package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.Fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_input_info7_5.*

class InputInfo7_5Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7_5)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup", 0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried", 0)
        var haveChild = intent.getIntExtra("haveChild", 0)
        var childAge = intent.getIntExtra("childAge", 0)
        var isPregnant = intent.getIntExtra("isPregnant", 0)
        var occupation = intent.getIntExtra("occupation", 2)
        var isTemporary = intent.getIntExtra("isTemporary", 0)
        var isUnemployed = intent.getIntExtra("isUnemployed", 0)
        var businessType = intent.getStringExtra("businessType")
        var bisinessScale = intent.getIntExtra("businessScale",0)

        // back intent 처리
        beforebtn15.setOnClickListener {
            finish()
        }

        next_info7_5.setOnClickListener {


            val intent = Intent(this, RealMainActivity::class.java)
            /*
            @POST

            Integer.parseInt(annual_sale_edit.text.toString())

             */
            startActivity(intent)
        }


    }
}