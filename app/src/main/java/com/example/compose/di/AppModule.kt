package com.example.compose.di

import android.content.Context
import androidx.room.Room
import com.example.compose.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideContactDao(database: ContactDatabase): ContactDatabaseDao {
        return database.contactDatabaseDao
    }

    @Singleton
    @Provides
    fun provideContactDatabase(@ApplicationContext appContext: Context): ContactDatabase {
        return Room.databaseBuilder(
            appContext,
            ContactDatabase::class.java,
            "ComposeContactDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


}