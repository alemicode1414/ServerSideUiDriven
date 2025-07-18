package com.example.alemitraining.page.model

import androidx.compose.runtime.Composable
import com.example.alemitraining.designSystem.SubcategoryWidget
import com.example.alemitraining.page.utils.DiscoveryCommunicable
import com.example.alemitraining.page.utils.PageCommunicator
import com.example.alemitraining.page.utils.PageComposeItem

class SubCategoryList(
    val categoryItems: List<SubCategoryItem>
) : PageComposeItem, DiscoveryCommunicable {
    override fun getItemId(metadata: String): String = categoryItems.hashCode().toString()


    @Composable
    override fun ComposeView() {
        SubcategoryWidget(subCategoryList = this)
    }

    override fun setCommunicator(communicator: PageCommunicator) {
        categoryItems.forEach { it.setCommunicator(communicator) }
    }

}