package com.example.exertion

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exertion.ui.theme.ExertionTheme

@Composable
fun TextFieldCustom() {
    var text by remember {
        mutableStateOf("Type here...")
    }
    OutlinedTextField(
        value = text,
        onValueChange = {
                newText -> text = newText
        },
        label = {
            Text(text = "title")
        },
        leadingIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                Log.d("Trailing Icon", "Clicked")
            }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                Log.d("ImeAction", "Clicked")
            }
        )
    )
}

@Composable
fun PasswordField() {
    var password by rememberSaveable { mutableStateOf("") }
    var password_visibility by remember { mutableStateOf(false) }

    val icon = if (password_visibility)
        painterResource(id = R.drawable.visibility_on)
    else
        painterResource(id = R.drawable.visibility_off)

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        placeholder = { Text("Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(
                onClick = {
                    password_visibility = !password_visibility
                }
            ) {
                Icon(
                    painter = icon,
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Visibility Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
        visualTransformation = if (password_visibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
@Preview
fun TextFieldCustomPreview() {
    ExertionTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                TextFieldCustom()
                Spacer(modifier = Modifier.height(16.dp))
                PasswordField()
            }
        }
    }
}