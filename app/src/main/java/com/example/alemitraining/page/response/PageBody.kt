package com.example.alemitraining.page.response

import com.example.alemitraining.page.utils.PageComposeItem

class PageBody(
    val rows: List<PageComposeItem>,
    val nextPageCursor: String?,
)