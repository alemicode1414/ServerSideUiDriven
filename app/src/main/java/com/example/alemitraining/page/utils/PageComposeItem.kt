package com.example.alemitraining.page.utils

const val MAX_LINE_SPAN = -1

interface PageComposeItem : PanjereComposeItem {

    fun getSpanCount(): Int = MAX_LINE_SPAN

    fun getItemId(metadata: String = ""): String
}