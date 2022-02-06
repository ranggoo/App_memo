package com.jhon.episode.di

import androidx.viewbinding.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

//typealias EpisodeSet<T> = @JvmSuppressWildcards Set<T>

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private const val NAME_EPISODE_BASE_URL = "NAME_EPISODE_BASE_URL"
    private const val EPISODE_BASE_URL = "http://3.34.117.184:9000/"

    @Provides
    @Named(NAME_EPISODE_BASE_URL)
    fun provideEpisodeUrl(): String = EPISODE_BASE_URL

    @Provides
    @Singleton
    fun provideLoggingIntercepter(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY

                //디버그 모드일 때 로그 찍으려고 확인함!!
            }
        }
    }

//    //okhttp는 레트로핏 띄울 때 사용함
//    @Provides
//    fun provideOkHttpClientBuilder(
//        okHttpClient: Lazy<OkHttpClient>
//    ): OkHttpClient.Builder = okHttpClient.value.newBuilder()


    @Provides
    @Singleton
    fun provideBaseOkHttpClient(
//        interceptor: EpisodeSet<Interceptor>,
    httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        interceptors().add(httpLoggingInterceptor)
    //       interceptors().addAll(interceptor)
    }.run {
        build()
    }

    //request(요청) -> (((가로채다/핸들링하다))) -> response(응답)


    //api호출 -> retrofit(okhttp) -> 서버
    //okhttp의 역할은 로그를 찍고, 인터셉터 설정해서 중간에 request나 response를 가로채서 확인할 수 있다
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @Named(NAME_EPISODE_BASE_URL) baseUrl: String
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

    }

}