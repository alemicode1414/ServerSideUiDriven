package com.example.alemitraining.domain.model

import androidx.paging.PagingData
import com.example.alemitraining.page.response.PageBody
import com.example.alemitraining.page.response.PageBodyDto
import com.example.alemitraining.page.utils.PageComposeItem
import kotlinx.coroutines.flow.Flow

data class PageModel(
    val pageBodyDto: Flow<PagingData<PageComposeItem>>
)