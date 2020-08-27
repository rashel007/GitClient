package com.learn.gitclient.repository

import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.network.ApiService
import com.learn.gitclient.network.DataState
import java.lang.Exception
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDataList(): DataState<GithubDataModel> {

        try {
            val response = apiService.getGitRepositoryList()

            return if (response.isSuccessful) {
                DataState.SUCCESS(response.body()!!)
            } else {
                DataState.FAILURE(response.code(), "Failed")
            }
        } catch (exception: Exception) {
            return DataState.EXCEPTION("Something went wrong")
        }


    }

}