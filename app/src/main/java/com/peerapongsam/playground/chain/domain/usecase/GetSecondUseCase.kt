package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.SecondModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetSecondUseCase {
    fun execute(): Observable<SecondModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { SecondModel() }
    }
}