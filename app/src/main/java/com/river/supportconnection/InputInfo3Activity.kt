package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_info3.*
import kotlinx.android.synthetic.main.activity_register1.*
import kotlinx.android.synthetic.main.activity_register2.*

class InputInfo3Activity: AppCompatActivity() {
    lateinit var editincome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info3)

        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)


        editincome = findViewById(R.id.income_edit)

        // back intent 처리
        beforebtn5.setOnClickListener {
            finish()
        }



        val Listener=object:TextWatcher{
            override fun beforeTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        }

        editincome.addTextChangedListener(Listener)

        next_info3.setOnClickListener {
            val intent = Intent(this, InputInfo4Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup)
            intent.putExtra("income", editincome.text.toString())
            startActivity(intent)
        }


    }
}