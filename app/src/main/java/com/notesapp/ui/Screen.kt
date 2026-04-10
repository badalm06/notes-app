package com.notesapp.ui

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object NotesList : Screen("notes_list")
    object AddNote : Screen("add_note")
    object EditNote : Screen("edit_note/{noteId}") {
        fun createRoute(noteId: Int) = "edit_note/$noteId"
    }
}
