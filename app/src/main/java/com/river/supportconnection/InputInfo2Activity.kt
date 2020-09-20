package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info1.*
import kotlinx.android.synthetic.main.activity_input_info2.*

class InputInfo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info2)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val userId = intent.getIntExtra("user_id",0)
        val age = intent.getIntExtra("age",0)


        // back intent 처리
        beforebtn4.setOnClickListener {
            finish()
        }

        info2_button1.setOnClickListener {
            val intent = Intent(this, InputInfo3Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",0);
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            startActivity(intent)
        }

        info2_button2.setOnClickListener {
            val intent = Intent(this, InputInfo3Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",1);
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            startActivity(intent)
        }

        info2_button3.setOnClickListener {
            val intent = Intent(this, InputInfo3Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",2);
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            startActivity(intent)
        }


    }
}