package com.ranggoo.app1_memo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.*

class DBHelper(
    context: Context,
) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    //데이터베이스 파일이 생성될 때 자동으로 호출되는 메서드
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_DB)
    }

    // 테이블 생성 코드를 작성해준다
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    // 메모 추가.
    fun insertMemo(memoSubject: String, memoText: String) {

        //현재시간을 구하기
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val now = sdf.format(Date())

        //?에 세팅될 값
        var arg1 = arrayOf(memoSubject, memoText, now)

        //저장
        this.writableDatabase.execSQL(INSERT, arg1)
    }

    companion object {
        // 디비 이름.
        private val DB_NAME = "memo.db"

        // 디비 버전.
        private val DB_VERSION = 1

        // 디비 생성 sql.
        private val CREATE_DB = """
            create table MemoTable
            (memo_idx integer primary key autoincrement,
             memo_subject text not null,
             memo_text text not null,
             memo_date date mot mull)            
        """.trimIndent()

        // 메모 추가 sql.
        private val INSERT = """
                    insert into MemoTable (memo_subject, memo_text, memo_date)
                    values(?, ?, ?)
                """.trimIndent()

    }


}