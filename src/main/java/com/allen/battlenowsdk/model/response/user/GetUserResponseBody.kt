package com.allen.battlenowsdk.model.response.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetUserResponseBody(
        val id: Int,
        val username: String,
        val userprofile: UserProfileResponse
) {
    data class UserProfileResponse(
            var nickname: String,
            val personalize: String?,
            val avatar: String,
            val phone: String,
            @SerializedName("verify_by_email")
            val verifyByEmail: Boolean,
            @SerializedName("verify_by_phone")
            val verifyByPhone: Boolean
    ) : Serializable
}