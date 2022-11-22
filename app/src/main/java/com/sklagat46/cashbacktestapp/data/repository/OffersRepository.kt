package com.sklagat46.cashbacktestapp.data.repository

import com.sklagat46.cashbacktestapp.data.local.model.Offers
import kotlinx.coroutines.flow.Flow
import com.sklagat46.cashbacktestapp.data.remote.model.Result



interface OffersRepository {
    suspend fun fetchCurrentOffers(): Result<Boolean>
    fun getCurrentOffers(): Flow<List<Offers>>
}