package com.ranggoo.app1_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoAdd1Binding
import java.text.SimpleDateFormat
import java.util.*


class MemoAddFragment : Fragment() {

    private var _binding: FragmentMemoAdd1Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMemoAdd1Binding.inflate(inflater, container, false)

        binding.btnAddBack.setOnClickListener {
            findNavController().navigate(R.id.action_memoAddFragment_to_mainFragment)
        }
        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.action_memoAddFragment_to_mainFragment)
            Toast.makeText(context, "저장되었습니다", Toast.LENGTH_SHORT).show()
        }

        return binding.root


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            //저장버튼
            R.id.btn_save -> {
                //사용자가 입력한 내용 가지고 온다.
                val memoSubject = binding.addMemoSubject.text
                val memoText = binding.addMemoText.text

                //쿼리문
                val sql = """
                    insert into MemoTable (memo_subject, memo_text, memo_date)
                    values(?, ?, ?)
                """.trimIndent()

                //데이터베이스 오픈
                val helper = DBHelper(requireContext())

                //현재시간을 구하기
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val now = sdf.format(Date())

                //?에 세팅될 값
                var arg1 = arrayOf(memoSubject,memoText,now)

                //저장
                helper.writableDatabase.execSQL(sql,arg1)


                //데이타베이스 닫기
                helper.writableDatabase.close()
                activity?.finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }



}