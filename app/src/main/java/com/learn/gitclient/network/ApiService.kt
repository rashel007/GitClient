package com.learn.gitclient.network

import com.learn.gitclient.model.GithubDataModel
import com.learn.gitclient.utils.NetworkConstance
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkConstance.URL_QUERY_REPOSITORY)
    suspend fun getData() : GithubDataModel
}