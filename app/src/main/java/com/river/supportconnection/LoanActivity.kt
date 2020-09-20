package com.river.supportconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_loan.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)

        val userId = intent.getIntExtra("userId",0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        var myAsset = intent.getIntExtra("myAsset",0)
        var annualIncome = intent.getIntExtra("annualIncome",0)

        // 서버랑 통신
        var retrofit = Retrofit.Builder()
            .baseUrl("http://133.186.241.35:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loanService: LoanService = retrofit.create(LoanService::class.java)

        // 버튼 클릭 이벤트
        loan_btn1.setOnClickListener {
            var loan = loan_edit1.text.toString().toInt()
            var interestRate = loan_edit2.text.toString().toInt()

            loanService.requiresAsset(userId, loan, interestRate).enqueue(object: Callback<Jasan> {
                override fun onResponse(call: Call<Jasan>, response: Response<Jasan>) {
                    Log.d("Responseee:: ", response.body().toString())
                }

                override fun onFailure(call: Call<Jasan>, t: Throwable) {
                    Log.e("Loan", t.message!!)
                    var dialog = AlertDialog.Builder(this@LoanActivity)
                    dialog.setTitle("Error")
                    dialog.setMessage("대출 정보 입력에 실패하였습니다.")
                    dialog.show()
                }
            })

            startActivity<RealMainActivity>(
                "userId" to userId,
                "name" to name,
                "age" to age,
                "myAsset" to myAsset,
                "annualIncome" to annualIncome,
                "loan" to loan,
                "interestReat" to interestRate
            )
            finish()
        }


    }
}