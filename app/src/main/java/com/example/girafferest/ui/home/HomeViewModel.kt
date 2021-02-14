package com.example.girafferest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Рахуба Вероніка \n Група ІО-81 \n ЗК ІО-8121"
    }
    val text: LiveData<String> = _text
}