package com.example.compose.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactData::class], version = 2, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contactDatabaseDao: ContactDatabaseDao

}