package com.sklagat46.cashbacktestapp.data.remote.api

import com.sklagat46.cashbacktestapp.data.remote.model.OfferResponse
import retrofit2.Response
import retrofit2.http.GET


interface CashbackApis {
    @GET("product_offers.json")
    suspend fun getCurrentOffers(): Response<OfferResponse>

}