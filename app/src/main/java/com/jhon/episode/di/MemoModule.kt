package com.jhon.episode.di

import com.jhon.episode.data.MemoRepositoryImpl
import com.jhon.episode.data.db.DBHelper
import com.jhon.episode.domain.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object MemoModule {
    @Provides
    fun provideMemoDb():DBHelper{
        return DBHelper()
    }
}
@InstallIn(SingletonComponent::class)
@Module
abstract class MemoRepositoryModule{
    @Binds
    abstract fun bindsMemoRepository(repositoryImpl: MemoRepositoryImpl):MemoRepository
    //인터페이스 구현체를 임플로 쓰겠다라는 의미
}