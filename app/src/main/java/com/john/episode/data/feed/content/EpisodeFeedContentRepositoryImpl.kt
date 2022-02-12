package com.john.episode.data.feed.content

import com.john.episode.data.feed.EpisodeFeedDataSource
import com.john.episode.data.feed.toEntity
import com.john.episode.domain.feed.EpisodeFeedContentRepository
import javax.inject.Inject

class EpisodeFeedContentRepositoryImpl @Inject constructor(
    private val dataSource: EpisodeFeedDataSource
) : EpisodeFeedContentRepository {
    override suspend fun getEpisodeFeedContentList(
        page: Int,
        size: Int,
        search: String?,
        companyType: String?
    ) = dataSource.getEpisodeFeedContentList(
        page = page,
        size = size,
        search = search,
        companyType = companyType
    ).toEntity()


}