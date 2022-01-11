package com.ranggoo.app1_memo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoModifyBinding


class MemoModifyFragment : Fragment() {

    private var _binding: FragmentMemoModifyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val helpers = DBHelper(requireContext())

        val sql = """
            select memo_subject, memo_text
            from MemoTable
            where memo_idx = ?
        """.trimIndent()

        val memoIdx = activity?.intent?.getIntExtra("memo_idx", 0)

        var args = arrayOf(memoIdx.toString())

        val c1 = helpers.writableDatabase.rawQuery(sql, args)
        c1.moveToNext()

        val idx1 = c1.getColumnIndex("memo_subject")
        val idx2 = c1.getColumnIndex("memo_text")

        val memoSubject = c1.getString(idx1)
        val memoText = c1.getString(idx2)

        helpers.writableDatabase.close()

        _binding =FragmentMemoModifyBinding.inflate(inflater, container, false)

        binding.btnModifyBack.setOnClickListener{
            findNavController().navigate(R.id.action_memoModifyFragment_to_memoReadFragment)
        }
        binding.btnModifySave.setOnClickListener {
            findNavController().navigate(R.id.action_memoModifyFragment_to_memoReadFragment)
            Toast.makeText(context,"기록이 수정되었습니다", Toast.LENGTH_SHORT).show()
        }

        return binding.root


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                activity?.finish()
            }

            //저장
            R.id.btn_save ->{

                val helper = DBHelper(requireContext())

                val sql = """
                    update MemoTable
                    set memo_subject = ? , memo_text = ?
                    where memo_idx = ?
                  
                """.trimIndent()

                val memoSubject = binding.memoModifySubject.text
                val memoText = binding.memoModifyText.text
                val memoIdx = activity?.intent?.getIntExtra("memo_idx", 0)

                var args = arrayOf(memoSubject, memoText, memoIdx.toString())

                helper.writableDatabase.execSQL(sql,args)
                helper.writableDatabase.close()

                activity?.finish()

            }
        }


        return super.onOptionsItemSelected(item)
    }



}