package com.river.supportconnection.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.river.supportconnection.R
import com.river.supportconnection.data.Search
import kotlinx.android.synthetic.main.searchrecycler.view.*

class SearchAdapter3: RecyclerView.Adapter<Holder4>() {
    var searchlist = mutableListOf<Search>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder4 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.searchrecycler, parent, false)
        return Holder4(view)
    }

    override fun onBindViewHolder(holder: Holder4, position: Int) {
        val search = searchlist[position]
        if(search.category == "보건"){
            holder.setSearch(search)
        }
    }

    override fun getItemCount(): Int {
        return searchlist.size
    }
}
class Holder4(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setSearch(search: Search){
        if (search.category=="보건") {
            itemView.recname.text= search.name
            itemView.recmoneny.text = search.amount.toString()
            itemView.recicon.setImageResource(R.mipmap.ic_go)
        }
    }
}