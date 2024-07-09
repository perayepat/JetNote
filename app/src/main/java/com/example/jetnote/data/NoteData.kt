package com.example.jetnote.data

import com.example.jetnote.model.Note
import java.time.LocalDateTime

class NotesDataSource{
    fun loadNotes(): List<Note>{
        val now = LocalDateTime.now()
        return listOf(
            Note(
                title = "Meeting Notes",
                description = "Discuss the new project timeline and milestones.",
                entryDate = now
            ),
            Note(
                title = "Grocery List",
                description = "Buy milk, eggs, bread, and cheese.",
                entryDate = now.minusDays(1)
            ),
            Note(
                title = "Workout Plan",
                description = "Monday: Cardio\nTuesday: Strength Training\nWednesday: Rest\nThursday: Yoga\nFriday: HIIT",
                entryDate = LocalDateTime.now().minusDays(2)
            ),
            Note(
                title = "Vacation Itinerary",
                description = "Day 1: Arrival and check-in\nDay 2: City tour and museum visit\nDay 3: Beach day and relaxation",
                entryDate = now.minusDays(3)
            ),
            Note(
                title = "Reading List",
                description = "1. '1984' by George Orwell\n2. 'To Kill a Mockingbird' by Harper Lee\n3. 'The Great Gatsby' by F. Scott Fitzgerald",
                entryDate = now
            ),
            Note(
                title = "Project Ideas",
                description = "1. Mobile app for personal finance\n2. Web app for task management\n3. Game development with Unity",
                entryDate = now.minusDays(1)
            ),
            Note(
                title = "Recipe Ideas",
                description = "1. Spaghetti Carbonara\n2. Chicken Alfredo\n3. Beef Stroganoff",
                entryDate = now.minusDays(2)
            ),
            Note(
                title = "Daily Journal",
                description = "Today was a productive day. I managed to complete several tasks and feel accomplished.",
                entryDate = now.minusDays(3)
            ),
            Note(
                title = "Shopping List",
                description = "1. New shoes\n2. Jacket\n3. Sunglasses",
                entryDate = now
            ),
            Note(
                title = "Travel Plans",
                description = "1. Book flights\n2. Reserve hotels\n3. Plan activities and tours",
                entryDate = now.minusDays(1)
            )
        )
    }

}