package com.chrispassold.presentation.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    isError: Boolean = false,
    readOnly: Boolean = false,
) {
    TextField(
        readOnly = readOnly,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        isError = isError,
        supportingText = {
            if (isError && errorMessage != null) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        },
        placeholder = { Text(label, style = MaterialTheme.typography.labelLarge) },
        modifier = Modifier.fillMaxWidth().then(modifier),
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        TextInput(
            label = "My Input",
            value = text,
            onValueChange = { text = it },
            errorMessage = if (isError) "This field is required" else null,
            isError = isError,
        )
        androidx.compose.material3.Button(onClick = { isError = !isError }) {
            androidx.compose.material3.Text("Toggle error")
        }
    }
}