package com.notesapp.ui.theme

import androidx.compose.ui.graphics.Color

// Light Theme Colors
val Primary = Color(0xFF6750A4)
val OnPrimary = Color(0xFFFFFFFF)
val PrimaryContainer = Color(0xFFEADDFF)
val OnPrimaryContainer = Color(0xFF21005D)

val Secondary = Color(0xFF625B71)
val SecondaryContainer = Color(0xFFE8DEF8)

val Tertiary = Color(0xFF7D5260)
val TertiaryContainer = Color(0xFFFFD8E4)

val Surface = Color(0xFFFFFBFE)
val SurfaceVariant = Color(0xFFE7E0EC)
val OnSurface = Color(0xFF1C1B1F)
val OnSurfaceVariant = Color(0xFF49454F)

val Background = Color(0xFFFFFBFE)
val Error = Color(0xFFB3261E)
val ErrorContainer = Color(0xFFF9DEDC)

// Note card accent colors
val NoteColor1 = Color(0xFFFFF9C4)  // Soft yellow
val NoteColor2 = Color(0xFFC8E6C9)  // Soft green
val NoteColor3 = Color(0xFFBBDEFB)  // Soft blue
val NoteColor4 = Color(0xFFF8BBD0)  // Soft pink
val NoteColor5 = Color(0xFFE1BEE7)  // Soft purple
val NoteColor6 = Color(0xFFFFCCBC)  // Soft orange

val noteColors = listOf(NoteColor1, NoteColor2, NoteColor3, NoteColor4, NoteColor5, NoteColor6)

fun getNoteColor(id: Int): Color = noteColors[id % noteColors.size]

// Dark Theme Colors
val PrimaryDark = Color(0xFFD0BCFF)
val OnPrimaryDark = Color(0xFF381E72)
val PrimaryContainerDark = Color(0xFF4F378B)
val OnPrimaryContainerDark = Color(0xFFEADDFF)

val SurfaceDark = Color(0xFF1C1B1F)
val OnSurfaceDark = Color(0xFFE6E1E5)
val BackgroundDark = Color(0xFF1C1B1F)
