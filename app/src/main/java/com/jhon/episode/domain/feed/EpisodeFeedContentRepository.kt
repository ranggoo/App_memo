package com.jhon.episode.domain.feed

import com.jhon.episode.domain.feed.entity.EpisodeFeedContentEntity
import com.jhon.episode.domain.feed.entity.EpisodeFeedContentListEntity
import retrofit2.http.Query

interface EpisodeFeedContentRepository {

    suspend fun getEpisodeFeedContentList(
        page:Int,
        size:Int,
        search:String?,
        companyType:String?
    ): EpisodeFeedContentListEntity

}