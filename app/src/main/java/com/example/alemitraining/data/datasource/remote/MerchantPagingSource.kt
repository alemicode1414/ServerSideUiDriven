package com.example.alemitraining.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.page.response.PageBody
import com.example.alemitraining.page.response.toPageBody
import com.example.alemitraining.page.utils.PageComposeItem

class MerchantPagingSource(
    private val pageBody: PageBody,
    private val merchantId: String,
    private val repository: MerchantRepository,
) : PagingSource<String, PageComposeItem>() {
    private var previusekey: String? = null
    private var nextKey: String? = null

    override fun getRefreshKey(state: PagingState<String, PageComposeItem>): String? {
        return nextKey
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PageComposeItem> {
        return if (previusekey == null) {
            handlePageSuccessResponse(pageBody)
        } else {
            repository.getMerchantDetails(merchantId).fold(
                onSuccess = {
                    handlePageSuccessResponse(it.pageBody.toPageBody())
                },
                onFailure = {
                    LoadResult.Error(it)
                }
            )
        }
    }

    fun handlePageSuccessResponse(pageBody: PageBody): LoadResult.Page<String, PageComposeItem> {
        previusekey = nextKey
        nextKey = pageBody.nextPageCursor
        return LoadResult.Page(
            data = pageBody.rows,
            prevKey = previusekey,
            nextKey = nextKey
        )
    }
}