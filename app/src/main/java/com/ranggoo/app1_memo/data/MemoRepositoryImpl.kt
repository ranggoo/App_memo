package com.ranggoo.app1_memo.data

import com.ranggoo.app1_memo.data.db.DBHelper
import com.ranggoo.app1_memo.data.db.MemoDbItem
import com.ranggoo.app1_memo.domain.MemoRepository
import com.ranggoo.app1_memo.presentation.main.MemoEntity
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val dbHelper: DBHelper
):MemoRepository{
    override fun add(title: String, content: String): MemoEntity {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): MemoEntity {
        TODO("Not yet implemented")
    }

    override fun modify(id: Long, title: String, content: String): MemoEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(): List<MemoEntity> {
        return dbHelper.readAllMemo().toEntity()


    }
    //db아이템을 메모엔터티로 바꾼다
    private fun List<MemoDbItem>.toEntity():List<MemoEntity> = map{ memoDbItem->
            MemoEntity(
                id = memoDbItem.id,
                title = memoDbItem.subject,
                content = memoDbItem.content
            )
        }
    }
