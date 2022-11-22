package com.sklagat46.cashbacktestapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.databinding.FragmentOffersBinding
import com.sklagat46.cashbacktestapp.ui.adapters.OffersAdapter
import com.sklagat46.cashbacktestapp.ui.viewModels.OffersViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


class OffersFragment : Fragment(R.layout.fragment_offers) {
    private var binding: FragmentOffersBinding? = null
    private lateinit var offersAdapter: OffersAdapter
    private val offersViewModel: OffersViewModel by viewModel()

    private var date:String= ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOffersBinding.bind(view)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        getCurrentDate()
        fetchRemoteOffers()
        setUpRv()
        fetchAndDisplayOffers()

    }

    private fun getCurrentDate(){
        val currentDate: Date = Calendar.getInstance().getTime()
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        date= df.format(currentDate)
    }
    private fun fetchAndDisplayOffers() {
        offersViewModel.getLocalOffers().onEach { offersList ->
            if (offersList.isNotEmpty()) {
                offersAdapter.submitList(offersList)
            } else {
                Timber.d("Your Offers List is Empty..")
            }
        }.launchIn(lifecycleScope)
    }

    private fun fetchRemoteOffers() {
        offersViewModel.fetchRemoteOffers()
    }

    private fun setUpRv() {
        val manager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding?.rvOffers?.layoutManager = manager
        offersAdapter = OffersAdapter(requireContext())
        binding?.rvOffers?.adapter = offersAdapter
    }
}