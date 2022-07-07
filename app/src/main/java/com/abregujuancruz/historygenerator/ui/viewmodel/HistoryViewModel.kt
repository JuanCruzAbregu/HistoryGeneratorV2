package com.abregujuancruz.historygenerator.ui.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.data.model.HistoryResponse
import com.abregujuancruz.historygenerator.domain.LoadHistoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val loadHistoriesUseCase: LoadHistoriesUseCase
) : ViewModel() {
    
    private val _historyData = MutableLiveData<HistoryResponse?>()
    val historyData: MutableLiveData<HistoryResponse?> get() = _historyData
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    fun getListOfHistories() {
        viewModelScope.launch {
            _visibility.value = true
            loadHistoriesUseCase().enqueue(object : Callback<HistoryResponse> {
                override fun onResponse(
                    call: Call<HistoryResponse>,
                    response: Response<HistoryResponse>
                ) {
                    _historyData.value = response.body()
                    _visibility.value = false
                }
                override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                    _historyData.value = null
                }
            })
        }
    }
}