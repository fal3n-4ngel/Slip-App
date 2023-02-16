package com.example.slipapp


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SlipViewModel : ViewModel() {
    var slipType: Int by mutableStateOf(value = R.string.SelectType)
    var title by mutableStateOf(value = "")
    var description by mutableStateOf(value = "")
    var sendToHOD by mutableStateOf(value = false)
    var sendToAdvisors by mutableStateOf(value = false)
}