package com.ranggoo.app1_memo.data.db

object MemoDB {
    val memoList: MutableList<MemoDbItem> = mutableListOf<MemoDbItem>(
        MemoDbItem(id = 1, subject = "a", content = "zzz"),
        MemoDbItem(id = 2, subject = "b", content = "zz"),
        MemoDbItem(id = 3, subject = "v", content = "zzzz"),
        MemoDbItem(id = 4, subject = "d", content = "zz"),
        MemoDbItem(id = 5, subject = "e", content = "zzzz"),
        MemoDbItem(id = 6, subject = "f", content = "zz"),
        MemoDbItem(id = 7, subject = "g", content = "zzz"),
        MemoDbItem(id = 8, subject = "h", content = "zz"),
        MemoDbItem(id = 9, subject = "i", content = "zz"),
        MemoDbItem(id = 10, subject = "j", content = "zzz"),
        MemoDbItem(id = 11, subject = "k", content = "zzz"),
        MemoDbItem(id = 12, subject = "l", content = "zzz"),    )
}

data class MemoDbItem(
    val id: Long,
    val subject: String,
    val content: String
)