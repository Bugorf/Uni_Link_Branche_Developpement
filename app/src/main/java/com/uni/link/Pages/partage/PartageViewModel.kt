package com.uni.link.Pages.partage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PartageViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Partager votre vie avec des photos ou videos !"
    }
    val text: LiveData<String> = _text
}