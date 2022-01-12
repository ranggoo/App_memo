package com.ranggoo.app1_memo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MemoEntity::class], version = 1, exportSchema = false)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun todoDao(): MemoDao

    companion object {
        private var instance: MemoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MemoDatabase? {
            if (instance == null) {
                synchronized(MemoDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java,
                        "database-name"
                    ).build()
                }
            }
            return instance
        }
    }
}