package com.sklagat46.cashbacktestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.sklagat46.cashbacktestapp.data.local.model.Offers
import kotlinx.coroutines.flow.Flow

@Dao
interface OffersDao : CoroutineBaseDao<Offers> {
    @Query("SELECT * FROM Offers WHERE offerEndDate >= :dateString ORDER BY promotionDetailsRanking ASC")
    fun getOffers(dateString:String): Flow<List<Offers>>
}