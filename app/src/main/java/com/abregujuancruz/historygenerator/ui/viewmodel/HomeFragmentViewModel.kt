package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.domain.GetHistoryUseCase
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    private var job: Job? = null

    private val _homeComposableState: MutableStateFlow<HomeComposableState> =
        MutableStateFlow(FirstLoad)
    val homeComposableState: StateFlow<HomeComposableState>
        get() = _homeComposableState

    private fun setHomeComposableState(){
        job?.cancel()
        job = viewModelScope.launch {
            _homeComposableState.value = HomeComposableModel(
                headerHomeBannerModel = HeaderHomeBannerModel(
                    generateHistory = { }
                ),
                horizontalShowcaseModel = HorizontalShowcaseModel(
                    startIcon = R.drawable.ic_baseline_android_24,
                    bannerList = emptyList()
                )
            )
        }
    }

    init {
        setHomeComposableState()
    }

}