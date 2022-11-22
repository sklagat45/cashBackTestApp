package com.sklagat46.cashbacktestapp.data.local.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*


@Entity(indices = [Index(value = ["promotionDetailsId"], unique = true)])
data class Offers(
    @PrimaryKey()
    val promotionDetailsId: Int?,
    val productId: Int,
    val offerEndDate: String?,
    val offerStartDate: String?,
    val productBarcode: Long?,
    val productCashBack: Int?,
    val productImage: String?,
    val productName: String?,
    val productSize: String?,
    val promotionClaimLimit: Int?,
    val promotionDescription: String?,
    val promotionDetailsHotDealsIndicator: String?,
    val promotionDetailsRanking: Int?,
    val promotionId: Int?,
    val promotionStatus: String?,
    val promotion_details_retailer_commission: Double?
)