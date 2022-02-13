package com.john.episode.util

import java.text.SimpleDateFormat


object DateUtil {
    fun String.toEpisodeDateForm():String{
        val paredDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(this)
        val newDate = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(paredDate)
        return newDate

    }

}