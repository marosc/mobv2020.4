package com.example.viewmodel.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.data.DataRepository
import kotlinx.coroutines.launch

class MarsViewModel(private val repository: DataRepository) : ViewModel() {
    fun loadMarsData() {
        viewModelScope.launch {
            repository.loadMars()
        }
    }
}