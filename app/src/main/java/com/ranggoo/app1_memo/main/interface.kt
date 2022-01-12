package com.ranggoo.app1_memo.main

import com.ranggoo.app1_memo.room.MemoEntity

interface OnItemClick {
    fun deleteTodo(todo: MemoEntity)
}