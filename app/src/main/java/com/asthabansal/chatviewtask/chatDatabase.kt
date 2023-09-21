package com.asthabansal.chatviewtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [chatEntity::class])
class chatDatabase  {
    //class which extends room database
    abstract class chatDatabase:RoomDatabase(){
        //mae one abstract function to intialize dao
        abstract fun chatDao():ChatDao
        //companion object to directly call the database
        companion object{
            private  var chatDatabase:chatDatabase ?=null
            fun getDatabase(context: Context):chatDatabase{
                if(chatDatabase == null){
                    chatDatabase = Room.databaseBuilder(context,
                    chatDatabase!!::class.java,
                    context.resources.getString(R.string.app_name)).build()
                }
                return chatDatabase!!
            }

        }
    }
}