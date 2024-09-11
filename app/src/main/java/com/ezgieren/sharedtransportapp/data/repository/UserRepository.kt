package com.ezgieren.sharedtransportapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ezgieren.sharedtransportapp.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    // Bu fonksiyon veriyi repository'den alır ve LiveData ile dışarıya aktarır.
    fun getUser() {
        val fakeUser = User("1", "Ezgi Eren", "ezgi@example.com") // API çağrısı yerine test verisi
        _user.postValue(fakeUser) // LiveData'ya veri post'lanıyor
    }
}