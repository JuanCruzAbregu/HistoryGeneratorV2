package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

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