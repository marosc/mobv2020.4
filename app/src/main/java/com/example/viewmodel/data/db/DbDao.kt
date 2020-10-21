package com.example.viewmodel.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.data.db.model.WordItem

@Dao
interface DbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(wordItems: List<WordItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(wordItem: WordItem)

    @Update
    suspend fun updateWord(wordItem: WordItem)

    @Delete
    suspend fun deleteWord(wordItem: WordItem)

    @Query("SELECT * FROM words")
    fun getWords(): LiveData<List<WordItem>>

    //TODO: 11. vymazat slova obsahujuce "slovo", pomocou databinding
    //TODO: 12. pridat slovam obsahujuce "slovo", priponu "databinding"
    //TODO: 13. vytvorit DAO metody pre ImageItem
    //TODO: 14. vytvorit Fragment+Viewmodel+layout pre vytvorenie a imageitem
    //TODO: 15. vytvorit Fragment+Viewmodel+layout zobrazenie posledneho vlozeneho obrazku spolu s textom

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(marsItems: List<MarsItem>)

    @Query("SELECT * FROM images")
    fun getImages(): LiveData<List<MarsItem>>
}