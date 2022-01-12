package com.ranggoo.app1_memo

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private var count = 0

    fun getCurrentCount():Int{
        return count
    }

    fun getUpdatedCount():Int{
        return ++count
    }
}