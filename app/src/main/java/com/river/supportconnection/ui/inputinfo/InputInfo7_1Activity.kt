package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import com.river.supportconnection.ui.RealMainActivity
import com.river.supportconnection.data.ConditionRequest
import com.river.supportconnection.data.Conditions
import com.river.supportconnection.data.api.ConditionService
import kotlinx.android.synthetic.main.activity_input_info7_1.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InputInfo7_1Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7_1)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val province = intent.getStringExtra("province")
        val district = intent.getStringExtra("district")
        val incomeGroup = intent.getIntExtra("incomeGroup",0)
        val income = intent.getIntExtra("income",0)
        var isMarried = intent.getIntExtra("isMarried",0)
        var haveChild = intent.getIntExtra("haveChild",0)
        var childAge = intent.getIntExtra("childAge",0)
        var isPregnant = intent.getIntExtra("isPregnant",0)
        var occupation = intent.getIntExtra("occupation",1)

        // back intent 처리
        beforebtn11.setOnClickListener {
            finish()
        }

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl(""+R.string.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var conditionService: ConditionService = retrofit.create(
            ConditionService::class.java)

        info7_1_button1.setOnClickListener {
            //var userId = HomeFragment().arguments?.getInt("userId")
            var conditionRequest: ConditionRequest =
                ConditionRequest(
                    userId,
                    province.toString(),
                    district.toString(),
                    0,
                    20,
                    incomeGroup,
                    income,
                    isMarried,
                    haveChild,
                    0,
                    childAge,
                    isPregnant,
                    1,
                    1,
                    0,
                    "",
                    0,
                    0
                )
            conditionService.requiresCondition(conditionRequest).enqueue(object: Callback<Conditions> {
                override fun onResponse(call: Call<Conditions>, response: Response<Conditions>) {
                    Log.d("Responseee:: ", response.body().toString())

                }

                override fun onFailure(call: Call<Conditions>, t: Throwable) {
                    Log.e("Condition", t.message!!)
                    var dialog = AlertDialog.Builder(this@InputInfo7_1Activity)
                    dialog.setTitle("Error")
                    dialog.setMessage("전송에 실패하였습니다.")
                    dialog.show()
                }
            })
            startActivity<RealMainActivity>(
                "userId" to userId,
                "age" to age,
                "name" to name
            )
            finish()
        }

        info7_1_button2.setOnClickListener {
            var conditionRequest: ConditionRequest =
                ConditionRequest(
                    userId,
                    province.toString(),
                    district.toString(),
                    0,
                    20,
                    incomeGroup,
                    income,
                    isMarried,
                    haveChild,
                    0,
                    childAge,
                    isPregnant,
                    1,
                    0,
                    0,
                    "",
                    0,
                    0
                )
            conditionService.requiresCondition(conditionRequest).enqueue(object: Callback<Conditions> {
                override fun onResponse(call: Call<Conditions>, response: Response<Conditions>) {
                    Log.d("Responseee:: ", response.body().toString())

                }

                override fun onFailure(call: Call<Conditions>, t: Throwable) {
                    Log.e("Condition", t.message!!)
                    var dialog = AlertDialog.Builder(this@InputInfo7_1Activity)
                    dialog.setTitle("Error")
                    dialog.setMessage("전송에 실패하였습니다.")
                    dialog.show()
                }
            })
            startActivity<RealMainActivity>(
                "userId" to userId,
                "age" to age,
                "name" to name
            )
            finish()
        }


    }
}