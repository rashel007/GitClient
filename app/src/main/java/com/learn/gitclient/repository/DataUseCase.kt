package com.learn.gitclient.repository

import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.network.NetworkState
import java.io.Serializable
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class DataUseCase @Inject constructor(private val  dataRepository: DataRepository) {


    suspend fun getRepositoriesList(): NetworkState<GithubDataModel> {
        val repositoryList = dataRepository.getData()


        val resultData = if (!repositoryList.isNullOrEmpty()) {
            NetworkState.SUCCESS(repositoryList)
        }else {
          NetworkState.API_ERROR("Failed")
        }

        return resultData as NetworkState<GithubDataModel>
    }
}