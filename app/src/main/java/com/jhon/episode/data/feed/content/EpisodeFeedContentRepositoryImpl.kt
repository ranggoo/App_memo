package com.jhon.episode.data.feed.content

import com.jhon.episode.data.feed.EpisodeFeedDataSource
import com.jhon.episode.data.feed.toEntity
import com.jhon.episode.domain.feed.EpisodeFeedContentRepository
import javax.inject.Inject

class EpisodeFeedContentRepositoryImpl @Inject constructor(
    private val dataSource: EpisodeFeedDataSource
) : EpisodeFeedContentRepository {
    override suspend fun getEpisodeFeedContentList(
        page: Int,
        size: Int,
        search: String?,
        companyType: String?
    ) = dataSource.getEpisodeFeeContentList(
        page = page,
        size = size,
        search = search,
        companyType = companyType
    ).toEntity()


}