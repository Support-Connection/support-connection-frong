package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info3.*
import org.jetbrains.anko.startActivity

class InputInfo3Activity: AppCompatActivity() {
    lateinit var editincome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info3)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
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
            startActivity<InputInfo4Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to editincome.text.toString()
            )
        }


    }
}