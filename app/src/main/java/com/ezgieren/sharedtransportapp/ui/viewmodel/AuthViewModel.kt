package com.ezgieren.sharedtransportapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezgieren.sharedtransportapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var isLoggedIn = false
        private set

    // Kullanıcı giriş işlemi
    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = authRepository.login(email, password)
            isLoggedIn = result
            onResult(result)
        }
    }

    // Kullanıcı kayıt işlemi
    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = authRepository.register(email, password)
            isLoggedIn = result
            onResult(result)
        }
    }

    // Mevcut kullanıcıyı kontrol et
    fun checkUser() {
        isLoggedIn = authRepository.getCurrentUser() != null
    }

    // Kullanıcı çıkış işlemi
    fun logout() {
        authRepository.logout()
        isLoggedIn = false
    }
}