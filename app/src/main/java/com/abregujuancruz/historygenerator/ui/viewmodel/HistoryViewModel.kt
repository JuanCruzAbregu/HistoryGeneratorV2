package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.model.HistoryResponse
import com.abregujuancruz.historygenerator.network.APIService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryViewModel : ViewModel(){

    private val apiService = APIService()
    
    private val _historyData = MutableLiveData<HistoryResponse?>()
    val historyData : MutableLiveData<HistoryResponse?> get() = _historyData
    
    fun getListOfHistories(){
        viewModelScope.launch {
            val call : Call<HistoryResponse> = apiService.getHistories()
            call.enqueue(object : Callback<HistoryResponse>{
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