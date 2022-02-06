package com.jhon.episode.presentation.main

import com.jhon.episode.domain.MemoEntity

/**
 * 메인 화면.
 *
 * @property memoList 메모리스트.
 */
data class MainViewState(
    val memoList: List<MemoEntity>
) {
    companion object {
        fun initial(): MainViewState = MainViewState(
            memoList = emptyList()
        )
    }
}