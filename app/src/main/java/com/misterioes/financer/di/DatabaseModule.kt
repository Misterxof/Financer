package com.misterioes.financer.di

import android.content.Context
import androidx.room.Room
import com.misterioes.financer.dao.AppDatabase
import com.misterioes.financer.dao.dao.TransferDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTransactionDao(appDatabase: AppDatabase): TransferDao {
        return appDatabase.TransferDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "financer").build()
    }
}