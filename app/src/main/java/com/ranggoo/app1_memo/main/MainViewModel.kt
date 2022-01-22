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

    private var _memoList: MutableLiveData<List<MemoEntity>> = MutableLiveData<List<MemoEntity>>()
    val memoList: LiveData<List<MemoEntity>> = _memoList

    fun getMemoData() {
        val memoList: List<MemoDbItem> = dbHelper.readAllMemo()
        val memoEntityList: List<MemoEntity> = memoList.map {
            MemoEntity(
                id = it.id,
                content = it.content,
                title = it.subject
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