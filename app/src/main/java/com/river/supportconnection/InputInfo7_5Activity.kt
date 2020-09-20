package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.Fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_input_info7_5.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InputInfo7_5Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7_5)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val province = intent.getStringExtra("province").toString()
        val district = intent.getStringExtra("district").toString()
        val incomeGroup = intent.getIntExtra("incomeGroup", 0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried", 0)
        var haveChild = intent.getIntExtra("haveChild", 0)
        var childAge = intent.getIntExtra("childAge", 0)
        var isPregnant = intent.getIntExtra("isPregnant", 0)
        var occupation = intent.getIntExtra("occupation", 2)
        var isTemporary = intent.getIntExtra("isTemporary", 0)
        var isUnemployed = intent.getIntExtra("isUnemployed", 0)
        var businessType = intent.getStringExtra("businessType").toString()
        var businessScale = intent.getIntExtra("businessScale",0)

        // back intent 처리
        beforebtn15.setOnClickListener {
            finish()
        }

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl("http://133.186.241.35:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var conditionService: ConditionService = retrofit.create(ConditionService::class.java)


        next_info7_5.setOnClickListener {

            var annualSale = annual_sale_edit.text.toString().toInt()

            var condition:Condition = Condition(userId,province,district,0,20,incomeGroup,income,isMarried,haveChild,0,childAge,isPregnant,occupation,isTemporary,isUnemployed,businessType,businessScale,annualSale)
            conditionService.requiresCondition(condition).enqueue(object: Callback<Conditions> {
                override fun onResponse(call: Call<Conditions>, response: Response<Conditions>) {
                    Log.d("Responseee:: ", response.body().toString())

                }

                override fun onFailure(call: Call<Conditions>, t: Throwable) {
                    Log.e("Condition", t.message!!)
                    var dialog = AlertDialog.Builder(this@InputInfo7_5Activity)
                    dialog.setTitle("Error")
                    dialog.setMessage("전송에 실패하였습니다.")
                    dialog.show()
                }
            })
            startActivity<Jasaninput_activity>(
                "name" to name,
                "age" to age,
                "uerId" to userId
            )
            finish()

        }


    }

}