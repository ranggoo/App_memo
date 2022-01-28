package com.ranggoo.app1_memo.presentation.main

import com.ranggoo.app1_memo.domain.MemoEntity

/**
 * 메인화면
 *
 * @property memoList 메모리스트
 */


//화면에 보여줄 뷰 데이터
data class MainViewState(
    val memoList: List<MemoEntity>
){
    companion object{
        fun initial():MainViewState = MainViewState(
            memoList = emptyList()
        )
    }

}
