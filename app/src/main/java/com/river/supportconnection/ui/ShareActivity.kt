package com.river.supportconnection.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.activity_share.*
import org.jetbrains.anko.startActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)


        // 사용자 기본 data
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val userId = intent.getIntExtra("userId",0)

        var totalAmount = 0
        var cashAmount = 0
        var financialAmount = 0
        var myAsset = 0
        var supportRemain = 0
        var annualIncome = 0
        var loan = 0
        var interestRate = 0.0
        var creditRate = 3


        // 이름 변경
        share_text1.text = "안녕하세요 " + name + "님,\n서폿커넥션에 잘오셨어요!"


        // -- Intent -- (Anko 사용)
        next_share.setOnClickListener {
            startActivity<LoadingActivity>(
                "name" to name,
                "age" to age,
                "userId" to userId,
            )

            /*
            // 서버 연결 :: 최대지원금 뿌려주기
            val retrofit = Retrofit.Builder()
                .baseUrl("http://133.186.241.35:8001")
                .addConverterFactory(GsonConverterFactory.create()).build()

            val mainService: MainService = retrofit.create(MainService::class.java)

            mainService.getMain(userId).enqueue(object: Callback<Main> {

                override fun onResponse(call: Call<Main>, response: Response<Main>) {
                    var main:Main? = response.body()

                    totalAmount = main?.totalAmount!!
                    cashAmount = main?.cashAmount!!
                    financialAmount = main?.financialAmount!!
                    myAsset = main?.myAsset!!
                    supportRemain = main?.supportRemain!!
                    annualIncome = main?.annualIncome!!
                    loan = main?.loan!!
                    interestRate = main?.interestRate!!
                    creditRate = main?.creditRate!!

                    startActivity<RealMainActivity>(
                        "name" to name,
                        "age" to age,
                        "userId" to userId,
                        "totalAmount" to totalAmount,
                        "cashAmount" to cashAmount,
                        "financialAmount" to financialAmount,
                        "myAsset" to myAsset,
                        "supportRemain" to supportRemain,
                        "annualIncome" to annualIncome,
                        "loan" to loan,
                        "interestRate" to interestRate,
                        "creditRate" to creditRate
                    )
                }
                override fun onFailure(call: Call<Main>, t: Throwable) {
                    Log.e("Main", t.message!!)

                }
            })*/



        }
    }
}