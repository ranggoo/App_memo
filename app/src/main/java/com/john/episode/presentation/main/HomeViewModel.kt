package com.john.episode.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.john.episode.domain.feed.usecase.EpisodeGetFeedContentListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEpisodeContentListUseCase: EpisodeGetFeedContentListUseCase
) : ViewModel() {

    private val _feedList = MutableStateFlow(HomeViewState.initial())
    val feedList = _feedList.asStateFlow()

    init {
        getEpisodeContentList(
            page = 0,
            size = 30,
        )
    }

    fun getEpisodeContentList(
        page: Int,
        size: Int,
        search: String? = null,
        companyType: String? = null,
    ) = viewModelScope.launch {
        kotlin.runCatching {
            val feedList = getEpisodeContentListUseCase(
                page = page,
                size = size,
                search = search,
                companyType = companyType
            )
            _feedList.update { prevState ->
                prevState.copy(
                    feedList = feedList.feed_list
                )
            }
        }.onFailure {
            Timber.tag("FeedList").d("Error:: ${it.localizedMessage}")
        }
    }


}
