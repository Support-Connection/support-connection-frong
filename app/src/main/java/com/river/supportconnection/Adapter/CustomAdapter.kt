package com.river.supportconnection.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.river.supportconnection.R
import com.river.supportconnection.RecyclerActivity
import com.river.supportconnection.recyclerData
import kotlinx.android.synthetic.main.fdc_recycler.view.*

class CustomAdapter : RecyclerView.Adapter<Holder>() {
    // data
    var listData = mutableListOf<recyclerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fdc_recycler,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
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
            val intent = Intent(itemView.context,RecyclerActivity::class.java)
            // icon 관련 작성 필요
            intent.putExtra("institution",itemView.recycler_text1.text)
            intent.putExtra("specific",itemView.recycler_text2.text)
            intent.putExtra("rate",itemView.recycler_text3.text)
            intent.putExtra("saving",itemView.recycler_text4.text)
            itemView.context.startActivity(intent)
        }
    }
    fun setData(data:recyclerData){
        // icon 설정 찾아보기
        itemView.recycler_text1.text=data.institution
        itemView.recycler_text2.text=data.specific
        itemView.recycler_text3.text=data.rate
        itemView.recycler_text4.text=data.saving
    }
}