package com.example.jetnote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.data.NotesDataSource
import com.example.jetnote.model.Note
import java.time.format.DateTimeFormatter

@Preview
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note = NotesDataSource().loadNotes()[0],
    onNoteClicked: (Note) -> Unit = {}
) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    note.title,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                note.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = modifier.padding(vertical = 10.dp)
            )
        }
    }
}