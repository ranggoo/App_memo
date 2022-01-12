package com.ranggoo.app1_memo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoEntity (
    val subjectList: String,
    val contextList : String,
    val idxList : Int
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
