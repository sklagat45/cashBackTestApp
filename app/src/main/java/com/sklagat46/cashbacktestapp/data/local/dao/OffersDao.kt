package com.sklagat46.cashbacktestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.sklagat46.cashbacktestapp.data.local.model.Offers
import kotlinx.coroutines.flow.Flow

@Dao
interface OffersDao : CoroutineBaseDao<Offers> {
    @Query("SELECT * FROM Offers WHERE (strftime('%s',offerEndDate) - strftime('%s','now','localtime'))/60 >= 0 AND (strftime('%s',offerStartDate) - strftime('%s','now','localtime'))/60<=0 ORDER BY promotionDetailsRanking ASC")
    fun getOffers(): Flow<List<Offers>>
}