package com.ranggoo.app1_memo.db

import com.ranggoo.app1_memo.db.MemoDB
import com.ranggoo.app1_memo.db.MemoDbItem
import java.util.*

class DBHelper {

    // 메모 추가.
    fun insertMemo(memoSubject: String, memoText: String) {
        val memoItem = MemoDbItem(id = System.currentTimeMillis(), subject = memoSubject, content = memoText)
        MemoDB.memoList.add(memoItem)
    }

    // 메모 삭제.
    fun deleteMemo(memoId:Long){
        // todo 메모 삭제 로직 구현.
    }

    // 메모 수정.
    fun modifyMemo(memoId:Long, subject:String, content:String){
        // todo 메모 수정 로직 구현.
    }

    // 메모 하나 읽기.
    fun readSingleMemo(memoId: Long){
        // todo 메모읽어 오기 구현
    }

    // 메모 모두 읽기.
    fun readAllMemo(): List<MemoDbItem> {
        return MemoDB.memoList
    }

}