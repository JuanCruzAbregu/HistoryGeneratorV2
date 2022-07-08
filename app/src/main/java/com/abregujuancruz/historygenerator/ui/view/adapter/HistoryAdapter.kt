package com.abregujuancruz.historygenerator.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.data.model.History

    class HistoryAdapter(private val dataList: ArrayList<History>) :
    RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HistoryViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }
    
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = dataList[position]
        holder.bind(history.label, history.data.random())
    }
    
    override fun getItemCount(): Int = dataList.size
}