package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.FourthModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetFourthUseCase {
    fun execute(): Observable<FourthModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { FourthModel() }
    }
}