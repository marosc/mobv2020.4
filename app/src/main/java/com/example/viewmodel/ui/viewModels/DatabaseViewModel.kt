package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.*
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DataRepository) : ViewModel() {

    val words: LiveData<List<WordItem>>
        get() = repository.getWords()

    val words_as_text: LiveData<String> = Transformations.map(words){
        var words_text = ""
        it?.forEach {
            words_text+= it.word+", "
        }
        words_text
    }

    //TODO: 8. nahradit observer databindingom v xml

    //TODO: 9. urobit obojsmerny binding pre edittext
    val inputText: MutableLiveData<String> = MutableLiveData()

    //TODO: 10. nahradit listener databindingom v xml
    fun insertWord() {
        inputText.value?.let {
            if (it.isNotEmpty()){
                viewModelScope.launch { repository.insertWord(WordItem(it)) }
                inputText.postValue("")
            }
        }

    }
}
