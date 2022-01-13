package com.ranggoo.app1_memo.db

import com.ranggoo.app1_memo.MemoData

object MemoDB {
    val memoList: MutableList<MemoDbItem> = mutableListOf()
}

data class MemoDbItem(
    val id: Long,
    val subject: String,
    val content: String
)