package com.abregujuancruz.historygenerator.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abregujuancruz.historygenerator.databinding.ItemLayoutBinding

class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    
    private val binding = ItemLayoutBinding.bind(view)
    
    fun bind(label: String, description: String) {
        binding.tvLabel.text = label
        binding.tvDescription.text = description

    }
}