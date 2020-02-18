package com.peerapongsam.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peerapongsam.playground.chain.domain.usecase.GetFirstUseCase
import com.peerapongsam.playground.chain.presentation.ChainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var chainViewModel: ChainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return ChainViewModel(
                    getFirstUseCase = GetFirstUseCase()
                ) as T
            }
        }).get(ChainViewModel::class.java)


        chainViewModel.loadData()

        chainViewModel.firstLiveData.observe(this, Observer {
            firstTextView.text = it.toString()
        })

        chainViewModel.secondLiveData.observe(this, Observer {
            secondTextView.text = it.toString()
        })

        chainViewModel.thirdLiveData.observe(this, Observer {
            thirdTextView.text = it.toString()
        })

        chainViewModel.fourthLiveData.observe(this, Observer {
            fourthTextView.text = it.toString()
        })

        chainViewModel.fifthLiveData.observe(this, Observer {
            fifthTextView.text = it.toString()
        })

        chainViewModel.sixthLiveData.observe(this, Observer {
            sixthTextView.text = it.toString()
        })
    }
}
