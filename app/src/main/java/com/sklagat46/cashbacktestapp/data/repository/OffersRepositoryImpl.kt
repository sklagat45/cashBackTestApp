package com.sklagat46.cashbacktestapp.data.repository

import com.sklagat46.cashbacktestapp.data.local.dao.OffersDao
import com.sklagat46.cashbacktestapp.data.local.model.Offers
import com.sklagat46.cashbacktestapp.data.remote.api.CashbackApis
import com.sklagat46.cashbacktestapp.data.remote.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException

internal class OffersRepositoryImpl(
        private val cashbackApis: CashbackApis,
        private val offersDao: OffersDao,
        private val isDispatcher: CoroutineDispatcher = Dispatchers.IO
    ) : OffersRepository {

        override suspend fun fetchCurrentOffers(): Result<Boolean> {
                return withContext(isDispatcher) {
                        try {
                                Result.Loading
                                val result = cashbackApis.getCurrentOffers()
                                if (result.isSuccessful) {
                                        result.body()?.forEach { remoteOffers ->
                                                Timber.d("remoteOffers--" + remoteOffers.productName)
                                                remoteOffers.apply {
                                                        val offers = Offers(
                                                                remoteOffers.promotionDetailsId,
                                                                remoteOffers.productId,
                                                                remoteOffers.offerEndDate,
                                                                remoteOffers.offerStartDate,
                                                                remoteOffers.productBarcode,
                                                                remoteOffers.productCashBack,
                                                                remoteOffers.productImage,
                                                                remoteOffers.productName,
                                                                remoteOffers.productSize,
                                                                remoteOffers.promotionClaimLimit,
                                                                remoteOffers.promotionDescription,
                                                                remoteOffers.promotionDetailsHotDealsIndicator,
                                                                remoteOffers.promotionDetailsRanking,
                                                                remoteOffers.promotionId,
                                                                remoteOffers.promotionStatus,
                                                                remoteOffers.promotion_details_retailer_commission
                                                        )
                                                        offersDao.insertAsync(offers)

                                                }
                                        }
                                        Result.Success(true)
                                } else {
                                        Result.Success(false)
                                        Result.Error(Exception(result.errorBody().toString()))
                                }
                        } catch (e: IOException) {
                                Result.Error(Exception("Error Occurred"))
                                e.printStackTrace()
                                Timber.e(e)
                        }
                        Result.Success(false)
                }
        }

        override fun getCurrentOffers(): Flow<List<Offers>> {
                return offersDao.getOffers()
        }

}

