package com.jhon.episode.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemoEntity(
    val id: Long,
    val title: String,
    val content: String
) : Parcelable