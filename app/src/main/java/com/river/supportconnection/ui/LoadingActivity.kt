package com.river.supportconnection.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.river.supportconnection.util.LoadingDialog
import com.river.supportconnection.R
import com.river.supportconnection.data.Finance
import com.river.supportconnection.data.Main
import com.river.supportconnection.data.Support
import com.river.supportconnection.data.api.FinanceService
import com.river.supportconnection.data.api.MainService
import com.river.supportconnection.data.recyclerData
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@JvmField
var data:MutableList<recyclerData> = mutableListOf<recyclerData>()

class LoadingActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        LoadingDialog(this).show()

        // 사용자 기본 data
       // val name = intent.getStringExtra("name")
     //   val age = intent.getIntExtra("age",0)
        val userId = intent.getIntExtra("userId",0)

        var name = ""
        var totalAmount = 0
        var cashAmount = 0
        var financialAmount = 0
        var myAsset = 0
        var supportRemain = 0
        var annualIncome = 0
        var loan = 0
        var interestRate = 0.0
        var creditRate = 3
        var currentInterest = 0
        var reduceInterest = 0
        var listSupport:MutableList<Support> = mutableListOf()


        //delay(200,unit = TimeUnit.MILLISECONDS)


        // -- Intent -- (Anko 사용)
        //loading_text.setOnClickListener {
            // 서버 연결 :: 최대지원금 뿌려주기
            val retrofit = Retrofit.Builder()
                .baseUrl(""+R.string.base_url)
                .addConverterFactory(GsonConverterFactory.create()).build()


            val financeService: FinanceService = retrofit.create(
                FinanceService::class.java)
            financeService.getMain(userId).enqueue(object: Callback<Finance> {
                override fun onResponse(call: Call<Finance>, response: Response<Finance>) {
                    Log.e("discount", response.body().toString())
                    var finance: Finance? = response.body()

                    currentInterest = finance?.currentInterest!!
                    reduceInterest = finance?.reduceInterest!!
                    listSupport = finance?.supports!!



                    var j = 0
                    listSupport.forEach{
                        it ->
                        var re: recyclerData =
                            recyclerData(
                                0,
                                "",
                                "",
                                0.0,
                                0
                            )
                        re?.supportId = it.supportId
                        re?.institution = it.name
                        re?.specific = it.site
                        re?.rate = it.rate
                        re?.saving = it.reduceInterest
                        data.add(re)

                    }
                    /*
                    for(i in listSupport.filterNotNull()){
                        re?.supportId = i.supportId
                        re?.institution = i.name
                        re?.specific = i.site
                        re?.rate = i.rate
                        re?.saving = i.reduceInterest
                        data.add(j,re)

                        j++
                    }*/


                    Log.e("support", data.toString())

                }

                override fun onFailure(call: Call<Finance>, t: Throwable) {
                    Log.e("discount", t.message!!)
                }
            })




            val mainService: MainService = retrofit.create(
                MainService::class.java)

            mainService.getMain(userId).enqueue(object: Callback<Main> {
                override fun onResponse(call: Call<Main>, response: Response<Main>) {
                    var main: Main? = response.body()

                    name = main?.name!!
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
                        "userId" to userId,
                        "totalAmount" to totalAmount,
                        "cashAmount" to cashAmount,
                        "financialAmount" to financialAmount,
                        "myAsset" to myAsset,
                        "supportRemain" to supportRemain,
                        "annualIncome" to annualIncome,
                        "loan" to loan,
                        "interestRate" to interestRate,
                        "creditRate" to creditRate,
                        "currentInterest" to currentInterest,
                        "reduceInterest" to reduceInterest,
                        //"data" to data
                    )
                    finish()
                }
                override fun onFailure(call: Call<Main>, t: Throwable) {
                    Log.e("Main", t.message!!)

                }
            })

        LoadingDialog(this).dismiss()


       // }

    }

}