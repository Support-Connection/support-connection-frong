package com.river.supportconnection.ui.register

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.river.supportconnection.R
import com.river.supportconnection.data.Login
import com.river.supportconnection.data.LoginRequest
import com.river.supportconnection.data.api.LoginService
import com.river.supportconnection.ui.ShareActivity
import kotlinx.android.synthetic.main.activity_register2.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register2Activity : AppCompatActivity() {

    var login: Login? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        // Visibility
        teltag.visibility = View.INVISIBLE
        phonetag.visibility = View.INVISIBLE

        // login data
        val name = intent.getStringExtra("name").toString()
        val regNum1 = intent.getStringExtra("reg_num1")
        val year = regNum1?.substring(0,2)?.toInt() ?: 0
        var age = 0
        age = if(year<=20){
            2021-(2000+year)
        } else{
            2021-(1900+year)
        }

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl(""+R.string.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var loginService: LoginService = retrofit.create(
            LoginService::class.java)


        // Intent
        next_rgstr2.setOnClickListener {
            var phoneNumber = phone_edit.text.toString()
            var agency = tel_edit.text.toString()

            var loginRequest: LoginRequest =
                LoginRequest(
                    name,
                    agency,
                    phoneNumber,
                    age
                )
            loginService.requestLogin(loginRequest).enqueue(object: Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {

                    var userId = response.body().toString().toInt()
                    startActivity<ShareActivity>(
                        "name" to name,
                        "age" to age,
                        "userId" to userId
                    )
                    finish()
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Log.e("LOGIN", t.message!!)
                    var dialog = AlertDialog.Builder(this@Register2Activity)
                    dialog.setTitle("Error")
                    dialog.setMessage("로그인에 실패하였습니다.")
                    dialog.show()
                }
            })
        }

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



    }
}