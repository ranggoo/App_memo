package com.john.episode.data.feed

import com.john.episode.data.feed.content.EpisodeFeedContentListResponse
import com.john.episode.domain.feed.entity.*

fun EpisodeFeedContentListResponse.toEntity(): EpisodeFeedContentListEntity {
    return EpisodeFeedContentListEntity(
        feed_list = feed_list?.map {
            EpisodeFeedContentEntity(
                category = EpisodeFeedContentCategoryEntity(
                    image = it.category?.image,
                    location = it.category?.location,
                    salary = it.category?.salary,
                    type = it.category?.type
                ),
                comment_count = it.comment_count,
                content = it.content,
                content_image = EpisodeFeedContentImageEntity(
                    displayName = it.content_image?.displayName,
                    fileExt = it.content_image?.fileExt,
                    filePath = it.content_image?.filePath,
                    storedName = it.content_image?.storedName,
                    url = it.content_image?.url
                ),
                create_time = it.create_time,
                id = it.id,
                is_mine = it.is_mine,
                like_count = it.like_count,
                like_list = it.like_list?.map {
                    EpisodeFeedContentLikeEntity(
                        id = it.id,
                        member_id = it.member_id,
                        member_nick_name = it.member_nick_name
                    )
                },
                nick_name = it.nick_name,
                title = it.title,
                update_time = it.update_time,
                views_count = it.views_count
            )
        },
        is_empty = is_empty,
        limit = limit,
        offset = offset,
        total = total
    )
}

