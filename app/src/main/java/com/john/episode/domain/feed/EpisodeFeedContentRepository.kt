package com.john.episode.domain.feed

import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity
import com.john.episode.domain.feed.entity.EpisodeFeedContentListEntity
import retrofit2.http.Query

interface EpisodeFeedContentRepository {
    suspend fun getEpisodeFeedContentList(
        page: Int,
        size: Int,
        search: String?,
        companyType: String?,
    ): EpisodeFeedContentListEntity
}