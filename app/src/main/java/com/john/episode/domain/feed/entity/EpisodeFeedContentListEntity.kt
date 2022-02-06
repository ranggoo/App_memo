package com.john.episode.domain.feed.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class EpisodeFeedContentListEntity(
    val feed_list: List<EpisodeFeedContentEntity>?,
    val is_empty: Boolean?,
    val limit: Int?,
    val offset: Int?,
    val total: Int?
):Parcelable

@Parcelize
data class EpisodeFeedContentCategoryEntity(
    val image: String?,
    val location: String?,
    val salary: Int?,
    val type: String?
):Parcelable

@Parcelize
data class EpisodeFeedContentImageEntity(
    val displayName: String?,
    val fileExt: String?,
    val filePath: String?,
    val storedName: String?,
    val url: String?
):Parcelable

@Parcelize
data class EpisodeFeedContentEntity(
    val category: EpisodeFeedContentCategoryEntity?,
    val comment_count: Int?,
    val content: String?,
    val content_image: EpisodeFeedContentImageEntity?,
    val create_time: String?,
    val id: Int?,
    val is_mine: Boolean??,
    val like_count: Int?,
    val like_list: List<EpisodeFeedContentLikeEntity>?,
    val nick_name: String?,
    val title: String?,
    val update_time: String?,
    val views_count: Int?
):Parcelable

@Parcelize
data class EpisodeFeedContentLikeEntity(
    val id: Int?,
    val member_id: String?,
    val member_nick_name: String?
):Parcelable