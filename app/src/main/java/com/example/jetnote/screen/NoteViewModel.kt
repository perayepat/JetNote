package com.example.jetnote.screen

import android.util.Log
import androidx.collection.mutableIntListOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val respository: NoteRepository): ViewModel() {
    private var _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
//        noteList.addAll(NotesDataSource().loadNotes())
//        getting all the notes
        viewModelScope.launch(Dispatchers.IO){
            respository.getAll().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
//                        respository.add(NotesDataSource().loadNotes()[0])
                        Log.d("Empty", ": We have nothing  ")
                    }
                    _noteList.value = listOfNotes
                }
        }

    }

     fun add(note: Note) = viewModelScope.launch { respository.add(note) }
     fun update(note: Note) = viewModelScope.launch { respository.update(note) }
     fun delete(note: Note) = viewModelScope.launch { respository.delete(note) }
     fun getAll() = viewModelScope.launch { respository.getAll() }
}