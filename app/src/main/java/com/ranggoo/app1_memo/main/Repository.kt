package com.ranggoo.app1_memo.main

import android.app.Application
import androidx.lifecycle.LiveData
import com.ranggoo.app1_memo.room.MemoDao
import com.ranggoo.app1_memo.room.MemoDatabase
import com.ranggoo.app1_memo.room.MemoEntity

class Repository (application: Application) {
    private val MemoDao: MemoDao
    private val MemoList: LiveData<List<MemoEntity>>

    init {
        var db = MemoDatabase.getInstance(application)
        MemoDao = db!!.todoDao()
        MemoList = db.todoDao().getAll()
    }

    fun insert(todo: MemoEntity) {
        MemoDao.insert(todo)
    }

    fun delete(todo: MemoEntity) {
        MemoDao.delete(todo)
    }

    fun getAll(): LiveData<List<MemoEntity>> {
        return MemoDao.getAll()
    }
}