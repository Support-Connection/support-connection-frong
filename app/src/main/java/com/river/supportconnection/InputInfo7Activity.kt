package com.river.supportconnection

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.Fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_input_info7.*
import kotlinx.android.synthetic.main.activity_input_info7_5.*
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
            .baseUrl("http://115.85.183.20:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var conditionService: ConditionService = retrofit.create(ConditionService::class.java)

        info7_button1.setOnClickListener {
            //var userId = HomeFragment().arguments?.getInt("userId")
            var userId = 6
            var condition:Condition = Condition(userId,province.toString(),district.toString(),0,20,incomeGroup,income,isMarried,haveChild,0,childAge,isPregnant,0,0,0,"",0,0)
            conditionService.requiresCondition(condition).enqueue(object: Callback<Conditions> {
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
            startActivity<RealMainActivity>()
            finish()
        }

        info7_button2.setOnClickListener {
            val intent = Intent(this, InputInfo7_1Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",1)
            startActivity(intent)
        }

        info7_button3.setOnClickListener {
            val intent = Intent(this, InputInfo7_2Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",2)
            startActivity(intent)
        }

        info7_button4.setOnClickListener {
            val intent = Intent(this, InputInfo7_3Activity::class.java)
            intent.putExtra("province",province)
            intent.putExtra("district",district)
            intent.putExtra("incomeGroup",incomeGroup);
            intent.putExtra("income",income)
            intent.putExtra("isMarried", isMarried);
            intent.putExtra("haveChild", 0);
            intent.putExtra("childAge",0);
            intent.putExtra("isPregnant", isPregnant)
            intent.putExtra("occupation",3)
            startActivity(intent)
        }

        info7_button5.setOnClickListener {
            //var userId = HomeFragment().arguments?.getInt("userId")
            var userId = 6
            var condition:Condition = Condition(userId,province.toString(),district.toString(),0,20,incomeGroup,income,isMarried,haveChild,0,childAge,isPregnant,4,0,0,"",0,0)
            conditionService.requiresCondition(condition).enqueue(object: Callback<Conditions> {
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
            startActivity<RealMainActivity>()
            finish()
        }

    }
}