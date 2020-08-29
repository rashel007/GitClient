package com.learn.gitclient

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.network.DataState
import com.learn.gitclient.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val dataRepository: DataRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _publicRepoList: MutableLiveData<DataState<GithubDataModel>> = MutableLiveData()
    val publicRepoList: LiveData<DataState<GithubDataModel>>
        get() = _publicRepoList
//
//
//    private val _erroMessage: MutableLiveData<String> = MutableLiveData()
//    val errorMessage: LiveData<String>
//        get() = _erroMessage
//
//    fun getData(): LiveData<DataState<GithubDataModel>> {
//        return liveData(Dispatchers.IO) {
//            emit(DataState.LOADING)
//            val result = dataRepository.getDataList()
//            emit(result)
//        }
//    }

    fun getData() = viewModelScope.launch {
        dataRepository.getDataList().onEach {
            dataState -> _publicRepoList.value = dataState
        }.launchIn(viewModelScope)
    }

}