package com.uni.link.Pages.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ici, messagerie"
    }
    val text: LiveData<String> = _text
}