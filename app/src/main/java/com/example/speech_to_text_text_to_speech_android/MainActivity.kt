package com.example.speech_to_text_text_to_speech_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.speech_to_text_text_to_speech_android.ui.screens.MainScreen
import com.example.speech_to_text_text_to_speech_android.ui.screens.TextToSpeech
import com.example.speech_to_text_text_to_speech_android.ui.theme.Speech_To_Text_Text_To_Speech_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Speech_To_Text_Text_To_Speech_AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                    TextToSpeech()
                }
            }
        }
    }
}

