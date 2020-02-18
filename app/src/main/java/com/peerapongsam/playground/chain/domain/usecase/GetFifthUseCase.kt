package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.FifthModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetFifthUseCase {
    fun execute(): Observable<FifthModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { FifthModel() }
    }
}