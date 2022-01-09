package com.ranggoo.app1_memo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import com.ranggoo.app1_memo.databinding.ActivityMemoAddBinding
import java.text.SimpleDateFormat
import java.util.*

class MemoAddActivity : AppCompatActivity() {

    lateinit var binding: ActivityMemoAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMemoAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolba 설정
        setSupportActionBar(binding.memoAddToolbar)
        title = "메모 추가"

        //이전 버튼 설정
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //쓰래드를 가동한다.
        Thread {
            SystemClock.sleep(500)

            runOnUiThread {
                //포커스를 준다
                binding.addMemoSubject.requestFocus()

                //키보드를 보여준다
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(binding.addMemoSubject, InputMethodManager.SHOW_IMPLICIT)
            }
        }.start()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            //이전버튼
            android.R.id.home -> {
                finish()
            }

            //저장버튼
            R.id.add_menu_write -> {
                //사용자가 입력한 내용 가지고 온다.
                val memoSubject = binding.addMemoSubject.text
                val memoText = binding.addMemoText.text

                //쿼리문
                val sql = """
                    insert into MemoTable (memo_subject, memo_text, memo_date)
                    values(?, ?, ?)
                """.trimIndent()

                //데이터베이스 오픈
                val helper = DBHelper(this)

                //현재시간을 구하기
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val now = sdf.format(Date())

                //?에 세팅될 값
                var arg1 = arrayOf(memoSubject,memoText,now)

                //저장
                helper.writableDatabase.execSQL(sql,arg1)


                //데이타베이스 닫기
                helper.writableDatabase.close()
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}


















