package com.ezgieren.sharedtransportapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ezgieren.sharedtransportapp.data.model.User
import com.ezgieren.sharedtransportapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    // Repository'den gelen LiveData'yı expose ediyoruz
    val user: LiveData<User> = userRepository.user

    // ViewModel çağrıldığında repository'deki veriyi çek
    fun fetchUser() {
        userRepository.getUser()
    }
}