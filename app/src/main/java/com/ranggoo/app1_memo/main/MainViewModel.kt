package com.ranggoo.app1_memo.main

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.db.DBHelper
import com.ranggoo.app1_memo.db.MemoDbItem
import kotlinx.parcelize.Parcelize

class MainViewModel(
    val dbHelper: DBHelper = DBHelper()
) : ViewModel() {

    private val _memoList: MutableLiveData<List<MemoEntity>> = MutableLiveData<List<MemoEntity>>()
    val memoList: LiveData<List<MemoEntity>> = _memoList

    init {
        getMemoList()
    }

    fun getMemoList() {
        val memoList: List<MemoDbItem> = dbHelper.readAllMemo()
        val memoEntityList: List<MemoEntity> = memoList.map {
            MemoEntity(
                id = it.id,
                title = it.subject,
                content = it.content
            )
        }
        _memoList.value = memoEntityList
    }


}

@Parcelize
data class MemoEntity(
    val id: Long,
    val title: String,
    val content: String
) : Parcelable