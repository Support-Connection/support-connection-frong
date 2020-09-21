package com.river.supportconnection.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.fragment_alert.*
import java.text.NumberFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlertFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userId by lazy { requireArguments().getInt("userId") }
        val name by lazy { requireArguments().getString("name") }
        val supportRemain by lazy { requireArguments().getInt("supportRemain") }


        falert_text2.text=name + "님의"
        falert_text5.text= getNumberText(supportRemain.toString())

        falert_input_btn.setOnClickListener {
            //activity?.startActivity<SupportRemainActivity>(
                //"userId" to userId
            //)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlertFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String?) =
            AlertFragment().apply {
                val fragment=AlertFragment()
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