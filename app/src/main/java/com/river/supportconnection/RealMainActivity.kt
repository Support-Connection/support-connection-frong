package com.river.supportconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.river.supportconnection.Adapter.CustomAdapter
import com.river.supportconnection.Adapter.PageAdapter
import com.river.supportconnection.Fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_real_main.*
import kotlinx.android.synthetic.main.fragment_discount.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity

class RealMainActivity : AppCompatActivity() {
    private lateinit var homeBtn: ImageButton
    private lateinit var searchBtn: ImageButton
    private lateinit var discountBtn: ImageButton
    private lateinit var alertBtn: ImageButton
    private lateinit var mypageBtn: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPageAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)

        // 기본 data
        val name=intent.getStringExtra("name")
        val birth=intent.getStringExtra("birth")
        val sex=intent.getStringExtra("sex")

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
            fhome_text1.text = name
            mViewPager.currentItem = 0
            // 두번째 Fragment
            fhome_btn2.setOnClickListener {
                mViewPager.currentItem = 1
            }
            // 세번째 Fragment
            fhome_btn3.setOnClickListener {
                fdiscount_text2.text= name+"님"
                // 변경 필요 <1> 내용 입력 받으면 fragment_discount 열어주기
                startActivity<Jasaninput_activity>()
            }
        }

        searchBtn.setOnClickListener {
            mViewPager.currentItem = 1
        }

        discountBtn.setOnClickListener{
            mViewPager.currentItem = 2
            fdiscount_text2.text= name+"님"

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
}