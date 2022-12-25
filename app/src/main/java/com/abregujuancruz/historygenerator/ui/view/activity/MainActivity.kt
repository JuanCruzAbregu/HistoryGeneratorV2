package com.abregujuancruz.historygenerator.ui.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.databinding.ActivityMainBinding
import com.abregujuancruz.historygenerator.ui.view.fragment.HomeFragment
import com.abregujuancruz.historygenerator.ui.view.fragment.InfoFragment
import com.abregujuancruz.historygenerator.ui.viewmodel.MainActivityViewModel
import com.abregujuancruz.historygenerator.ui.viewmodel.MainActivityViewModel.BottomNavigationId
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            viewModel.setCurrentScreen(
                BottomNavigationId(
                    when (menuItem.itemId) {
                        R.id.nav_home -> R.id.nav_home
                        R.id.nav_info -> R.id.nav_info
                        else -> R.id.nav_home
                    }
                )
            )
            true
        }

        viewModel.currentBottomNavigationId.observe(this) { bottomNavigationConfig ->
            bottomNavigationConfig?.bottomNavSelectedId?.let {
                when (it.id) {
                    R.id.nav_home -> setSelectedScreen(HomeFragment(), it)
                    R.id.nav_info -> setSelectedScreen(InfoFragment(), it)
                    else -> throw RuntimeException("Error: BottomNavigationId")
                }
            }
        }
    }

    private fun setSelectedScreen(
        fragment: Fragment,
        bottomNavigationId: BottomNavigationId
    ) {
        supportFragmentManager.commit {
            replace(R.id.container, fragment)
        }
        binding.bottomNavigation.selectedItemId = bottomNavigationId.id
    }
}