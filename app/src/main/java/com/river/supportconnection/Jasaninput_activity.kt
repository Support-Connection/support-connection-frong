package com.river.supportconnection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.river.supportconnection.Fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_jasaninput_activity.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.system.exitProcess

class Jasaninput_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jasaninput_activity)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl("http://133.186.241.35:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jasanService: JasanService = retrofit.create(JasanService::class.java)

        jasan_btn1.setOnClickListener {
            var myAsset = jasan_edit1.text.toString().toInt()
            var annualIncome = jasan_edit2.text.toString().toInt()

            jasanService.requiresAsset(userId, myAsset, annualIncome).enqueue(object: Callback<Jasan> {
                override fun onResponse(call: Call<Jasan>, response: Response<Jasan>) {
                    Log.d("Responseee:: ", response.body().toString())
                }

                override fun onFailure(call: Call<Jasan>, t: Throwable) {
                    Log.e("Jasan", t.message!!)
                }
            })

            startActivity<LoanActivity>(
                "userId" to userId,
                "name" to name,
                "age" to age,
                "myAsset" to myAsset,
                "annualIncome" to annualIncome
            )
            finish()
        }
    }
}