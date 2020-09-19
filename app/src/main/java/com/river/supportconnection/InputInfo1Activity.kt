package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_input_info1.*
import kotlinx.android.synthetic.main.activity_register2.*

class InputInfo1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info1)

        provincetag.visibility = View.INVISIBLE
        districttag.visibility = View.INVISIBLE

        // login data
        //val user_id = intent.getStringExtra("user_id")

        // back intent 처리
        beforebtn3.setOnClickListener {
            finish()
        }

        // Bottom Sheet 클릭 이벤트
        val dialog = BottomSheetDialog(this)
        val SView = layoutInflater.inflate(R.layout.activity_province_swipe_up, null)
        val img1 = SView.findViewById<ImageView>(R.id.province_img1)
        val img2 = SView.findViewById<ImageView>(R.id.province_img2)
        val img3 = SView.findViewById<ImageView>(R.id.province_img3)

        img1.visibility = View.INVISIBLE
        img2.visibility = View.INVISIBLE
        img3.visibility = View.INVISIBLE

        province_edit.setOnClickListener {
            val close = SView.findViewById<Button>(R.id.province_close_btn)
            close.setOnClickListener {
                dialog.dismiss()
            }

            val seoul = SView.findViewById<TextView>(R.id.province_text1)
            seoul.setOnClickListener {
                province_edit.setText("서울시")
                provincetag.visibility = View.VISIBLE
                districttag.visibility = View.VISIBLE
                dialog.dismiss()
            }

            val gyeonggi = SView.findViewById<TextView>(R.id.province_text2)
            gyeonggi.setOnClickListener {
                province_edit.setText("경기도")
                provincetag.visibility = View.VISIBLE
                districttag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val incheon = SView.findViewById<TextView>(R.id.province_text3)
            incheon.setOnClickListener {
                province_edit.setText("인천")
                provincetag.visibility = View.VISIBLE
                districttag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            dialog.setContentView(SView)
            dialog.show()
        }




        // 다음 page로 이동 > RegActivity 죽이기
        next_info1.setOnClickListener {
            val intent = Intent(this, InputInfo2Activity::class.java)
           intent.putExtra("province",province_edit.text.toString())
            intent.putExtra("district",district_edit.text.toString())
            startActivity(intent)

        }
    }
}