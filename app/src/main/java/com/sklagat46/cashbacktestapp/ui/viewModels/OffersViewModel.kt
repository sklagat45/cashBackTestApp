package com.sklagat46.cashbacktestapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sklagat46.cashbacktestapp.data.local.model.Offers
import com.sklagat46.cashbacktestapp.data.remote.model.OfferResponse
import com.sklagat46.cashbacktestapp.data.remote.model.OfferResponseItem
import com.sklagat46.cashbacktestapp.data.repository.OffersRepository
import com.sklagat46.cashbacktestapp.data.remote.model.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext


class OffersViewModel(
    private val offersRepository: OffersRepository
) :
    ViewModel(),
    CoroutineScope {

    private val job = Job()
    private var offersResp: OfferResponse? = null

    private var _OfferList = MutableLiveData<List<Offers>>()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job
    val showLoading = MutableLiveData<Boolean>()
    val responseOffer = MutableLiveData<OfferResponseItem>()
    val offerList: LiveData<List<Offers>> = _OfferList


    init {
        fetchRemoteOffers()
    }

    fun fetchRemoteOffers() = flow {
        emit(Result.Loading)
        emit(offersRepository.fetchCurrentOffers())
    }

    fun getLocalOffers(): Flow<List<Offers>> {
        return offersRepository.getCurrentOffers()
    }


}