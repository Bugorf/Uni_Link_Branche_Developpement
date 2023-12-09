package com.uni.link.Pages.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bienvenu dans la page accueil"
    }
    val text: LiveData<String> = _text
}