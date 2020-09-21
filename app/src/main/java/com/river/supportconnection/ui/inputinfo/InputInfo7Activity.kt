package com.river.supportconnection.ui.inputinfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.ui.LoadingActivity
import com.river.supportconnection.R
import com.river.supportconnection.ui.RealMainActivity
import com.river.supportconnection.data.ConditionRequest
import com.river.supportconnection.data.Conditions
import com.river.supportconnection.data.api.ConditionService
import kotlinx.android.synthetic.main.activity_input_info7.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InputInfo7Activity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_info7)

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

        // back intent 처리
        beforebtn10.setOnClickListener {
            finish()
        }

        var retrofit = Retrofit.Builder()
            .baseUrl(""+R.string.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var conditionService: ConditionService = retrofit.create(
            ConditionService::class.java)

        info7_button1.setOnClickListener {
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
                    0,
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
                    var dialog = AlertDialog.Builder(this@InputInfo7Activity)
                    dialog.setTitle("Error")
                    dialog.setMessage("전송에 실패하였습니다.")
                    dialog.show()
                }
            })
            startActivity<LoadingActivity>(
                "userId" to userId,
                "age" to age,
                "name" to name
            )
            finish()
        }

        info7_button2.setOnClickListener {
            startActivity<InputInfo7_1Activity>(
                "userId" to userId,
                "age" to age,
                "name" to name,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to 0,
                "childAge" to 0,
                "isPregnant" to isPregnant,
                "occupation" to 1
            )
        }

        info7_button3.setOnClickListener {
            startActivity<InputInfo7_2Activity>(
                "userId" to userId,
                "age" to age,
                "name" to name,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to 0,
                "childAge" to 0,
                "isPregnant" to isPregnant,
                "occupation" to 2
            )
        }

        info7_button4.setOnClickListener {
            startActivity<InputInfo7_3Activity>(
                "userId" to userId,
                "age" to age,
                "name" to name,
                "province" to province,
                "district" to district,
                "incomeGroup" to incomeGroup,
                "income" to income,
                "isMarried" to isMarried,
                "haveChild" to 0,
                "childAge" to 0,
                "isPregnant" to isPregnant,
                "occupation" to 3
            )
        }

        info7_button5.setOnClickListener {
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
                    4,
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
                    var dialog = AlertDialog.Builder(this@InputInfo7Activity)
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