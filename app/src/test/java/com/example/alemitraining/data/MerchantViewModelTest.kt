package com.example.alemitraining.data

import androidx.lifecycle.SavedStateHandle
import com.example.alemitraining.MainDispatcherRule
import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.domain.model.PageModel
import com.example.alemitraining.page.response.PageBodyDto
import com.example.alemitraining.ui.MerchantViewModel
import com.example.alemitraining.ui.model.UiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MerchantViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: MerchantViewModel
    private lateinit var merchantRepository: MerchantRepository
    private val savedStateHandle = SavedStateHandle(mapOf("12" to "1"))

    private val fakeMerchantDetails = MerchantDetailsResponseDto(
        title = "",
        description = "",
        logoUrl = "",
        coverUrl = "",
        shareLink = "",
        pageBody = PageBodyDto(emptyList(), "")
    )

    @Before
    fun setUp() {
        merchantRepository = mockk()
    }

    @Test
    fun `when repository returns success, uiState should emit Success`() = runTest {
        val mList = mutableListOf<UiState<String>>()
        coEvery { merchantRepository.getMerchantDetails(any()) } returns Result.success(fakeMerchantDetails)
        viewModel = MerchantViewModel(merchantRepository, savedStateHandle)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.uiState.toList(mList)
        }

        viewModel.getMerchantDetails()
        // حالا بررسی کنیم مقدارها چی هستن
        assertEquals(listOf(
            UiState.Failure(RuntimeException()), // مقدار اولیه
            UiState.Loading,
            UiState.Success("1")
        ).size, mList.size)

        println(mList) // این بهت نشون می‌ده دقیقاً چه مقادیری دریافت کردی
    }

}
