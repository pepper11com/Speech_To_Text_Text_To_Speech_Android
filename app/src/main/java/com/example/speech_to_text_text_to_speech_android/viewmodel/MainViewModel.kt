package com.example.speech_to_text_text_to_speech_android.viewmodel

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speech_to_text_text_to_speech_android.datamodel.MainScreenState
import com.example.speech_to_text_text_to_speech_android.datamodel.TextToVoice

import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel() {



    private val _state = mutableStateOf(TextToVoice())
    val state2: State<TextToVoice> = _state
    private var textToSpeech: TextToSpeech? = null

    fun onTextFieldValueChange(text:String){
        _state.value = state2.value.copy(
            text = text
        )
    }

    fun textToSpeech(context: Context){
        _state.value = state2.value.copy(
            isButtonEnabled = false
        )
        textToSpeech = TextToSpeech(
            context
        ) {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech?.let { txtToSpeech ->
                    val result = txtToSpeech.setLanguage(Locale("nl", "NL"))
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        //language not supported
                        txtToSpeech.language = Locale.ENGLISH
                    } else {
                        //language supported
                        txtToSpeech.language = Locale("nl", "NL")
                    }

                    txtToSpeech.setSpeechRate(1.0f)
                    txtToSpeech.speak(
                        _state.value.text,
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null
                    )
                }
            }
            _state.value = state2.value.copy(
                isButtonEnabled = true
            )
        }
    }



    var state by mutableStateOf(MainScreenState())
        private set

    fun changeTextValue(text:String){
        viewModelScope.launch {
            state = state.copy(
                text = text
            )
        }
    }
}