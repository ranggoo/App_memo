package com.ranggoo.app1_memo.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.db.DBHelper
import com.ranggoo.app1_memo.MemoEntity

class MainViewModel(
    val dbHelper: DBHelper = DBHelper()
) : ViewModel() {

    private val _memoList: MutableLiveData<List<MemoEntity>> = MutableLiveData<List<MemoEntity>>()
    val memoList: LiveData<List<MemoEntity>> = _memoList

    init {
        getMemoList()
    }

    fun getMemoList() {
        val memoList = dbHelper.readAllMemo()
        val memoEntityList = memoList.map {
            MemoEntity(
                id = it.id,
                title = it.subject,
                content = it.content
            )
        }
        _memoList.value = memoEntityList
    }

    fun insertMemo(memoSubject: String, memoContent: String) {
        // 글내용 디비 저장.
        DBHelper()
            .insertMemo(
                memoSubject = memoSubject,
                memoText = memoContent
            )
        // 메모 저장후 리스트 다시 호출.
        getMemoList()
    }

}