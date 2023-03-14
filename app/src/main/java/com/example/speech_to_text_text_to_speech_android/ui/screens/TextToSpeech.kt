package com.example.speech_to_text_text_to_speech_android.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.speech_to_text_text_to_speech_android.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun TextToSpeech(
    viewModel: MainViewModel = viewModel()
) {
    val state = viewModel.state2.value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TextField(value = state.text, onValueChange = {
            viewModel.onTextFieldValueChange(it)
        })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            viewModel.textToSpeech(context)
        }, enabled = state.isButtonEnabled
        ) {
            Text(text = "speak")
        }
    }
}