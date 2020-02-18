package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.SixthModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetSixthUseCase {
    fun execute(): Observable<SixthModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { SixthModel() }
    }
}