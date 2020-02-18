package com.peerapongsam.playground.chain.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peerapongsam.playground.chain.domain.model.*
import com.peerapongsam.playground.chain.domain.usecase.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChainViewModel(
    private val getFirstUseCase: GetFirstUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val firstLiveData = MutableLiveData<FirstModel>()
    val secondLiveData = MutableLiveData<SecondModel>()
    val thirdLiveData = MutableLiveData<ThirdModel>()
    val fourthLiveData = MutableLiveData<FourthModel>()
    val fifthLiveData = MutableLiveData<FifthModel>()
    val sixthLiveData = MutableLiveData<SixthModel>()

    fun loadData() {
        val disposable = GetFirstUseCase().execute()
            .doOnNext { firstLiveData.postValue(it) }
            .flatMap { GetSecondUseCase().execute() }
            .doOnNext { secondLiveData.postValue(it) }
            .flatMap { GetThirdUseCase().execute() }
            .doOnNext { thirdLiveData.postValue(it) }
            .flatMap { GetFourthUseCase().execute() }
            .doOnNext { fourthLiveData.postValue(it) }
            .flatMap { GetFifthUseCase().execute() }
            .doOnNext { fifthLiveData.postValue(it) }
            .flatMap { GetSixthUseCase().execute() }
            .doOnNext { sixthLiveData.postValue(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ success ->
                Log.d("ChainViewModel", "loadData() called with: success = [$success]")
            }, { error ->
                Log.d("ChainViewModel", "loadData() called with: error = [$error]")
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}