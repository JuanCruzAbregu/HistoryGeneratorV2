package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.data.model.HistoryResponse
import com.abregujuancruz.historygenerator.data.network.HistoryAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyAPI: HistoryAPI
) : ViewModel() {
    
    private val _historyData = MutableLiveData<HistoryResponse?>()
    val historyData: MutableLiveData<HistoryResponse?> get() = _historyData
    
    fun getListOfHistories() {
        viewModelScope.launch {
            val call: Call<HistoryResponse> = historyAPI.getHistories()
            call.enqueue(object : Callback<HistoryResponse> {
                override fun onResponse(
                    call: Call<HistoryResponse>,
                    response: Response<HistoryResponse>
                ) {
                    _historyData.value = response.body()
                }
                
                override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                    _historyData.value = null
                }
                
            })
        }
    }
    
    
}