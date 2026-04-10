package com.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.notesapp.data.local.NotesDatabase
import com.notesapp.data.model.Note
import com.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class NotesUiState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = ""
)

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository by lazy {
        val db = NotesDatabase.getInstance(application)
        NoteRepository(db.noteDao())
    }

    private val _uiState = MutableStateFlow(NotesUiState())
    val uiState: StateFlow<NotesUiState> = _uiState.asStateFlow()

    private var currentUserId: String = ""

    fun loadNotesForUser(userId: String) {
        currentUserId = userId
        viewModelScope.launch {
            repository.getNotesByUser(userId)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
                .collect { notes ->
                    _uiState.value = _uiState.value.copy(
                        notes = notes,
                        isLoading = false
                    )
                }
        }
    }

    fun filteredNotes(): List<Note> {
        val query = _uiState.value.searchQuery.trim().lowercase()
        return if (query.isEmpty()) {
            _uiState.value.notes
        } else {
            _uiState.value.notes.filter {
                it.title.lowercase().contains(query) ||
                it.content.lowercase().contains(query)
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun createNote(title: String, content: String) {
        if (title.isBlank() && content.isBlank()) return
        viewModelScope.launch {
            val note = Note(
                title = title.trim(),
                content = content.trim(),
                lastUpdated = System.currentTimeMillis(),
                userId = currentUserId
            )
            repository.insertNote(note)
        }
    }

    fun updateNote(id: Int, title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                id = id,
                title = title.trim(),
                content = content.trim(),
                lastUpdated = System.currentTimeMillis(),
                userId = currentUserId
            )
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        // Optimistic update: remove from UI immediately, then delete from DB
        _uiState.value = _uiState.value.copy(
            notes = _uiState.value.notes.filter { it.id != note.id }
        )
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    suspend fun getNoteById(id: Int): Note? =
        repository.getNoteById(id)

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
