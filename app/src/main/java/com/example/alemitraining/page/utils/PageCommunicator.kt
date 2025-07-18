package com.example.alemitraining.page.utils

open class PageCommunicator(
    val navigateToProductDetail: (productId: String) -> Unit,
    val navigateToDiscovery: (slug: String) -> Unit,
    val navigateToSearchAutoComplete: (String) -> Unit,
    val navigateToMerchantPage: (String) -> Unit,
    val navigateToCategoryPage: (String) -> Unit,
    val onBackClicked: () -> Unit
) : Communicator {

    constructor(pageCommunicator: PageCommunicator) : this(
        pageCommunicator.navigateToProductDetail,
        pageCommunicator.navigateToDiscovery,
        pageCommunicator.navigateToSearchAutoComplete,
        pageCommunicator.navigateToMerchantPage,
        pageCommunicator.navigateToCategoryPage,
        pageCommunicator.onBackClicked
    )
}