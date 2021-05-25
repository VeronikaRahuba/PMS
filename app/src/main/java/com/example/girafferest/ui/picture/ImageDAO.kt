package com.example.girafferest.ui.picture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ImageDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertByReplacement(image: List<ImageEntity>)

    @Query("DELETE FROM image")
    suspend fun nukeTable()

    @Insert
    suspend fun insertAll(articleList : List<ImageEntity>) : List<Long>

    @Query("SELECT * FROM image")
    suspend fun getAll(): List<ImageEntity>
}