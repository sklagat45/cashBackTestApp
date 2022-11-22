package com.sklagat46.cashbacktestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.ui.viewModels.OffersViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import com.sklagat46.cashbacktestapp.data.remote.model.Result
import com.sklagat46.cashbacktestapp.databinding.ActivityMainBinding
import com.sklagat46.cashbacktestapp.ui.adapters.BottomBarAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val offersViewModel: OffersViewModel by viewModel()
    private lateinit var pagerAdapter: BottomBarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadRemoteData()
        setUpViews()
    }


    private fun loadRemoteData(){
        offersViewModel.fetchRemoteOffers().onEach { loadingState->
            when(loadingState){
                is Result.Loading->{
                    Timber.d("Loading")
                }
                is Result.Success->{
                    Timber.d("Success")
                }
                is Result.Error->{
                    Timber.d("Error")
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun setUpViews() {
        binding.viewPager.offscreenPageLimit = 5
        pagerAdapter = BottomBarAdapter(supportFragmentManager)
        pagerAdapter.addFragments(HomeFragment())
        pagerAdapter.addFragments(OrdersFragment())
        pagerAdapter.addFragments(DocumentsFragment())
        pagerAdapter.addFragments(OffersFragment())
        pagerAdapter.addFragments(AccountFragment())
        binding.viewPager.adapter = pagerAdapter
        bottomNavBar()
    }

    private fun bottomNavBar() {
        binding.viewPager.currentItem = 3
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.m_home -> {
                    binding.viewPager.currentItem = 0
                }
                R.id.m_order -> {
                    binding.viewPager.currentItem = 1
                }
                R.id.m_document -> {
                    binding.viewPager.currentItem = 2
                }
                R.id.m_offers -> {
                    binding.viewPager.currentItem = 3
                }
                R.id.m_account -> {
                    binding.viewPager.currentItem = 4
                }
            }
            true
        }
    }
}