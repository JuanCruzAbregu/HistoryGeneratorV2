package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.data.model.History
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
    
    private val _historyData = MutableLiveData<ArrayList<History>?>()
    val historyData: MutableLiveData<ArrayList<History>?> get() = _historyData
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    fun getListOfHistories() {
        viewModelScope.launch {
            _visibility.value = true
            loadHistoriesUseCase().enqueue(object : Callback<ArrayList<History>> {
                override fun onResponse(
                    call: Call<ArrayList<History>>,
                    response: Response<ArrayList<History>>
                ) {
                    _historyData.value = response.body()
                    _visibility.value = false
                }
                override fun onFailure(call: Call<ArrayList<History>>, t: Throwable) {
                    _historyData.value = null
                }
            })
        }
    }
}