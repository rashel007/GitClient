package com.learn.gitclient.network

import retrofit2.http.GET

interface ApiService {

    @GET
    fun getData()
}