package com.asthabansal.chatviewtask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class chatEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var message:String?=null

)
