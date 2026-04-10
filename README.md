# 📝 Notes App — Android Intern Assignment

A production-ready Notes application built with **Jetpack Compose**, **MVVM**, **Room**, and **Firebase Authentication**.

---

## 📸 Screens

| Login | Notes List | Add / Edit Note |
|-------|------------|-----------------|
| Email/Password + Google Sign-In | LazyColumn with colored cards, search, long-press delete | Clean title + body editor with save/discard |

---

## 🛠 Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose (Material 3) |
| Architecture | MVVM |
| Local DB | Room |
| Auth | Firebase Email/Password + Google One Tap |
| Async | Kotlin Coroutines + StateFlow |
| Navigation | Jetpack Navigation Compose |

---

## 🏗 Architecture

```
UI (Composables)
    ↕ StateFlow / collectAsState
ViewModel  (AuthViewModel, NotesViewModel)
    ↕ suspend functions / Flow
Repository  (AuthRepository, NoteRepository)
    ↕
Room Database  ←→  Firebase Auth
```

- **No business logic in UI** — all logic lives in ViewModels
- **Repository pattern** — UI never directly touches data sources
- **StateFlow** drives all UI state reactively
- **No DI frameworks** — dependencies wired manually via `viewModel()` factory

---

## 📁 Project Structure

```
app/src/main/java/com/notesapp/
├── data/
│   ├── local/
│   │   ├── NoteDao.kt            # Room DAO
│   │   └── NotesDatabase.kt      # Room Database singleton
│   ├── model/
│   │   └── Note.kt               # @Entity data class
│   └── repository/
│       ├── AuthRepository.kt     # Firebase Auth wrapper
│       └── NoteRepository.kt     # Room CRUD wrapper
├── ui/
│   ├── screens/
│   │   ├── LoginScreen.kt        # Auth screen
│   │   ├── NotesListScreen.kt    # Notes list + search + delete
│   │   └── AddEditNoteScreen.kt  # Create / edit note
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Theme.kt              # Light + Dark theme
│   │   └── Typography.kt
│   ├── AppNavigation.kt          # NavHost + routes
│   └── Screen.kt                 # Sealed class routes
├── viewmodel/
│   ├── AuthViewModel.kt          # Auth state + actions
│   └── NotesViewModel.kt         # Notes state + CRUD actions
└── MainActivity.kt
```

---

## 🚀 Setup Steps

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/notes-app.git
cd notes-app
```

### 2. Firebase Setup (Required)

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project
3. Add an Android app:
   - **Package name:** `com.notesapp`
   - **App nickname:** Notes App
4. Enable **Authentication** → **Sign-in methods**:
   - ✅ Email/Password
   - ✅ Google
5. Download `google-services.json` → place it in `app/` folder
6. Copy your **Web Client ID** from `google-services.json` (look for `"client_type": 3`)
7. Open `app/src/main/res/values/strings.xml` and replace:
   ```xml
   <string name="default_web_client_id">PASTE_YOUR_WEB_CLIENT_ID_HERE</string>
   ```

### 3. Build & Run
```bash
./gradlew assembleDebug
```
Or open in **Android Studio Hedgehog or newer** and click ▶ Run.

---

## ✅ Features Checklist

### Authentication
- [x] Email/Password sign in
- [x] Email/Password registration
- [x] Google Sign-In (One Tap)
- [x] Session persistence (Firebase handles this)
- [x] Sign out

### Notes CRUD
- [x] Create note (title + content)
- [x] View notes list (LazyColumn)
- [x] Edit note
- [x] Delete note with confirmation dialog
- [x] Per-user data isolation (userId stored with each note)

### UI/UX
- [x] Jetpack Compose only (zero XML layouts)
- [x] Material 3 design
- [x] Login screen
- [x] Notes list screen
- [x] Add/Edit note screen
- [x] Empty state handling
- [x] Search/filter notes
- [x] Colored note cards
- [x] Delete confirmation dialog
- [x] Discard changes dialog

### Theme
- [x] Light theme
- [x] Dark theme
- [x] Respects system theme
- [x] Dynamic color (Android 12+)

---

## 🗄 Data Model

```kotlin
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val lastUpdated: Long = System.currentTimeMillis(),
    val userId: String = ""   // Scoped to logged-in user
)
```

---

## 📋 Evaluation Notes

- **Code quality**: Single-responsibility composables, sealed state classes, no logic in UI
- **Compose usage**: LazyColumn, StateFlow + collectAsState, Navigation Compose, Material 3 components throughout
- **Architecture**: Strict MVVM — UI → ViewModel → Repository → Room/Firebase
- **UI/UX polish**: Colored cards, smooth animations, search, empty states, dialogs, edge-to-edge
- **Auth & CRUD**: Full Firebase auth flow + complete Room CRUD with per-user data isolation
