package com.river.supportconnection.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.river.supportconnection.*
import com.river.supportconnection.ui.Jasaninput_activity
import com.river.supportconnection.ui.LoanActivity
import kotlinx.android.synthetic.main.fragment_discount.*
import org.jetbrains.anko.startActivity
import java.text.NumberFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [DiscountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiscountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: Int? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userId by lazy { requireArguments().getInt("userId") }
        val name by lazy { requireArguments().getString("name") }
        val interestRate by lazy { requireArguments().getString("interestRate") }
        val creditRate by lazy { requireArguments().getInt("creditRate") }
        val annualIncome by lazy { requireArguments().getInt("annualIncome") }
        val myAsset by lazy { requireArguments().getInt("myAsset") }
        val currentInterest by lazy { requireArguments().getInt("currentInterest") }
        val reduceInterest by lazy { requireArguments().getInt("reduceInterest") }

        fdiscount_text2.setText(name)
        fdiscounttext_5.setText(interestRate + "%")

        fdiscount_text7.setText(creditRate.toString())

        if(interestRate.toString().toDouble() > 5){
            fdiscount_text10.setText(getNumberText(480000.toString()))
            fdiscount_text11.setText(getNumberText(420000.toString()))
        }else {

            fdiscount_text10.setText(getNumberText(currentInterest.toString()))
            fdiscount_text11.setText(getNumberText(reduceInterest.toString()))
            fdiscount_text14.setText(annualIncome.toString())
            fdiscount_text17.setText(myAsset.toString())

        }

        button2.setOnClickListener {
            activity?.startActivity<Jasaninput_activity>(
            )
        }

        fdiscount_btn1.setOnClickListener {
            activity?.startActivity<LoanActivity>(
                "userId" to userId
            )
        }




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiscountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String?) =
            DiscountFragment().apply {
                val fragment=DiscountFragment()
                arguments = Bundle().apply {
                    //    putString(ARG_NAME, name)
                }
                // fragment.arguments = bundle
                // return fragment
            }
    }
    private fun getNumberText(text: String): String {
        return if (text.length > 1) NumberFormat.getNumberInstance().format(text.replace(",", "").toDouble()) else text
    }

}