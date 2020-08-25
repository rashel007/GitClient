package com.learn.gitclient.repository

import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor( private  val apiService: ApiService) {

    suspend fun getData(): GithubDataModel {
        return apiService.getData()
    }
}