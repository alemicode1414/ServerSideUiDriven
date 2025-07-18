package com.example.alemitraining.page.response

import com.example.alemitraining.data.model.response.toSubCategoryList
import com.example.alemitraining.page.utils.PageComposeItem
import com.google.gson.annotations.SerializedName

class PageBodyDto(
    @SerializedName("rows") val rows: List<PageRowDto>,
    @SerializedName("nextPageCursor") val nextPageCursor: String?
)

fun PageBodyDto.toPageBody(): PageBody {
    return PageBody(
        rows.toPanjereComposeItems(),
        nextPageCursor.takeIf { it.isNullOrEmpty().not() }
    )
}

fun List<PageRowDto>.toPanjereComposeItems(): List<PageComposeItem> {
    val items = mutableListOf<PageComposeItem>()
    this.forEach { item ->
        with(item) {
            when {
                subCategoryList != null -> items.add(subCategoryList.toSubCategoryList())

            }
        }
    }
    return items
}