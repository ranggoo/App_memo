package com.ranggoo.app1_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainFragment : Fragment() {

    //제목을 담을 arrayList
    val subjectList = ArrayList<String>()

    //작성날짜를 담을 arrayList
    val dateList = ArrayList<String>()

    //메모의 번호를 담을 arrayList
    val idxList = ArrayList<Int>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}