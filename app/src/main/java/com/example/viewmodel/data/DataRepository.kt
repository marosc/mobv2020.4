/*
 * Copyright (C) 2019 Maros Cavojsky, mpage.sk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.viewmodel.data

import androidx.lifecycle.LiveData
import com.example.viewmodel.data.db.LocalCache
import com.example.viewmodel.data.db.model.WordItem

/**
 * Repository class that works with local and remote data sources.
 */
class DataRepository private constructor(
    private val cache: LocalCache
) {

    companion object {
        const val TAG = "DataRepository"
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(cache: LocalCache): DataRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: DataRepository(cache).also { INSTANCE = it }
            }
    }

    fun getWords(): LiveData<List<WordItem>> = cache.getWords()

    suspend fun insertWord(wordItem: WordItem) {
        cache.insertWord(wordItem)
    }

    suspend fun updateWords() {
        cache.updateWords()
    }

    suspend fun deleteWords() {
        cache.deleteWords()
    }
}
