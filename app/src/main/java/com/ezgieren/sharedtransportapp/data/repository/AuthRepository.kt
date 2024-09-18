package com.ezgieren.sharedtransportapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    // Kullanıcı giriş işlemi
    suspend fun login(email: String, password: String): Boolean {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.e("FirebaseAuth", "Login failed: ${e.message}")
            false
        }
    }

    // Kullanıcı kayıt işlemi
    suspend fun register(email: String, password: String): Boolean {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // Mevcut oturum açmış kullanıcıyı kontrol et
    fun getCurrentUser() = firebaseAuth.currentUser

    // Kullanıcı çıkış işlemi
    fun logout() {
        firebaseAuth.signOut()
    }
}