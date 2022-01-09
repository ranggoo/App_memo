package com.ranggoo.app1_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranggoo.app1_memo.databinding.ActivityMainBinding
import com.ranggoo.app1_memo.databinding.MainRecyclerRowBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //제목을 담을 arrayList
    val subjectList = ArrayList<String>()

    //작성날짜를 담을 arrayList
    val dateList = ArrayList<String>()

    //메모의 번호를 담을 arrayList
    val idxList = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        SystemClock.sleep(1000)
        setTheme(R.style.Theme_App1_Memo)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Toolbar를 설정
        setSupportActionBar(binding.mainToolbar)
        title = "메모장"

        //recycler 세팅
        val mainRecyclerAdapter=MainRecyclerAdapter()
        binding.mainRecycler.adapter = mainRecyclerAdapter

        binding.mainRecycler.layoutManager = LinearLayoutManager(this)



    }

    override fun onResume() {
        super.onResume()


        //arrayList 비워주기
        subjectList.clear()
        dateList.clear()
        idxList.clear()


        //데이터베이스 오픈
        val helper = DBHelper(this)

        val sql = """
            select memo_subject, memo_date, memo_idx
            from MemoTable
            order by memo_idx desc 
        """.trimIndent()

        val c1 = helper.writableDatabase.rawQuery(sql, null)

        while (c1.moveToNext()) {
            //컬럼 index가져오기
            val idx1 = c1.getColumnIndex("memo_subject")
            val idx2 = c1.getColumnIndex("memo_date")
            val idx3 = c1.getColumnIndex("memo_idx")

            //데이터를 가져온다
            val memoSubject = c1.getString(idx1)
            val memoDate = c1.getString(idx2)
            val memoIdx = c1.getInt(idx3)

            //데이터를 담기
            subjectList.add(memoSubject)
            dateList.add(memoDate)
            idxList.add(memoIdx)


            //recyclerview에게 갱신하라고 명령
            binding.mainRecycler.adapter?.notifyDataSetChanged()

        }
    }

    //옵션메뉴 설정하기

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            //추가버튼
            R.id.main_menu_add -> {
                val memo_add_intent = Intent(this, MemoAddActivity::class.java)
                startActivity(memo_add_intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    //recyclerView 어댑터

    inner class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolderClass>() {

        //HolderClass
        inner class ViewHolderClass(mainRecyclerBinding: MainRecyclerRowBinding) : RecyclerView.ViewHolder(mainRecyclerBinding.root),View.OnClickListener {
            //View에 주소값을 담는다
            val rowMemoSubject = mainRecyclerBinding.memoSubject
            val rowMemoDate = mainRecyclerBinding.memoDate

            override fun onClick(p0: View?) {

                //현재 항목 글의 인덱스 추출
                val memoIdx = idxList[adapterPosition]

               //긁 읽는 Activity 실행

                val memoReadAdapter = Intent(baseContext, MemoReadActivity::class.java)
                memoReadAdapter.putExtra("memo_idx", memoIdx)
                startActivity(memoReadAdapter)
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val mainRecyclerBinding = MainRecyclerRowBinding.inflate(layoutInflater)
            val holder = ViewHolderClass(mainRecyclerBinding)

            //생성되는 항목View의 가로 세로 길이 설정
            val layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, //가로
                ViewGroup.LayoutParams.WRAP_CONTENT //세로

            )
            mainRecyclerBinding.root.layoutParams = layoutParams


            //항목 View의 이벤트 설정
            mainRecyclerBinding.root.setOnClickListener(holder)
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowMemoSubject.text = subjectList[position]
            holder.rowMemoDate.text = dateList[position]
        }

        override fun getItemCount(): Int {
            return subjectList.size
        }
    }


}