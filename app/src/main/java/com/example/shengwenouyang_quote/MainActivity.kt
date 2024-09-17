package com.example.shengwenouyang_quote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shengwenouyang_quote.ui.theme.ShengwenOuyangQuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShengwenOuyangQuoteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MotivationalQuote(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MotivationalQuote(modifier: Modifier = Modifier) {
    // List of motivational quotes
    val quotes = listOf(
        "The only limit to our realization of tomorrow is our doubts of today.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "Don't watch the clock; do what it does. Keep going.",
        "Success is not the key to happiness. Happiness is the key to success.",
        "Believe you can and you're halfway there."
    )

    // State to keep track of the current quote
    var currentQuote by remember { mutableStateOf(quotes.random()) }

    // Main content
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentQuote,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EE),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { currentQuote = quotes.random() }) {
            Text(text = "Change Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MotivationalQuotePreview() {
    ShengwenOuyangQuoteTheme {
        MotivationalQuote()
    }
}
