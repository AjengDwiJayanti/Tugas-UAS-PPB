package com.example.aplikasitokoonline.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplikasitokoonline.database.dao.DatabaseDao
import com.example.aplikasitokoonline.model.ModelDatabase


@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}