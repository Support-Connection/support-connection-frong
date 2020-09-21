package com.river.supportconnection.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.river.supportconnection.*
import com.river.supportconnection.data.SupportDetail
import com.river.supportconnection.data.api.SupportDetailService
import com.river.supportconnection.data.recyclerData
import com.river.supportconnection.ui.RecyclerActivity
import com.river.supportconnection.ui.data
import kotlinx.android.synthetic.main.fdc_recycler.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomAdapter() : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<recyclerData>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fdc_recycler,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.e("listData", listData.toString())
        val data = listData.get(position)
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    init{
        itemView.setOnClickListener {

            val retrofit = Retrofit.Builder()
                .baseUrl(""+R.string.base_url)
                .addConverterFactory(GsonConverterFactory.create()).build()

            var support_id = itemView.recycler_text7.text.toString().toInt()

            val supportDetailService: SupportDetailService = retrofit.create(
                SupportDetailService::class.java)
            supportDetailService.getSupport(support_id).enqueue(object: Callback<SupportDetail> {
                override fun onResponse(call: Call<SupportDetail>, response: Response<SupportDetail>) {
                    Log.e("sd", response.body().toString())
                    var sd: SupportDetail? = response.body()

                    val intent = Intent(itemView.context,
                        RecyclerActivity::class.java)

                    intent.putExtra("supportId", itemView.recycler_text7.text)
                    intent.putExtra("institution",itemView.recycler_text1.text)
                    intent.putExtra("specific",itemView.recycler_text2.text)
                    intent.putExtra("rate",itemView.recycler_text4.text)
                    intent.putExtra("saving",itemView.recycler_text6.text)
                    intent.putExtra("amount", sd?.amount.toString())
                    intent.putExtra("qualification", sd?.qualification.toString())
                    intent.putExtra("info", sd?.info.toString())
                    intent.putExtra("applyInfo", sd?.applyInfo.toString())
                    intent.putExtra("requiredDocuments", sd?.requiredDocuments.toString())


                    itemView.context.startActivity(intent)

                    Log.e("support", data.toString())

                }

                override fun onFailure(call: Call<SupportDetail>, t: Throwable) {
                    Log.e("discount", t.message!!)
                }
            })

        }
    }
    fun setData(data: recyclerData){
        itemView.recycler_text7.text = data.supportId.toString()
        itemView.recycler_text1.text=data.institution
        itemView.recycler_text2.text=data.specific
        itemView.recycler_text4.text=data.rate.toString()
        itemView.recycler_text6.text=data.saving.toString() + "원"
    }
}