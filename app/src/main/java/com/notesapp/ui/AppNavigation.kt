package com.notesapp.ui

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.notesapp.ui.screens.AddEditNoteScreen
import com.notesapp.ui.screens.LoginScreen
import com.notesapp.ui.screens.NotesListScreen
import com.notesapp.viewmodel.AuthViewModel
import com.notesapp.viewmodel.NotesViewModel

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel,
    notesViewModel: NotesViewModel
) {
    val authState by authViewModel.uiState.collectAsState()
    val navController = rememberNavController()

    val startDestination = if (authState.isLoggedIn) Screen.NotesList.route else Screen.Login.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.NotesList.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.NotesList.route) {
            val currentAuthState by authViewModel.uiState.collectAsState()

            // Load notes whenever userId is available or changes
            LaunchedEffect(currentAuthState.userId) {
                if (currentAuthState.userId.isNotEmpty()) {
                    notesViewModel.loadNotesForUser(currentAuthState.userId)
                }
            }

            // Watch for sign-out
            LaunchedEffect(currentAuthState.isLoggedIn) {
                if (!currentAuthState.isLoggedIn) {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.NotesList.route) { inclusive = true }
                    }
                }
            }

            NotesListScreen(
                notesViewModel = notesViewModel,
                authViewModel = authViewModel,
                onAddNote = { navController.navigate(Screen.AddNote.route) },
                onEditNote = { noteId ->
                    navController.navigate(Screen.EditNote.createRoute(noteId))
                }
            )
        }

        composable(Screen.AddNote.route) {
            AddEditNoteScreen(
                notesViewModel = notesViewModel,
                noteId = null,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.EditNote.route,
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId")
            AddEditNoteScreen(
                notesViewModel = notesViewModel,
                noteId = noteId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
