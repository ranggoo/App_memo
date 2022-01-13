package com.ranggoo.app1_memo.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.DBHelper
import com.ranggoo.app1_memo.MemoData

class MainViewModel(
    val dbHelper: DBHelper = DBHelper()
) : ViewModel() {

    private val _memoList: MutableLiveData<List<MemoData>> = MutableLiveData<List<MemoData>>()
    val memoList: LiveData<List<MemoData>> = _memoList

    init {
        getMemoList()
    }

    fun getMemoList() {
        val memoList = dbHelper.readAllMemo()
        val memoEntityList = memoList.map {
            MemoData(
                id = it.id,
                title = it.subject,
                content = it.content
            )
        }
        _memoList.value = memoEntityList
    }

}