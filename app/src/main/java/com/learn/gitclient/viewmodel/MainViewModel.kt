package com.learn.gitclient.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.network.NetworkState
import com.learn.gitclient.repository.DataUseCase


class MainViewModel @ViewModelInject constructor(private val dataUseCase: DataUseCase): ViewModel() {


    fun getRepositoryList(): LiveData<NetworkState<GithubDataModel>> {

       return liveData<NetworkState<GithubDataModel>> {
            emit(NetworkState.LOADING)
            emit(dataUseCase.getRepositoriesList())
        }
    }
}