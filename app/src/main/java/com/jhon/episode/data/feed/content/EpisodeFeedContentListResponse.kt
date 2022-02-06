package com.jhon.episode.data.feed.content

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeFeedContentListResponse(
    val feed_Content_Response_list: List<EpisodeFeedContentResponse>?,
    val is_empty: Boolean?,
    val limit: Int?,
    val offset: Int?,
    val total: Int?
)

@JsonClass(generateAdapter = true)
data class EpisodeFeedContentCategoryResponse(
    val image: String?,
    val location: String?,
    val salary: Int?,
    val type: String?
)

@JsonClass(generateAdapter = true)
data class EpisodeFeedContentImageResponse(
    val displayName: String?,
    val fileExt: String?,
    val filePath: String?,
    val storedName: String?,
    val url: String?
)

@JsonClass(generateAdapter = true)
data class EpisodeFeedContentResponse(
    val feedContentCategoryResponse: EpisodeFeedContentCategoryResponse?,
    val comment_count: Int?,
    val content: String?,
    val feedContent_imageResponse: EpisodeFeedContentImageResponse?,
    val create_time: String?,
    val id: Int?,
    val is_mine: Boolean??,
    val like_count: Int?,
    val contentLike_Response_list: List<EpisodeFeedContentLikeResponse>?,
    val nick_name: String?,
    val title: String?,
    val update_time: String?,
    val views_count: Int?
)

@JsonClass(generateAdapter = true)
data class EpisodeFeedContentLikeResponse(
    val id: Int?,
    val member_id: String?,
    val member_nick_name: String?
)