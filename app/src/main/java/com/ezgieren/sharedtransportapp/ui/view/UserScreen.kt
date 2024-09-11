package com.ezgieren.sharedtransportapp.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import com.ezgieren.sharedtransportapp.ui.viewmodel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    val user by viewModel.user.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        user?.let {
            Text(text = "ID: ${it.id}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${it.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Email: ${it.email}")
        } ?: run {
            Text(text = "Loading user data...")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    UserScreen()
}