# Notes App

A notes application built with Jetpack Compose, MVVM, Room, and Firebase Authentication.

---

## Screenshots

<!-- Add your screenshots here -->

| Login | Notes List | Add / Edit Note |
|-------|------------|-----------------|
| &nbsp; | &nbsp; | &nbsp; |

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose (Material 3) |
| Architecture | MVVM |
| Local DB | Room |
| Auth | Firebase Email/Password + Google Sign-In |
| Async | Kotlin Coroutines + StateFlow |
| Navigation | Jetpack Navigation Compose |

---

## Architecture

```
UI (Composables)
    ↕ StateFlow / collectAsState
ViewModel  (AuthViewModel, NotesViewModel)
    ↕ suspend functions / Flow
Repository  (AuthRepository, NoteRepository)
    ↕
Room Database  ←→  Firebase Auth
```

- No business logic in UI — all logic lives in ViewModels
- Repository pattern — UI never directly touches data sources
- StateFlow drives all UI state reactively

---

## Project Structure

```
app/src/main/java/com/notesapp/
├── data/
│   ├── local/
│   │   ├── NoteDao.kt
│   │   └── NotesDatabase.kt
│   ├── model/
│   │   └── Note.kt
│   └── repository/
│       ├── AuthRepository.kt
│       └── NoteRepository.kt
├── ui/
│   ├── screens/
│   │   ├── LoginScreen.kt
│   │   ├── NotesListScreen.kt
│   │   └── AddEditNoteScreen.kt
│   ├── theme/
│   ├── AppNavigation.kt
│   └── Screen.kt
├── viewmodel/
│   ├── AuthViewModel.kt
│   └── NotesViewModel.kt
└── MainActivity.kt
```

---

## Setup

### 1. Clone the repo
```bash
git clone https://github.com/badalm06/notes-app.git
cd notes-app
```

### 2. Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/) and create a project
2. Add an Android app with package name `com.notesapp`
3. Enable **Authentication → Sign-in methods**: Email/Password and Google
4. Download `google-services.json` and place it in the `app/` folder
5. In Firebase Console → Project Settings → add your **SHA-1 fingerprint** (required for Google Sign-In)
   ```bash
   ./gradlew signingReport
   ```

### 3. Run
Open in Android Studio and click Run, or:
```bash
./gradlew assembleDebug
```

---

## Features

- Email/Password sign in & registration
- Google Sign-In
- Create, edit, delete notes
- Per-user data isolation
- Search/filter notes
- Colored note cards
- Light & dark theme
- Empty state handling
