package com.river.supportconnection.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.river.supportconnection.Adapter.SearchAdapter
import com.river.supportconnection.Adapter.SearchAdapter2
import com.river.supportconnection.Adapter.SearchAdapter3
import com.river.supportconnection.R
import com.river.supportconnection.data.Search
import com.river.supportconnection.data.api.searchService
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.NumberFormat

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

    var search: Search? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userId by lazy { requireArguments().getInt("userId") }
        val name by lazy { requireArguments().getString("name") }
        val totalAmount by lazy { requireArguments().getInt("totalAmount") }
        val cashAmount by lazy { requireArguments().getInt("cashAmount")}
        val financialAmount by lazy { requireArguments().getInt("financialAmount")}

        val adapter1 = SearchAdapter()
        val adapter2 = SearchAdapter2()
        val adapter3 = SearchAdapter3()

        recycler1.adapter = adapter1
        recycler2.adapter = adapter2
        recycler3.adapter = adapter3

        recycler1.layoutManager = LinearLayoutManager(activity)
        recycler2.layoutManager = LinearLayoutManager(activity)
        recycler3.layoutManager = LinearLayoutManager(activity)

        val retrofit = Retrofit.Builder()
            .baseUrl(""+R.string.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val searchService = retrofit.create(searchService::class.java)
        searchService.getSearch(userId).enqueue(object : Callback<List<Search>>{
            override fun onResponse(call: Call<List<Search>>, response: Response<List<Search>>) {
                // Null Pointer Acception 원인이 되는 부분
                adapter1.searchlist.addAll(response.body() as List<Search>)
                adapter1.notifyDataSetChanged()

                adapter2.searchlist.addAll(response.body() as List<Search>)
                adapter2.notifyDataSetChanged()

                adapter3.searchlist.addAll(response.body() as List<Search>)
                adapter3.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Search>>, t: Throwable) {
                Log.e("searchfragment", t.message!!)
            }
        })






        fsearchtext_5.text = getNumberText(totalAmount.toString())
        fsearch_text8.text = getNumberText(cashAmount.toString())
        fsearch_text10.text = getNumberText(financialAmount.toString())
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
    private fun getNumberText(text: String): String {
        return if (text.length > 1) NumberFormat.getNumberInstance().format(text.replace(",", "").toDouble()) else text
    }
}