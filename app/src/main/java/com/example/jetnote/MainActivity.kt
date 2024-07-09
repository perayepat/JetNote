package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.model.Note
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.screen.NoteViewModel
import com.example.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNoteTheme {
//                val noteViewModel : NoteViewModel by viewModels()
                val noteViewModel = viewModel<NoteViewModel>()
                Scaffold(modifier = Modifier.fillMaxSize()) { it
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(
        notes = notesList,
        onRemoveNote = {noteViewModel.delete(it)},
        onAddNote = {noteViewModel.add(it)}
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {
        NoteScreen()
    }
}