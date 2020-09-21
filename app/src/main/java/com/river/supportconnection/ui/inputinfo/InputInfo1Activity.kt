package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_input_info1.*
import org.jetbrains.anko.startActivity

class InputInfo1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info1)

        provincetag.visibility = View.INVISIBLE
        districttag.visibility = View.INVISIBLE

        // login data
        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)

        // back intent 처리
        beforebtn3.setOnClickListener {
            finish()
        }

        // Bottom Sheet 클릭 이벤트
        val dialog = BottomSheetDialog(this)
        val SView = layoutInflater.inflate(R.layout.activity_province_swipe_up, null)

        province_edit.setOnClickListener {
            val close = SView.findViewById<Button>(R.id.province_close_btn)
            close.setOnClickListener {
                dialog.dismiss()
            }

            val seoul = SView.findViewById<TextView>(R.id.province_text1)
            seoul.setOnClickListener {
                province_edit.setText("서울특별시")
                provincetag.visibility = View.VISIBLE
                dialog.dismiss()
            }

            val gyeonggi = SView.findViewById<TextView>(R.id.province_text2)
            gyeonggi.setOnClickListener {
                province_edit.setText("경기도")
                provincetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val incheon = SView.findViewById<TextView>(R.id.province_text3)
            incheon.setOnClickListener {
                province_edit.setText("인천광역시")
                provincetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            dialog.setContentView(SView)
            dialog.show()
        }


        // Bottom Sheet 클릭 이벤트
        val dialog2 = BottomSheetDialog(this)
        val SView2 = layoutInflater.inflate(R.layout.activity_district_swipe_up, null)

        district_edit.setOnClickListener {
            val close2 = SView2.findViewById<Button>(R.id.district_close_btn)
            close2.setOnClickListener {
                dialog2.dismiss()
            }

            val district1 = SView2.findViewById<TextView>(R.id.district_text1)
            district1.setOnClickListener {
                district_edit.setText("강남구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district2 = SView2.findViewById<TextView>(R.id.district_text2)
            district2.setOnClickListener {
                district_edit.setText("강동구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district3 = SView2.findViewById<TextView>(R.id.district_text3)
            district3.setOnClickListener {
                district_edit.setText("강북구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }
            val district4 = SView2.findViewById<TextView>(R.id.district_text4)
            district4.setOnClickListener {
                district_edit.setText("강서구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }
            val district5 = SView2.findViewById<TextView>(R.id.district_text5)
            district5.setOnClickListener {
                district_edit.setText("관악구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }
            val district6 = SView2.findViewById<TextView>(R.id.district_text6)
            district6.setOnClickListener {
                district_edit.setText("광진구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district7 = SView2.findViewById<TextView>(R.id.district_text7)
            district7.setOnClickListener {
                district_edit.setText("구로구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district8 = SView2.findViewById<TextView>(R.id.district_text8)
            district8.setOnClickListener {
                district_edit.setText("금천구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district9 = SView2.findViewById<TextView>(R.id.district_text9)
            district9.setOnClickListener {
                district_edit.setText("노원구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district10 = SView2.findViewById<TextView>(R.id.district_text10)
            district10.setOnClickListener {
                district_edit.setText("도봉구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district11 = SView2.findViewById<TextView>(R.id.district_text11)
            district11.setOnClickListener {
                district_edit.setText("동대문구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            val district12 = SView2.findViewById<TextView>(R.id.district_text12)
            district12.setOnClickListener {
                district_edit.setText("동작구")
                districttag.visibility = View.VISIBLE
                dialog2.dismiss()
            }

            dialog2.setContentView(SView2)
            dialog2.show()
        }

        // 다음 page로 이동
        next_info1.setOnClickListener {
            startActivity<InputInfo2Activity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
                "province" to province_edit.text.toString(),
                "district" to district_edit.text.toString()
            )
        }
    }
}