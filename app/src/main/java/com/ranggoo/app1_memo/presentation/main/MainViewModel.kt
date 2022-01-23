package com.ranggoo.app1_memo.presentation.main

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.data.db.MemoDbItem
import com.ranggoo.app1_memo.domain.GetMemoListAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.parcelize.Parcelize
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMemoListAllUseCase: GetMemoListAllUseCase
) : ViewModel() {

    private val _memoList: MutableLiveData<List<MemoEntity>> = MutableLiveData<List<MemoEntity>>()
    val memoList: LiveData<List<MemoEntity>> = _memoList

    init {
        getMemoList()
    }

    fun getMemoList() {_memoList.value = getMemoListAllUseCase()}



}

@Parcelize
data class MemoEntity(
    val id: Long,
    val title: String,
    val content: String
) : Parcelable