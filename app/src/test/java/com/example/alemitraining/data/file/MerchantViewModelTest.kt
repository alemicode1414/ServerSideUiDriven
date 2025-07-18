package com.example.alemitraining.data.file

import androidx.lifecycle.SavedStateHandle
import com.example.alemitraining.MainDispatcherRule
import com.example.alemitraining.data.datasource.remote.MerchantRepositoryImpl
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.ui.MerchantViewModel
import com.example.alemitraining.ui.model.UiState
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MerchantViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `test getMerchantDetails emits 3 UiState values`() = runTest {
        // Arrange
        val fakeRepository: MerchantRepositoryImpl = mockk()
        val savedStateHandle = SavedStateHandle(mapOf("12" to "dummy_merchant_id"))
        val viewModel = MerchantViewModel(fakeRepository, savedStateHandle)

        val stateList = mutableListOf<UiState<String>>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.uiState.toList(stateList)
        }

        // Act
        viewModel.getMerchantDetails()
        advanceUntilIdle()

        // Assert
        assertEquals(2, stateList.size)
        assertTrue(stateList[0] is UiState.Failure)
        assertEquals(stateList[1].getDataOrNull(), "12")
    }
}
