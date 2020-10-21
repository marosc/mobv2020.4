package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.*
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DataRepository) : ViewModel() {
    val input: MutableLiveData<String> = MutableLiveData()

    val words: LiveData<List<WordItem>>
        get() = repository.getWords()

    val text: LiveData<String> = Transformations.map(words) { it.toString() }

    fun insertWord() {
        input.value?.let {
            if (it.isNotEmpty()) {
                viewModelScope.launch {
                    repository.insertWord(WordItem(it))
                    input.postValue("")
                }
            }
        }
    }
}
