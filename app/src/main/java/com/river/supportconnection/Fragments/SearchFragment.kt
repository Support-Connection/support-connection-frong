package com.river.supportconnection.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.river.supportconnection.R
import kotlinx.android.synthetic.main.fragment_search.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name by lazy { requireArguments().getString("name") }
        val totalAmount by lazy { requireArguments().getInt("totalAmount") }
        val cashAmount by lazy { requireArguments().getInt("cashAmount")}
        val financialAmount by lazy { requireArguments().getInt("financialAmount")}

        fsearchtext_5.text = totalAmount.toString()
        fsearch_text8.text = cashAmount.toString()
        fsearch_text10.text = financialAmount.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String?) =
            SearchFragment().apply {
                val fragment=SearchFragment()
                arguments = Bundle().apply {
                    //    putString(ARG_NAME, name)
                }
                // fragment.arguments = bundle
                // return fragment
            }
    }
}