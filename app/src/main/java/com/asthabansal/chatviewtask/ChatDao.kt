package com.asthabansal.chatviewtask

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {

@Insert
suspend fun insertMessage(chatEntity: chatEntity)

@Query("SELECT * FROM chatEntity")
fun getMessage(): LiveData<List<chatEntity>>

}