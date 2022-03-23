package com.ywlee.kbapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ywlee.kbapplication.api.KakaoRepository
import com.ywlee.kbapplication.data.ImageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _imageList: MutableLiveData<ImageModel> by lazy {
        MutableLiveData<ImageModel>().also {
            getImages()
        }
    }

    fun getImageList(): LiveData<ImageModel> {
        return _imageList
    }

    fun getImages() {
        viewModelScope.launch(Dispatchers.IO) {
            _imageList.postValue(KakaoRepository.getImages("설현"))
//            KakaoRepository.getImages("설현", object : KakaoRepository.GetDataCallback<ImageModel> {
//                override fun onSuccess(data: ImageModel?) {
//                    _imageList.value = data
//                    Log.d("asdf", "${data.toString()}")
//                }
//
//                override fun onFailure(throwable: Throwable) {
//                    Log.d("asdf", "${throwable.message}")
//                }
//            })
        }
    }
}