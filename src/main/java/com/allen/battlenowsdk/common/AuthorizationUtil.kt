package com.allen.battlenowsdk.common

object AuthorizationUtil {
    public fun buildAuthorizationHeader(token : String): String {
        return "Bearer $token"
    }
}