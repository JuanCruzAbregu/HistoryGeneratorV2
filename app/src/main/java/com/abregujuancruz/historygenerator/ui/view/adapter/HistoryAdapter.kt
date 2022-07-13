package com.abregujuancruz.historygenerator.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain


class HistoryAdapter(private val dataList: List<HistoryDomain?>, private val descriptionList : ArrayList<String>) :
    RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HistoryViewHolder(
            layoutInflater.inflate
                (R.layout.item_layout, parent, false)
        )
    }
    
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = dataList[position]
        val description = descriptionList[position]
        if (history != null) {
            holder.bind(history.label, description)
        }
    }
    
    override fun getItemCount(): Int = dataList.size
    
    
}