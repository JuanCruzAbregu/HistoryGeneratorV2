package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.domain.GetHistoryUseCase
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {
    
    private val _historyData = MutableLiveData<List<HistoryDomain>>()
    val historyData: MutableLiveData<List<HistoryDomain>> get() = _historyData
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    private val _descriptionList = MutableLiveData<ArrayList<String>>()
    val descriptionList: LiveData<ArrayList<String>> get() = _descriptionList
    
    fun getListOfHistories() {
        viewModelScope.launch {
            _visibility.value = true
            val result = getHistoryUseCase()
            if (result.isNotEmpty()) {
                _historyData.value = result
                _descriptionList.value = setRandomDescription(result)
                _visibility.value = false
            }
        }
    }

    private fun setRandomDescription(result: List<HistoryDomain>): ArrayList<String> {
        val randomList = ArrayList<String>()
        for (items in result) {
            randomList.add(items.data.random())
        }
        return randomList
    }
    
}