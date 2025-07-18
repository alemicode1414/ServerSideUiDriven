package com.example.alemitraining.data

import com.example.alemitraining.data.datasource.remote.MerchantRemoteDataSource
import com.example.alemitraining.data.datasource.remote.MerchantRepositoryImpl
import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.page.response.PageBodyDto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MerchantRepositoryTest {

    private lateinit var merchantRepository: MerchantRepository
    private lateinit var dataSource: MerchantRemoteDataSource

    @Before
    fun setUp() {
        dataSource = mockk()
        merchantRepository = MerchantRepositoryImpl(dataSource)
    }

    @Test
    fun `getPageBody returns success if dataSource get data`() = runTest {
        val merchantId = "1"
        val cursor = "11"
        val expectedResult = PageBodyDto(
            rows = emptyList(),
            nextPageCursor = "2"
        )
        coEvery {
            dataSource.getPageBody(
                any(),
                any()
            )
        } returns Result.success(expectedResult)
        val result = merchantRepository.getPageBody(merchantId, cursor)
        assertEquals(result.getOrNull(), Result.success(expectedResult))
    }


    @Test
    fun `getPageBody returns failed if dataSource get exception`() = runTest {
        val merchantId = "1"
        val cursor = "11"
        val expectedResult: Throwable = RuntimeException("Server Error")
        coEvery {
            dataSource.getPageBody(
                any(),
                any()
            )
        } returns Result.failure(expectedResult)

        val result = merchantRepository.getPageBody(merchantId, cursor)
        result.onFailure { throwable ->
            assertEquals(throwable, expectedResult)
        }
    }
}