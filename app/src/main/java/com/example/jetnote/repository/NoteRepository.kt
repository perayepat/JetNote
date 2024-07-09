package com.example.jetnote.repository

import com.example.jetnote.data.NoteDatabaseDao
import com.example.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun add(note: Note) = noteDatabaseDao.insert(note)
    suspend fun update(note: Note) = noteDatabaseDao.update(note)
    suspend fun delete(note: Note) = noteDatabaseDao.delete(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()
    suspend fun getAll(): Flow<List<Note>> = noteDatabaseDao.getAll()
        .flowOn(Dispatchers.IO)
        .conflate()
}