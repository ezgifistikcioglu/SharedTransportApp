package com.ezgieren.sharedtransportapp.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ezgieren.sharedtransportapp.ui.viewmodel.AuthViewModel
import com.ezgieren.sharedtransportapp.util.AppConstants

@Composable
fun AuthScreen(viewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) } // Giriş mi kayıt mı yapıyoruz?

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(AppConstants.EMAIL_HINT) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(AppConstants.PASSWORD_HINT) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (isLogin) {
                viewModel.login(email, password) { success ->
                    viewModel.login(email, password) { success ->
                        if (success) {
                            // Giriş başarılı
                        } else {
                            // Giriş başarısız, hata mesajı gösterelim
                            Log.e("","Giriş başarısız. Lütfen bilgilerinizi kontrol edin. Email: $email Pass: $password")
                        }
                    }
                }
            } else {
                viewModel.register(email, password) { success ->
                    // Kayıt başarılı ya da başarısız işleniyor
                }
            }
        }) {
            Text(if (isLogin) AppConstants.LOGIN_BUTTON else AppConstants.REGISTER_BUTTON)
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { isLogin = !isLogin }) {
            Text(if (isLogin) AppConstants.SWITCH_TO_REGISTER else AppConstants.SWITCH_TO_LOGIN)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    AuthScreen()
}