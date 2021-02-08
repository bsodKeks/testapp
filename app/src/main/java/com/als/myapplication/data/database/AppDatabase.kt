package com.als.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.data.database.dto.WorkerSpecDb


@Database(
    entities = [SpecialityDb::class, WorkerDb::class, WorkerSpecDb::class],
    version = 3,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun currencyDao(): AppDao
}