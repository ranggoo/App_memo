package com.ranggoo.app1_memo.presentation.main

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.ranggoo.app1_memo.domain.GetMemoListAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMemoListAllUseCase: GetMemoListAllUseCase
) : ViewModel() {

    private val _memoList = MutableStateFlow<MainViewState>(MainViewState.initial())
    val memoList = _memoList.asStateFlow()

    init {
        getMemoList()
    }

    fun getMemoList() {
        val memoList = getMemoListAllUseCase()
        _memoList.update { prevState ->
            prevState.copy(
                memoList = memoList
            )
        }
    }


}
