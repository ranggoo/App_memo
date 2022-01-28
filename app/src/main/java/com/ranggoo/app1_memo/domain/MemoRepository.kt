package com.ranggoo.app1_memo.domain

interface MemoRepository {
    fun add(title: String, content: String): MemoEntity
    fun delete(id: Long): MemoEntity
    fun modify(id: Long, title: String, content: String): MemoEntity
    fun readAll(): List<MemoEntity>
}
