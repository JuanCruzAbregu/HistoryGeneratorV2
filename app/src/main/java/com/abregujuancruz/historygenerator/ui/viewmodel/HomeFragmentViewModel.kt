package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HomeFragmentViewModel @Inject constructor() : ViewModel() {

    private val _homeComposableState: MutableStateFlow<HomeComposableState> =
        MutableStateFlow(FirstLoad)
    val homeComposableState: StateFlow<HomeComposableState>
        get() = _homeComposableState

}