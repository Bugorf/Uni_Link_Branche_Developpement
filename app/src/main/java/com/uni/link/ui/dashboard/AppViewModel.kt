package com.uni.link.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is kaoutar"
    }
    val text: LiveData<String> = _text
}