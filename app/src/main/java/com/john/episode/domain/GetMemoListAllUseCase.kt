package com.john.episode.domain

import javax.inject.Inject

class GetMemoListAllUseCase @Inject constructor(
    private val repository: MemoRepository
) {
    //GetMemoListAllUseCase()로 호출 가능
    operator fun invoke():List<MemoEntity>{
        return repository.readAll()
    }
}