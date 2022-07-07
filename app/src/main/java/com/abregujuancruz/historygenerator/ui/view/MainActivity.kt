package com.abregujuancruz.historygenerator.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.abregujuancruz.historygenerator.databinding.ActivityMainBinding
import com.abregujuancruz.historygenerator.data.model.History
import com.abregujuancruz.historygenerator.ui.view.adapter.HistoryAdapter
import com.abregujuancruz.historygenerator.ui.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var historyList: ArrayList<History>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnGenerate.setOnClickListener {
            historyViewModel.getListOfHistories()
        }
        
        historyViewModel.visibility.observe(this) {
            binding.shimmerLayout.visibility = if (it) View.VISIBLE else View.GONE
            binding.rvHistory.visibility = if(it) View.GONE else View.VISIBLE
        }
        
        historyViewModel.historyData.observe(this) {
            if (it != null) {
                historyList = it
            }
            initRecyclerView(historyList)
        }
    }
    
    private fun initRecyclerView(historyList: ArrayList<History>) {
        binding.rvHistory.adapter = HistoryAdapter(historyList)
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
    }
}