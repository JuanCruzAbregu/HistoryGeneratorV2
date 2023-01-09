package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.historygenerator.domain.GetHistoryUseCase
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.EmptyHomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel
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

    private val _historyData: MutableStateFlow<List<HistoryDomain>> =
        MutableStateFlow(emptyList())

    init {
        setHomeComposableState()
    }

    private fun setHomeComposableState() {
        job?.cancel()
        job = viewModelScope.launch {
            _homeComposableState.value = buildHomeComposableModel()
        }
    }

    private fun buildHomeComposableModel(): HomeComposableState {
        return if (_historyData.value.isEmpty()) {
            EmptyHomeComposableModel(
                headerHomeBannerModel = HeaderHomeBannerModel(
                    generateHistory = { getListOfHistories() }
                )
            )
        } else {
        return HomeComposableModel(
            headerHomeBannerModel = HeaderHomeBannerModel(
                //generateHistory = { getListOfHistories() }
                generateHistory = {  }

            ),
            horizontalShowcaseModel = HorizontalShowcaseModel(
                bannerList = buildHorizontalBanner(_historyData.value)
            )
        )
        }
    }

    private fun buildHorizontalBanner(
        banners: List<HistoryDomain>
    ): List<IdeasRectangleBannerModel> =
        banners.map { bannerList ->
            IdeasRectangleBannerModel(
                label = bannerList.label,
                description = bannerList.data.random()
            )
        }

    private fun refresh() {
        setHomeComposableState()
    }

    private fun getListOfHistories() {
        viewModelScope.launch {
            val result = getHistoryUseCase()
            if (result.isNotEmpty()) {
                _historyData.value = result
            }
            refresh()
        }
    }
}
