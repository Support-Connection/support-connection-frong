package com.river.supportconnection.Fragments

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.internal.ContextUtils.getActivity
import com.river.supportconnection.*
import kotlinx.android.synthetic.main.activity_real_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    // private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val name = arguments?.getString(ARG_NAME)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name by lazy { requireArguments().getString("name") }
        val totalAmount by lazy { requireArguments().getInt("totalAmount") }
        val cashAmount by lazy { requireArguments().getInt("cashAmount")}
        val financialAmount by lazy { requireArguments().getInt("financialAmount")}
        val myAsset by lazy { requireArguments().getInt("myAsset") }

        fhome_text1.text=name
        fhome_text3.text=totalAmount.toString()
        fhome_text9.text=cashAmount.toString()
        fhome_text12.text=financialAmount.toString()
        fhome_text16.text=myAsset.toString()

        fhome_btn2.setOnClickListener {
            (activity as RealMainActivity).mViewpager.currentItem = 1
        }
        fhome_btn3.setOnClickListener {
            (activity as RealMainActivity).mViewpager.currentItem = 2
        }
        //fhome_icon8.setOnClickListener {
            //activity?.startActivity<Jasaninput_activity>()
        //}
    }
    companion object {
        // private const val ARG_NAME="name"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters

        @JvmStatic
        fun newInstance(name: String?) =
            HomeFragment().apply {
                val fragment=HomeFragment()
                arguments = Bundle().apply {
                //    putString(ARG_NAME, name)
            }
                // fragment.arguments = bundle
                // return fragment
            }
    }

}