package com.john.episode.presentation.main

import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity


sealed class HomeEpisodeViewItem {
    data class Content(val content: EpisodeFeedContentEntity) : HomeEpisodeViewItem()
    data class Date(val date: String?) : HomeEpisodeViewItem()
}


/**
 * 메인 화면.
 *
 * @property feedList 피드 리스트.
 */
data class HomeViewState(
    val feedList: List<HomeEpisodeViewItem>?
) {
    companion object {
        fun initial(): HomeViewState = HomeViewState(
            feedList = null
        )
    }
}