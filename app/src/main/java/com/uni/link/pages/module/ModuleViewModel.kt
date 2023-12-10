package com.uni.link.pages.module

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ModuleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "C'est la page module"
    }
    val text: LiveData<String> = _text
}