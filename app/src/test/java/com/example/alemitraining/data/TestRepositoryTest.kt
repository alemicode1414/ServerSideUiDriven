package com.example.alemitraining.data

import com.example.alemitraining.TestRepository
import com.example.alemitraining.ui.model.UiState
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class TestRepositoryTest {

    @Test
    fun testRepo() = runTest {
        val repository = TestRepository(StandardTestDispatcher(testScheduler))
        val mList = mutableListOf<UiState<String>>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            repository.uiState.toList(mList)
        }

        advanceUntilIdle()

        assertEquals(3, mList.size)
        // Failure → Testt → Success
    }
}