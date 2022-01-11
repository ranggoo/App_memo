package com.ranggoo.app1_memo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoReadBinding

class MemoReadFragment : Fragment() {

    private var _binding : FragmentMemoReadBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentMemoReadBinding.inflate(inflater, container, false)

        binding.btnDelete.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_mainFragment)

            Toast.makeText(context,"기록이 삭제되었습니다", Toast.LENGTH_SHORT).show()
        }

        binding.btnModify.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_memoModifyFragment)

        }

        binding.btnReadBack.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_mainFragment)

        }
        binding.btnShare.setOnClickListener {

            //자료 찾아보고 넣어보기!!
        }



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val helper = DBHelper(this)

        val sql = """
            select memo_subject, memo_date, memo_text
            from MemoTable
            where memo_idx = ?
        """.trimIndent()

        //글번호 출력
        val memoIdx = intent.getIntExtra("memo_idx", 0)

        //쿼리 실행
        val args = arrayOf(memoIdx.toString())
        val c1 = helper.writableDatabase.rawQuery(sql, args)
        c1.moveToNext()

        //글 데이터 추출한다
        val idx1 = c1.getColumnIndex("memo_subject")
        val idx2 = c1.getColumnIndex("memo_date")
        val idx3 = c1.getColumnIndex("memo_text")

        val memoSubject = c1.getString(idx1)
        val memoDate = c1.getString(idx2)
        val memoText = c1.getString(idx3)

        helper.writableDatabase.close()


        binding.memoReadSubject.text = "제목 : $memoSubject"
        binding.memoReadDate.text = "작성일자 : $memoDate"
        binding.memoReadText.text = memoText


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }

            //메뉴수정
            R.id.btn_modify ->{

                var memoModifyIntent = Intent(this, MemoModifyFragment::class.java)

                //글 번호를 담는다
                val memoIdx = intent.getIntExtra("memo_idx",0)
                memoModifyIntent.putExtra("memo_idx",memoIdx)

                startActivity(memoModifyIntent)

            }
            //메뉴 삭제
            R.id.btn_delete ->{

                var builder = AlertDialog.Builder(this)

                builder.setTitle("메모삭제")
                builder.setMessage("삭제하겠습니까?")
                builder.setIcon(R.mipmap.ic_launcher)

                builder.setPositiveButton("삭제"){dialogInterface, i ->

                    //데이터 베이스 오픈
                    val helper = DBHelper(this)

                    val sql = """
                        delete from MemoTable
                        where memo_idx = ?
                    """.trimIndent()

                    //글번호 가져오기
                    val memoIdx = intent.getIntExtra("memo_idx", 0)

                    //쿼리문 실행
                    var args = arrayOf(memoIdx.toString())

                    helper.writableDatabase.execSQL(sql,args)
                    helper.writableDatabase.close()

                    finish()



                }
                builder.setNegativeButton("취소",null)

                builder.show()


            }
        }


        return super.onOptionsItemSelected(item)
    }
}