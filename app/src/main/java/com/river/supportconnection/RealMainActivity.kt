package com.river.supportconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.river.supportconnection.Adapter.CustomAdapter
//import com.river.supportconnection.Adapter.PageAdapter
import com.river.supportconnection.Fragments.*
import kotlinx.android.synthetic.main.fragment_discount.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RealMainActivity : AppCompatActivity() {
    private lateinit var homeBtn: ImageButton
    private lateinit var searchBtn: ImageButton
    private lateinit var discountBtn: ImageButton
    private lateinit var alertBtn: ImageButton
    private lateinit var mypageBtn: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPageAdapter: PageAdapter
    var main:Main? = null

    // (계산되서 main에 뿌려줄) 기본 data들 (> HomeActivity로 이동)
    var name = ""
    var age = 0
    var userId = 0
    var totalAmount=0
    var cashAmount=0
    var financialAmount=0
    var supportRemain=0


    // (입력받을) 기본 data들 : 사용자 입력
    //<3>
    var myAsset = 0
    var annualIncome = 0
    var loan = 0
    var interestRate = 10.0

    // (입력X않을) 기본 data들 : 초깃값 이용
    var creditRate = 3
    var currencInterest = 20000000
    var reduceInterest = 19000000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)

        // 기본 data
        name= intent.getStringExtra("name").toString()
        age=intent.getIntExtra("age",0)
        userId=intent.getIntExtra("userId",0)
        myAsset=intent.getIntExtra("myAsset",0)
        annualIncome = intent.getIntExtra("annualIncome",0)
        loan = intent.getIntExtra("loan",0)
        interestRate = intent.getDoubleExtra("interestRate",0.0)


        // 서버 연결 :: 최대지원금 뿌려주기
        val retrofit = Retrofit.Builder()
            .baseUrl("http://133.186.241.35:8001")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val mainService: MainService = retrofit.create(MainService::class.java)
        mainService.getMain(userId).enqueue(object: Callback<Main>{
            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                main = response.body()
                totalAmount = main?.totalAmount ?: 0
                cashAmount = main?.cashAmount!!
                financialAmount = main?.financialAmount!!
                myAsset = main?.financialAmount!!
                supportRemain = main?.supportRemain ?: 0
            }

            override fun onFailure(call: Call<Main>, t: Throwable) {
                Log.e("LOGIN", t.message!!)
                var dialog = AlertDialog.Builder(this@RealMainActivity)
                dialog.setTitle("Error")
                dialog.setMessage("연결 실패하였습니다.")
                dialog.show()
            }
        })


        HomeFragment().apply {
            arguments = Bundle().apply {
                putString("name",name)
            }
        }

        // init views
        mViewPager = findViewById(R.id.mViewpager)

        // init image buttons
        homeBtn = findViewById(R.id.homeBtn)
        searchBtn = findViewById(R.id.searchBtn)
        discountBtn = findViewById(R.id.discountBtn)
        alertBtn = findViewById(R.id.alertBtn)
        mypageBtn = findViewById(R.id.mypageBtn)

        mPageAdapter = PageAdapter(supportFragmentManager)
        mViewPager.adapter = mPageAdapter
        mViewPager.offscreenPageLimit = 5

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                changingTabs(position)
            }
        })

        // default
        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home_blue)

        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0
        }
        searchBtn.setOnClickListener {
            mViewPager.currentItem = 1
        }

        discountBtn.setOnClickListener{
            mViewPager.currentItem = 2

            // data 올려주기
            val data = loadData()
            val adapter = CustomAdapter()
            adapter.listData = data
            fdiscount_recycler.adapter = adapter
            fdiscount_recycler.layoutManager = LinearLayoutManager(this)

        }

        alertBtn.setOnClickListener {
            mViewPager.currentItem = 3
        }

        mypageBtn.setOnClickListener {
            mViewPager.currentItem = 4
        }
    }

    private fun changingTabs(position: Int) {
        if(position == 0){
            homeBtn.setImageResource(R.drawable.ic_home_blue)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            discountBtn.setImageResource(R.drawable.ic_discount_black)
            alertBtn.setImageResource(R.drawable.ic_alert_black)
            mypageBtn.setImageResource(R.drawable.ic_mypage_black)
        }
        if(position == 1){
            homeBtn.setImageResource(R.drawable.ic_home_black)
            searchBtn.setImageResource(R.drawable.ic_search_blue)
            discountBtn.setImageResource(R.drawable.ic_discount_black)
            alertBtn.setImageResource(R.drawable.ic_alert_black)
            mypageBtn.setImageResource(R.drawable.ic_mypage_black)
        }
        if(position == 2){
            homeBtn.setImageResource(R.drawable.ic_home_black)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            discountBtn.setImageResource(R.drawable.ic_discount_blue)
            alertBtn.setImageResource(R.drawable.ic_alert_black)
            mypageBtn.setImageResource(R.drawable.ic_mypage_black)
        }
        if(position == 3){
            homeBtn.setImageResource(R.drawable.ic_home_black)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            discountBtn.setImageResource(R.drawable.ic_discount_black)
            alertBtn.setImageResource(R.drawable.ic_alert_blue)
            mypageBtn.setImageResource(R.drawable.ic_mypage_black)
        }
        if(position == 4){
            homeBtn.setImageResource(R.drawable.ic_home_black)
            searchBtn.setImageResource(R.drawable.ic_search_black)
            discountBtn.setImageResource(R.drawable.ic_discount_black)
            alertBtn.setImageResource(R.drawable.ic_alert_black)
            mypageBtn.setImageResource(R.drawable.ic_mypage_blue)
        }
    }

    // data 올려주기
    fun loadData(): MutableList<recyclerData>{
        val data:MutableList<recyclerData> = mutableListOf()

        // data들 올려주기 (변경필요!)
        val text1= "금융위원회"

        return data
    }


    inner class PageAdapter (fm: FragmentManager?):
        FragmentPagerAdapter(fm!!){
        override fun getCount(): Int {
            return 5
        }

        override fun getItem(position: Int): Fragment {
            return when(position){
                0->{
                    HomeFragment().apply {
                        arguments =Bundle().apply {
                            putInt("userId",this@RealMainActivity.userId)
                            putString("name",this@RealMainActivity.name)
                            putInt("totalAmount",this@RealMainActivity.totalAmount)
                            putInt("cashAmount",this@RealMainActivity.cashAmount)
                            putInt("financialAmount",this@RealMainActivity.financialAmount)
                            putInt("myAsset",this@RealMainActivity.myAsset)
                        }
                    }
                }
                1->{
                    SearchFragment().apply {
                        arguments = Bundle().apply {
                            putInt("userId",this@RealMainActivity.userId)
                            putString("name",this@RealMainActivity.name)
                            putInt("totalAmount",this@RealMainActivity.totalAmount)
                            putInt("cashAmount",this@RealMainActivity.cashAmount)
                            putInt("financialAmount",this@RealMainActivity.financialAmount)
                        }
                    }
                }
                2->{
                    DiscountFragment().apply {
                        arguments = Bundle().apply {
                            putInt("userId", this@RealMainActivity.userId)
                            putString("name", this@RealMainActivity.name)
                        }
                    }
                }
                3->{
                    AlertFragment().apply {
                        arguments = Bundle().apply {
                            putInt("userId",this@RealMainActivity.userId)
                            putString("name",this@RealMainActivity.name)
                        }
                    }
                }
                4->{
                    MypageFragment().apply {
                        arguments = Bundle().apply {
                            putInt("userId",this@RealMainActivity.userId)
                            putString("name",this@RealMainActivity.name)
                        }
                    }
                }
                else-> HomeFragment().apply {
                    arguments = Bundle().apply {
                        putInt("userId",this@RealMainActivity.userId)
                        putString("name",this@RealMainActivity.name)
                    }
                }
            }
        }
    }
}

