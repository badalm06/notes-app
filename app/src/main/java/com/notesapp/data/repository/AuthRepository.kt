package com.notesapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    val isLoggedIn: Boolean
        get() = firebaseAuth.currentUser != null

    suspend fun signInWithEmail(email: String, password: String): Result<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(Exception(getFriendlyError(e)))
        }
    }

    suspend fun registerWithEmail(email: String, password: String): Result<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(Exception(getFriendlyError(e)))
        }
    }

    suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = firebaseAuth.signInWithCredential(credential).await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(Exception(getFriendlyError(e)))
        }
    }

    private fun getFriendlyError(e: Exception): String {
        val msg = e.message ?: return "Something went wrong. Please try again."
        return when {
            msg.contains("credential is incorrect", ignoreCase = true) ||
            msg.contains("INVALID_LOGIN_CREDENTIALS", ignoreCase = true) ||
            msg.contains("auth credential", ignoreCase = true) -> "Invalid email or password."
            msg.contains("no user record", ignoreCase = true) ||
            msg.contains("USER_NOT_FOUND", ignoreCase = true) -> "No account found with this email."
            msg.contains("password is invalid", ignoreCase = true) ||
            msg.contains("INVALID_PASSWORD", ignoreCase = true) -> "Invalid email or password."
            msg.contains("email address is already in use", ignoreCase = true) -> "An account with this email already exists."
            msg.contains("badly formatted", ignoreCase = true) -> "Please enter a valid email address."
            msg.contains("network", ignoreCase = true) -> "Network error. Check your connection."
            msg.contains("too many requests", ignoreCase = true) -> "Too many attempts. Please try again later."
            else -> "Invalid email or password."
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}
