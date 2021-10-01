package com.byjus.jetpack.paging.dependencies

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.byjus.jetpack.base.persistance.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {
    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun providesRoomDB(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
    }
}