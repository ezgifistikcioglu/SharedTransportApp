package com.ezgieren.sharedtransportapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.ezgieren.sharedtransportapp.ui.view.AuthScreen
import com.ezgieren.sharedtransportapp.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.viewmodel.compose.viewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authViewModel: AuthViewModel = viewModel()
            var isLoggedIn by remember { mutableStateOf(false) }

            // Firebase üzerinden mevcut kullanıcıyı kontrol ediyoruz
            LaunchedEffect(Unit) {
                authViewModel.checkUser()
                isLoggedIn = authViewModel.isLoggedIn
            }

            if (isLoggedIn) {
                // Giriş yapılmışsa başka bir ekran (ana sayfa ya da dashboard) gösterilecek
            } else {
                AuthScreen()
            }
        }
    }
}