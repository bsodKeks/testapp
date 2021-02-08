package com.als.myapplication.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "db") //TODO в gradle
            .allowMainThreadQueries()//выполняется в главном потоке
            //.addMigrations(Migrations.MIGRATION_1_2)
            .fallbackToDestructiveMigration()// позволяет не настраивать миграцию, при изменении БД будет пересоздавтаься с потерей данных
            .build()

    @Provides
    @Singleton
    internal fun provideDao(appDataBase: AppDatabase): AppDao {
        return appDataBase.currencyDao()
    }
}