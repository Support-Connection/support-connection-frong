package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_input_info7_4.*

class InputInfo7_4Activity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7_4)

        val userId = intent.getIntExtra("user_id",0)
        val age = intent.getIntExtra("age",0)
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

        // back intent 처리
        beforebtn14.setOnClickListener {
            finish()
        }

        var businessScale = 0;

        // Bottom Sheet 클릭 이벤트
        val dialog = BottomSheetDialog(this)
        val SView = layoutInflater.inflate(R.layout.activity_scale_swipe_up, null)

        business_scale_edit.setOnClickListener {
            val close = SView.findViewById<Button>(R.id.scale_close_btn)
            close.setOnClickListener {
                dialog.dismiss()
            }

            val s1 = SView.findViewById<TextView>(R.id.scale_text1)
            s1.setOnClickListener {
                business_scale_edit.setText("5인 미만")
                businessScale = 0
                dialog.dismiss()
            }

            val s2 = SView.findViewById<TextView>(R.id.scale_text2)
            s2.setOnClickListener {
                business_scale_edit.setText("10인 미만")
                businessScale = 1;
                dialog.dismiss()
            }
            val s3 = SView.findViewById<TextView>(R.id.scale_text3)
            s3.setOnClickListener {
                business_scale_edit.setText("50인 미만")
                businessScale = 2
                dialog.dismiss()
            }
            val s4 = SView.findViewById<TextView>(R.id.scale_text4)
            s4.setOnClickListener {
                business_scale_edit.setText("50인 이상")
                businessScale = 3
                dialog.dismiss()
            }
            dialog.setContentView(SView)
            dialog.show()
        }

        next_info7_4.setOnClickListener {
            val intent = Intent(this, InputInfo7_5Activity::class.java)
            intent.putExtra("userId", userId)
            intent.putExtra("age",age)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", haveChild);
            intent.putExtra("childAge",childAge);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",occupation)
            intent.putExtra("isTemporary", isTemporary)
            intent.putExtra("isUnemployed", isUnemployed)
            intent.putExtra("businessType", businessType)
            intent.putExtra("businessScale", businessScale)
            startActivity(intent)
        }


    }

}