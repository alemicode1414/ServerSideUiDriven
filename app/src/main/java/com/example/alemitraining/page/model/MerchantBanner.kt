package com.example.alemitraining.page.model

import androidx.compose.runtime.Composable
import com.example.alemitraining.designSystem.MerchantHorizontalBannerWidget
import com.example.alemitraining.page.utils.DiscoveryCommunicable
import com.example.alemitraining.page.utils.PageCommunicator
import com.example.alemitraining.page.utils.PageComposeItem

class MerchantBanner(
    val id: String,
    val title: String,
    val slug: String,
    val merchantImageUrl: String,
    val images: List<String>,
) : PageComposeItem, DiscoveryCommunicable {

    var onItemClicked: () -> Unit = {}

    override fun setCommunicator(communicator: PageCommunicator) {
        onItemClicked = { communicator.navigateToMerchantPage(slug) }
    }

    @Composable
    override fun ComposeView() {
        MerchantHorizontalBannerWidget(merchantBanner = this)
    }

    override fun getItemId(metadata: String): String = id
}

enum class MerchantBannerStyle {
    HORIZONTAL,
    SQUARE
}