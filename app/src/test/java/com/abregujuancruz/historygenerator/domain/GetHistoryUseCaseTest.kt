package com.abregujuancruz.historygenerator.domain

import com.abregujuancruz.historygenerator.data.HistoryRepository
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetHistoryUseCaseTest {
    
    @RelaxedMockK
    private lateinit var repository: HistoryRepository
    private lateinit var getHistoryUseCase: GetHistoryUseCase
    
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getHistoryUseCase = GetHistoryUseCase(repository)
    }
    
    @Test
    fun `when the api return nothing then get values from database`() = runBlocking {
        //Given
        coEvery { repository.getAllHistoryDataFromApi() } returns emptyList()
        //When
        getHistoryUseCase()
        //Then
        coVerify(exactly = 0) { repository.clearHistoryData() }
        coVerify(exactly = 0) { repository.insertHistoryData(any()) }
        coVerify(exactly = 1) { repository.getAllHistoryDataFromDatabase() }
    }
    
    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val fakeDataList = listOf("Data1", "Data2", "Data3")
        val fakeHistoryList = listOf(HistoryDomain("FakeLabel", fakeDataList))
        coEvery { repository.getAllHistoryDataFromApi() } returns fakeHistoryList
        
        //When
        val fakeResponse = getHistoryUseCase()
        
        //Verify
        coVerify(exactly = 1) { repository.clearHistoryData() }
        coVerify(exactly = 1) { repository.insertHistoryData(any()) }
        coVerify(exactly = 0) { repository.getAllHistoryDataFromDatabase() }
        assert(fakeHistoryList == fakeResponse)
    }
}