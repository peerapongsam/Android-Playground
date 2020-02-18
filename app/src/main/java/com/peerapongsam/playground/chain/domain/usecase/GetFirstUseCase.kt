package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.FirstModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetFirstUseCase {
    fun execute(): Observable<FirstModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { FirstModel() }
    }
}