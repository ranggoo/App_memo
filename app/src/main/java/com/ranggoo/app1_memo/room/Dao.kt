package com.ranggoo.app1_memo.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM MemoEntity")
    fun getAll(): LiveData<List<MemoEntity>>

    @Insert
    fun insert(todo: MemoEntity)

    @Update
    fun update(todo: MemoEntity)

    @Delete
    fun delete(todo: MemoEntity)
}
