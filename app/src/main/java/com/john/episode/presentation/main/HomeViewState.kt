package com.john.episode.presentation.main
import com.john.episode.domain.feed.entity.EpisodeFeedContentEntity


/**
 * 메인 화면.
 *
 * @property feedList 피드 리스트.
 */
data class HomeViewState(
    val feedList: List<EpisodeFeedContentEntity>?
) {
    companion object {
        fun initial(): HomeViewState = HomeViewState(
            feedList = emptyList()
        )
    }
}