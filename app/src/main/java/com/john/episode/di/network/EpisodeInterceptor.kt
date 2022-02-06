package com.john.episode.di.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.URLDecoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodeInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // original api request.
        val original = chain.request()
        val originalHttpUrl = original.url
        val url = originalHttpUrl.newBuilder().build()

        // accessToken과 여러가지를 붙인 request.
        val newRequestBuilder = original
            .newBuilder()
            .url(url)
            .apply {
                addHeader(AUTHORIZATION, BEARER + "accessToken")
                addHeader("Content-Type", "application/json; charset=utf-8")
                addHeader("Accept", "application/json; charset=utf-8")
                method(original.method, original.body)
            }

        // 리퀘스트를 만듬.
        val request = newRequestBuilder.build()
        // 리스폰스를 받아옴.
        val response = chain.proceed(request)

        // 한글 컨버팅.
        return response.newBuilder()
            .body(
                URLDecoder.decode(response.body?.string(), "utf-8")
                    .toResponseBody(response.body?.contentType())
            ).build();
    }

    companion object {
        const val BEARER = "Bearer "
        const val AUTHORIZATION = "Authorization"
    }

}