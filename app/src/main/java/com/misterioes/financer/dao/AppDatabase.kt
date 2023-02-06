package com.misterioes.financer.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.misterioes.financer.dao.dao.TransferDao
import com.misterioes.financer.dao.entity.Transfer

@Database(entities = [Transfer::class], version = 1)
@TypeConverters(DaoTypeConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun TransferDao(): TransferDao
}