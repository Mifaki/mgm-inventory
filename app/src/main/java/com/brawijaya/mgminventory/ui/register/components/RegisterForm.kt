package com.brawijaya.mgminventory.ui.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.ui.components.LabeledTextField

@Composable
fun RegisterForm(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    nim: String,
    onNimChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LabeledTextField(
            label = "Nama",
            value = name,
            onValueChange = onNameChange,
            placeholder = "Masukan Nama",
            onClear = { onNameChange("") },
        )

        LabeledTextField(
            label = "Email",
            value = email,
            onValueChange = onEmailChange,
            placeholder = "Masukan Email",
            onClear = { onEmailChange("") },
        )

        LabeledTextField(
            label = "NIM",
            value = nim,
            onValueChange = onNimChange,
            placeholder = "Masukkan NIM",
            onClear = { onNimChange("") },
        )

        LabeledTextField(
            label = "Password",
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "Masukan Password",
            onClear = { onPasswordChange("") },
            isPassword = true
        )
    }
}
