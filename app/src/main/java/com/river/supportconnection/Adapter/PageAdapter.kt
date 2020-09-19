package com.river.supportconnection.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.river.supportconnection.Fragments.*

internal class PageAdapter (fm: FragmentManager?):
        FragmentPagerAdapter(fm!!){
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                HomeFragment()
            }
            1->{
                SearchFragment()
            }
            2->{
                DiscountFragment()
            }
            3->{
                AlertFragment()
            }
            4->{
                MypageFragment()
            }
            else-> HomeFragment()
        }
    }
}
