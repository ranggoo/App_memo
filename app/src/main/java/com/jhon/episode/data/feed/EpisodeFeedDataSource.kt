package com.jhon.episode.data.feed

import com.jhon.episode.data.feed.content.EpisodeFeedContentListResponse
import com.jhon.episode.data.feed.content.EpisodeFeedContentResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeFeedDataSource {

    /*
    피드 전체 조회

    @param page 페이지 ex) 0,1,2...
    @param size 페이지 당 리스트 갯수 ex) 20,30...
    @param search 검색어
    @param companyType ex)MAJOR, FREELANCER


     */
    @GET("/feed/content/v1/retrieve/all")
    suspend fun getEpisodeFeeContentList(
        @Query("page") page:Int,
        @Query("size") size:Int,
        @Query("search") search:String?,
        @Query("company_type") companyType:String?
    ): EpisodeFeedContentListResponse
}