package com.abregujuancruz.historygenerator.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.abregujuancruz.historygenerator.databinding.ActivityHomeBinding
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import com.abregujuancruz.historygenerator.ui.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    //TODO: Add fragment fot switch to infoFragment
    
    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    private var listData: List<HistoryDomain> = emptyList()
    private var listRandom = ArrayList<String>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        historyViewModel.getListOfHistories()
        historyViewModel.descriptionList.observe(this){ listRandom = it }
        historyViewModel.historyData.observe(this) { listData = it }
    }
}