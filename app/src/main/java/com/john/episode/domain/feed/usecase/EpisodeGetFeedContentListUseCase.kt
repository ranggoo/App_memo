package com.john.episode.domain.feed.usecase

import com.john.episode.domain.feed.EpisodeFeedContentRepository
import javax.inject.Inject

class EpisodeGetFeedContentListUseCase @Inject constructor(
    private val repository: EpisodeFeedContentRepository
) {
    suspend operator fun invoke(
        page: Int,
        size: Int,
        search: String? ,
        companyType: String?
    ) = repository.getEpisodeFeedContentList(
        page = page,
        size = size,
        search = search,
        companyType = companyType
    )
}