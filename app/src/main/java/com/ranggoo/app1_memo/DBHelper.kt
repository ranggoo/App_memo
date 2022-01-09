package com.ranggoo.app1_memo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper : SQLiteOpenHelper {

    //생성자 정의(데이터베이스 이름 정의
    constructor(context: Context) : super(context, "Memo.db", null, 1)

    //데이터베이스 파일이 생성될 때 자동으로 호출되는 메서드

    override fun onCreate(p0: SQLiteDatabase?) {
        //쿼리문
        val sql = """
            create table MemoTable
            (memo_idx integer primary key autoincrement,
             memo_subject text not null,
             memo_text text not null,
             memo_date date mot mull)            
        """.trimIndent()

        p0?.execSQL(sql)
    }


    //테이블 생성 코드를 작성해준다
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}