package com.example.alemitraining.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.alemitraining.data.datasource.remote.MerchantPagingSource
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.domain.model.PageModel
import com.example.alemitraining.page.response.PageBody
import com.example.alemitraining.page.response.toPageBody
import com.example.alemitraining.ui.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MerchantViewModel @Inject constructor(
    private val merchantDetailsRepository: MerchantRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<PageModel>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()
    val merchantId = savedStateHandle.getStateFlow("12", "").value

    init {
        viewModelScope.launch {
            getMerchantDetails()
        }
    }

    private suspend fun getMerchantDetails() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            merchantDetailsRepository.getMerchantDetails(merchantId).fold(
                onSuccess = {
                    val pager = productPagerFlow(pageBody = it.pageBody.toPageBody())
                    _uiState.value = UiState.Success(PageModel(pager))
                },
                onFailure = {
                    _uiState.value = UiState.Failure(it)
                }
            )
        }
    }


    private fun productPagerFlow(
        pageBody: PageBody
    ) = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {
            MerchantPagingSource(
                pageBody = pageBody,
                merchantId = merchantId,
                repository = merchantDetailsRepository
            )
        }
    ).flow
}