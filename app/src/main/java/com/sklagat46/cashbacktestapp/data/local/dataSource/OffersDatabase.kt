package com.sklagat46.cashbacktestapp.data.local.dataSource

import androidx.room.Database
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sklagat46.cashbacktestapp.data.local.dao.OffersDao
import com.sklagat46.cashbacktestapp.data.local.model.Offers


@Database(
    entities = [Offers::class],
    version = 3

)
@RewriteQueriesToDropUnusedColumns
@TypeConverters(Converters::class)
 abstract class OffersDatabase : RoomDatabase() {
    abstract val offersDao: OffersDao

    companion object{
        const val DATABASE_NAME= "cashback.db"
    }
}