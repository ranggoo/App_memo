package com.ranggoo.app1_memo.main

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.DBHelper
import com.ranggoo.app1_memo.MemoData
import com.ranggoo.app1_memo.room.MemoEntity

class MainViewModel : ViewModel() {

    private lateinit var dbHelper: DBHelper

    private val _memoList: MutableLiveData<List<MemoData>> = MutableLiveData<List<MemoData>>()
    val memoList: LiveData<List<MemoData>> = _memoList

    fun init(context: Context) {
        dbHelper = DBHelper(context)
    }

    fun getMemoList() {

        // 1. dbHelper로 메모를 불러온다.
        // 2. 불러온 메모를 memoList에 셋팅한다.
        // _memoList.value = '메모리스트'
    }

}