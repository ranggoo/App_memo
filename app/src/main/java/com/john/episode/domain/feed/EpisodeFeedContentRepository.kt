package com.john.episode.domain.feed

import com.john.episode.domain.feed.entity.EpisodeFeedContentListEntity

interface EpisodeFeedContentRepository {

    suspend fun getEpisodeFeedContentList(
        page:Int,
        size:Int,
        search:String?,
        companyType:String?
    ): EpisodeFeedContentListEntity

}