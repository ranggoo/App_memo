package com.ranggoo.app1_memo.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ranggoo.app1_memo.room.MemoEntity

class ViewModelSample (application: Application) : AndroidViewModel(application) {
    private val repository = Repository(application)
    private val items = repository.getAll()

    fun insert(todo: MemoEntity) {
        repository.insert(todo)
    }

    fun delete(todo: MemoEntity){
        repository.delete(todo)
    }

    fun getAll(): LiveData<List<MemoEntity>> {
        return items
    }
}