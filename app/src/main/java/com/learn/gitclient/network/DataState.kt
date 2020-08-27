package com.learn.gitclient.network

sealed class DataState<out T> {
    data class SUCCESS<out T>(val data: T) : DataState<T>()
    data class FAILURE(val code: Int?, val error: String = "Failed") : DataState<Nothing>()
    data class EXCEPTION(val error: String = "Something went wrong") : DataState<Nothing>()
    object LOADING : DataState<Nothing>()
}