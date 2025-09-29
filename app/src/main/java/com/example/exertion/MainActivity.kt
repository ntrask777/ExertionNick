package com.example.exertion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exertion.ui.theme.BLACK_COLOR
import com.example.exertion.ui.theme.EXERTION_RED
import com.example.exertion.ui.theme.DARK_GREY
import com.example.exertion.ui.theme.ExertionTheme
import com.example.exertion.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExertionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Jake")
                        CustomText("Test")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        style = Typography.headlineSmall
    )
}

@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color) {
    Surface(modifier = Modifier
        .width(200.dp)
        .weight(weight),
        color = color
    ) {}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExertionTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .weight(1f),
                color = EXERTION_RED
            ) {}
        }
    }
}
