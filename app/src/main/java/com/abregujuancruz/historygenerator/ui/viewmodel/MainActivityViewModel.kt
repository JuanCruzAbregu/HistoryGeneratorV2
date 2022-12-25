package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.domain.GetHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {
    
    private val _historyData = MutableLiveData<List<HistoryEntity>>()
    val historyData: MutableLiveData<List<HistoryEntity>> get() = _historyData
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    private val _descriptionList = MutableLiveData<ArrayList<String>>()
    val descriptionList: LiveData<ArrayList<String>> get() = _descriptionList

    private val _bottomNavigationId: MutableLiveData<BottomNavigationId> =
        MutableLiveData()

    val currentBottomNavigationId: LiveData<BottomNavigationConfig?> =
        MediatorLiveData<BottomNavigationConfig?>().apply {
            addSource(_bottomNavigationId) { navId ->
                value = navId?.let {
                    BottomNavigationConfig(it)
                }
            }
        }
    
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

    private fun setRandomDescription(result: List<HistoryEntity>): ArrayList<String> {
        val randomList = ArrayList<String>()
        for (items in result) {
            randomList.add(items.data.random())
        }
        return randomList
    }

    fun setCurrentScreen(currentScreen: BottomNavigationId) {
        if (_bottomNavigationId.value != currentScreen) {
            _bottomNavigationId.value = currentScreen
        }
    }

    data class BottomNavigationConfig(
        val bottomNavSelectedId: BottomNavigationId
    )

    @JvmInline
    value class BottomNavigationId(val id: Int)
    
}