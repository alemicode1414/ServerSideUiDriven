package com.example.alemitraining.page.model

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alemitraining.designSystem.SubCategoryItemWidget
import com.example.alemitraining.page.utils.DiscoveryCommunicable
import com.example.alemitraining.page.utils.PageCommunicator
import com.example.alemitraining.page.utils.PageComposeItem

class SubCategoryItem(
    private val title: String,
    private val imageUrl: String,
    private val slug: String,
) : PageComposeItem, DiscoveryCommunicable {
    override fun getItemId(metadata: String): String = slug + title + metadata

    var onCategoryClicked: (String) -> Unit = {}

    @Composable
    override fun ComposeView() {
        SubCategoryItemWidget(
            modifier = Modifier.width(SUB_CATEGORY_ITEM_WIDTH.dp),
            title = title,
            imageUrl = imageUrl,
            slug = slug,
            onCategoryClicked = onCategoryClicked
        )
    }

    override fun setCommunicator(communicator: PageCommunicator) {
        onCategoryClicked = communicator.navigateToCategoryPage
    }

    override fun getSpanCount(): Int = 12

    companion object {

        const val SUB_CATEGORY_ITEM_WIDTH = 160
    }
}