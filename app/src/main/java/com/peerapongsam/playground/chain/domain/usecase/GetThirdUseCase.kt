package com.peerapongsam.playground.chain.domain.usecase

import com.peerapongsam.playground.chain.domain.model.ThirdModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GetThirdUseCase {
    fun execute(): Observable<ThirdModel> {
        return Observable
            .timer(3, TimeUnit.SECONDS)
            .map { ThirdModel() }
    }
}