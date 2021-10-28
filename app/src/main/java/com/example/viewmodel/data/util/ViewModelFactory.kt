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

package com.opinyour.android.app.data.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.ui.viewModels.DatabaseViewModel
import com.example.viewmodel.ui.viewModels.MarsViewModel

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: DataRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DatabaseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DatabaseViewModel(repository) as T
        }

        if (modelClass.isAssignableFrom(MarsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MarsViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
