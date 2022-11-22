package com.sklagat46.cashbacktestapp.data.remote.model

data class OfferResponseItem(
    val offerEndDate: String,
    val offerStartDate: String,
    val productBarcode: Long,
    val productCashBack: Int,
    val productId: Int,
    val productImage: String,
    val productName: String,
    val productSize: String,
    val promotionClaimLimit: Int,
    val promotionDescription: String,
    val promotionDetailsHotDealsIndicator: String,
    val promotionDetailsId: Int,
    val promotionDetailsRanking: Int,
    val promotionId: Int,
    val promotionStatus: String,
    val promotion_details_retailer_commission: Double
)