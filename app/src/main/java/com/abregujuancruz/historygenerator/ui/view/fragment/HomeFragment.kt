package com.abregujuancruz.historygenerator.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.databinding.FragmentHomeBinding
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import com.abregujuancruz.historygenerator.ui.view.composables.screen.HomeScreenComposable
import com.abregujuancruz.historygenerator.ui.viewmodel.HomeFragmentViewModel
import com.abregujuancruz.historygenerator.utils.setContentView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cviewHome.setContentView {
            val screenState: HomeComposableState by
            viewModel.homeComposableState.collectAsState(initial = FirstLoad)

            HomeScreenComposable(homeComposableState = screenState)
        }
    }
}