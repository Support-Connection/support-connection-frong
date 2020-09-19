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

        var jasan:Jasan? = null

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl("http://115.85.183.20:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var jasanService: JasanService = retrofit.create(JasanService::class.java)

        jasan_btn1.setOnClickListener {
            var userId = HomeFragment().arguments?.getInt("userId")
            var myAsset = jasan_edit1.text.toString().toInt()
            var annualIncome = jasan_edit2.text.toString().toInt()

            if (userId != null) {
                jasanService.requiresAsset(userId, myAsset, annualIncome).enqueue(object: Callback<Jasan>{
                    override fun onResponse(call: Call<Jasan>, response: Response<Jasan>) {
                        jasan = response.body()
                    }

                    override fun onFailure(call: Call<Jasan>, t: Throwable) {
                        Log.e("LOGIN", t.message!!)
                        var dialog = AlertDialog.Builder(this@Jasaninput_activity)
                        dialog.setTitle("Error")
                        dialog.setMessage("자산 정보 입력에 실패하였습니다.")
                        dialog.show()
                    }
                })
            }
        }
    }
}