package com.example.viewmodel.data.db

import androidx.lifecycle.LiveData
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalCache(private val dao: DbDao) {

    suspend fun insertWords(wordItems: List<WordItem>) {
        dao.insertWords(wordItems)
    }

    suspend fun insertWord(wordItem: WordItem) {
        dao.insertWord(wordItem)
    }

    suspend fun updateVideo(wordItem: WordItem) {
        dao.updateWord(wordItem)
    }

    fun deleteWord(wordItem: WordItem) {
        GlobalScope.launch { dao.deleteWord(wordItem) }
    }

    fun getWords(): LiveData<List<WordItem>> = dao.getWords()

    suspend fun insertImages(marsItems: List<MarsItem>) {
        dao.insertImages(marsItems)
    }

    fun getImages(): LiveData<List<MarsItem>> = dao.getImages()
}