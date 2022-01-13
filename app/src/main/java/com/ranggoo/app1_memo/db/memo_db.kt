package com.ranggoo.app1_memo.db

object MemoDB {
    val memoList: MutableList<MemoDbItem> = mutableListOf()
}

data class MemoDbItem(
    val id: Long,
    val subject: String,
    val content: String
)