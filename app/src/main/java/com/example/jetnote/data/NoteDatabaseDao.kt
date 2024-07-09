package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow
import java.util.UUID


@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM notes_tbl")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM notes_tbl WHERE id = :id")
    suspend fun getById(id: UUID): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note): Int

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAll(): Int

    @Delete
    suspend fun delete(note: Note): Int
}