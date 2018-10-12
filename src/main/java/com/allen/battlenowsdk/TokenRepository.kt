package com.allen.battlenowsdk

interface TokenRepository {
    fun getToken(): String?
    fun saveToken(token: String)
}