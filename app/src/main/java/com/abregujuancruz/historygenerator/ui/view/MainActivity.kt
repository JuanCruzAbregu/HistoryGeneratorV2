package com.abregujuancruz.historygenerator.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.abregujuancruz.historygenerator.databinding.ActivityMainBinding
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import com.abregujuancruz.historygenerator.ui.view.adapter.HistoryAdapter
import com.abregujuancruz.historygenerator.ui.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var listData: List<HistoryDomain> = emptyList()
    private var number: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        historyViewModel.onCreate()
        historyViewModel.historyData.observe(this) { listData = it }
        historyViewModel.number.observe(this) { number = it }
        historyViewModel.visibility.observe(this) {
            binding.shimmerLayout.visibility = if (it) View.VISIBLE else View.GONE
            binding.rvHistory.visibility = if (it) View.GONE else View.VISIBLE
        }
        
        binding.btnGenerate.setOnClickListener {
            historyViewModel.getListOfHistories()
            initRecyclerView(listData, number)
        }
    }
    
    private fun initRecyclerView(historyList: List<HistoryDomain>, value: Int) {
        binding.rvHistory.adapter = HistoryAdapter(historyList, value)
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
    }
}