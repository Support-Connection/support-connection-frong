package com.river.supportconnection.ui.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_register1.*
import org.jetbrains.anko.startActivity

class Register1Activity : AppCompatActivity() {
    lateinit var editname:EditText
    lateinit var editnum1:EditText
    lateinit var editnum2:EditText
    lateinit var nextbtn:Button

    val REQ_SUB=99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)
        regnumtag.visibility= View.INVISIBLE
        nametag.visibility=View.INVISIBLE

        // 이전 Intent
        beforebtn.setOnClickListener {
            finish()
        }

        editname=findViewById(R.id.reg_name)
        editnum1=findViewById(R.id.reg_num1)
        editnum2=findViewById(R.id.reg_num2)
        nextbtn=findViewById(R.id.next_rgstr1)

        var a=false
        var b= false
        var c= false


        // 다음 Intent
        nextbtn.setOnClickListener {
            var name = editname.text.toString()
            var reg_num1 = editnum1.text.toString()
            startActivity<Register2Activity>(
                "name" to name,
                "reg_num1" to reg_num1
            )
        }

        // 이름 Listener
        val Listener=object:TextWatcher{
            override fun beforeTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nametag.visibility=View.VISIBLE
            }
            override fun afterTextChanged(p0: Editable?) {
                val current_text=p0.toString()
                a = current_text.length>1
                nextbtn.isEnabled=a&&b&&c
            }
        }

        // 주민번호 앞자리 Listener
        val Listener2=object:TextWatcher{
            override fun beforeTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
                regnumtag.visibility=View.VISIBLE
            }
            override fun afterTextChanged(p0: Editable?) {
                val current_text=p0.toString()
                b = current_text.length==6
                nextbtn.isEnabled=a&&b&&c
            }
        }

        // 주민번호 뒷자리 Listener
        val Listener3=object:TextWatcher{
            override fun beforeTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(S: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                val current_text=p0.toString()
                c = current_text.isNotEmpty()
                nextbtn.isEnabled=a&&b&&c
                if(b&&c) regnumtag.visibility=View.VISIBLE

            }
        }

        editname.addTextChangedListener(Listener)
        editnum1.addTextChangedListener(Listener2)
        editnum2.addTextChangedListener(Listener3)
    }

}