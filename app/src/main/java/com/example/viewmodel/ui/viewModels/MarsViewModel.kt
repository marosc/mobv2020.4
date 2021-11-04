package com.example.viewmodel.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.MarsItem
import kotlinx.coroutines.launch

class MarsViewModel(private val repository: DataRepository) : ViewModel() {
    val images: LiveData<List<MarsItem>>
        get() = repository.getMars()

    val error: MutableLiveData<String> = MutableLiveData()

    val selected: MutableLiveData<MarsItem> = MutableLiveData()

    fun loadMarsData() {
        viewModelScope.launch {
            repository.loadMars { error.postValue(it) }
        }
    }
}