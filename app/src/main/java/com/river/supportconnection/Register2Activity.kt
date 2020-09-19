package com.river.supportconnection

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_register2.*

class Register2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        teltag.visibility = View.INVISIBLE
        phonetag.visibility = View.INVISIBLE

        // login data
        val name = intent.getStringExtra("name")
        val reg_num1 = intent.getStringExtra("reg_num1")
        val reg_num2 = intent.getStringExtra("reg_num2")

        // back intent 처리
        beforebtn2.setOnClickListener {
            finish()
        }

        // Bottom Sheet 클릭 이벤트
        val dialog = BottomSheetDialog(this)
        val SView = layoutInflater.inflate(R.layout.activity_swipeup, null)
        val img1 = SView.findViewById<ImageView>(R.id.tel_img1)
        val img2 = SView.findViewById<ImageView>(R.id.tel_img2)
        val img3 = SView.findViewById<ImageView>(R.id.tel_img3)
        val img4 = SView.findViewById<ImageView>(R.id.tel_img4)
        val img5 = SView.findViewById<ImageView>(R.id.tel_img5)
        val img6 = SView.findViewById<ImageView>(R.id.tel_img6)

        img1.visibility = View.INVISIBLE
        img2.visibility = View.INVISIBLE
        img3.visibility = View.INVISIBLE
        img4.visibility = View.INVISIBLE
        img5.visibility = View.INVISIBLE
        img6.visibility = View.INVISIBLE

        tel_edit.setOnClickListener {
            val close = SView.findViewById<Button>(R.id.close_btn)
            close.setOnClickListener {
                dialog.dismiss()
            }

            val skt = SView.findViewById<TextView>(R.id.tel_text1)
            skt.setOnClickListener {
                tel_edit.setText("SKT")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }

            val kt = SView.findViewById<TextView>(R.id.tel_text2)
            kt.setOnClickListener {
                tel_edit.setText("KT")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val lg = SView.findViewById<TextView>(R.id.tel_text3)
            lg.setOnClickListener {
                tel_edit.setText("LGU+")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val a_skt = SView.findViewById<TextView>(R.id.tel_text4)
            a_skt.setOnClickListener {
                tel_edit.setText("알뜰폰 (SKT)")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val a_kt = SView.findViewById<TextView>(R.id.tel_text5)
            a_kt.setOnClickListener {
                tel_edit.setText("알뜰폰 (KT)")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            val a_lg = SView.findViewById<TextView>(R.id.tel_text6)
            a_lg.setOnClickListener {
                tel_edit.setText("알뜰폰 (LGU+)")
                teltag.visibility = View.VISIBLE
                phonetag.visibility = View.VISIBLE
                dialog.dismiss()
            }
            dialog.setContentView(SView)
            dialog.show()
        }

        // 전화번호 hyphen
        phone_edit.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        // 다음 page로 이동 > RegActivity 죽이기
        next_rgstr2.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("birth",reg_num1)
            intent.putExtra("sex",reg_num2)
            startActivity(intent)

        }

        // 서버랑 통신해서 로그인/회원가입
    }
}