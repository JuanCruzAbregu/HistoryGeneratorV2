package com.abregujuancruz.historygenerator.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.databinding.FragmentInfoBinding
import com.abregujuancruz.historygenerator.ui.view.composables.screen.info.InfoScreenComposable
import com.abregujuancruz.historygenerator.utils.setContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment(R.layout.fragment_info) {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cviewInfo.setContentView {
            InfoScreenComposable()
        }
    }
}