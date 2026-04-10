package com.notesapp.data.repository

import com.notesapp.data.local.NoteDao
import com.notesapp.data.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    fun getNotesByUser(userId: String): Flow<List<Note>> =
        noteDao.getNotesByUser(userId)

    suspend fun getNoteById(id: Int): Note? =
        noteDao.getNoteById(id)

    suspend fun insertNote(note: Note) =
        noteDao.insertNote(note)

    suspend fun updateNote(note: Note) =
        noteDao.updateNote(note)

    suspend fun deleteNote(note: Note) =
        noteDao.deleteNote(note)
}
