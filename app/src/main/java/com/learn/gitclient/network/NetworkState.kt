package com.learn.gitclient.network

sealed class NetworkState<out T> {
    data class SUCCESS<out T>(val data: T) : NetworkState<T>()
    data class API_ERROR(val error: String) : NetworkState<String>()
    data class SERVER_ERROR(val error: String) : NetworkState<String>()
    object LOADING : NetworkState<Nothing>()
}