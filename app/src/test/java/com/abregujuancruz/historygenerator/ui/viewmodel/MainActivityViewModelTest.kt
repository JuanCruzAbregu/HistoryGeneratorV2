package com.abregujuancruz.historygenerator.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abregujuancruz.historygenerator.domain.GetHistoryUseCase
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainActivityViewModelTest {
    
    @RelaxedMockK
    private lateinit var getHistoryUseCase: GetHistoryUseCase
    private lateinit var mainActivityViewModel: MainActivityViewModel
    
    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        mainActivityViewModel = MainActivityViewModel(getHistoryUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }
    
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `when view model is created at the first time get all data and set sorted description values`() =
        runTest {
            //Given
            val fakeDataList = listOf("Data1", "Data2", "Data3")
            val fakeHistoryList = listOf(
                HistoryDomain("Label1", fakeDataList),
                HistoryDomain("Label2", fakeDataList),
                HistoryDomain("Label3", fakeDataList)
            )
            
            coEvery { getHistoryUseCase() } returns fakeHistoryList
            
            //When
            mainActivityViewModel.getListOfHistories()
            
            //Then
            assert(mainActivityViewModel.historyData.value == fakeHistoryList)
            assert(mainActivityViewModel.descriptionList.value != fakeDataList)
        }
    
    @Test
    fun `if getHistoryUseCase return nothing keep the last value`() = runTest {
        //Given
        val fakeDataList = listOf("Data1", "Data2", "Data3")
        val fakeHistoryList = listOf(
            HistoryDomain("Label1", fakeDataList),
            HistoryDomain("Label2", fakeDataList),
            HistoryDomain("Label3", fakeDataList)
        )
        mainActivityViewModel.historyData.value = fakeHistoryList
        coEvery { getHistoryUseCase() } returns emptyList()
        
        //When
        getHistoryUseCase()
        
        //Then
        assert(mainActivityViewModel.historyData.value == fakeHistoryList)
        
    }
}