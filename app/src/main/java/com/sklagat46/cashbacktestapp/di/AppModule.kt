package com.sklagat46.cashbacktestapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Database
import androidx.room.Room
import com.sklagat46.cashbacktestapp.data.local.dataSource.OffersDatabase
import com.sklagat46.cashbacktestapp.data.remote.api.CashbackApis
import com.sklagat46.cashbacktestapp.data.repository.OffersRepository
import com.sklagat46.cashbacktestapp.data.repository.OffersRepositoryImpl
import com.sklagat46.cashbacktestapp.ui.viewModels.OffersViewModel
import com.sklagat46.cashbacktestapp.utils.Constants
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { createNetworkClient(Constants.BASE_URL_RELEASE) }
    single { (get() as? Retrofit)?.create(CashbackApis::class.java) }

    single {
        Room.databaseBuilder(androidContext(), OffersDatabase::class.java,OffersDatabase.DATABASE_NAME )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<OffersDatabase>().offersDao
    }

    factory<OffersRepository> {
        OffersRepositoryImpl(
            cashbackApis = get(),
            offersDao = get()
        )
    }

    viewModel {
        OffersViewModel(offersRepository = get())
    }

    single {
        androidApplication().getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)
    }

}