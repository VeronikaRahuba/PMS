package com.example.girafferest.ui.book

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 3)
abstract class BookDB : RoomDatabase() {
    abstract fun getBookDAO(): BookDAO
}