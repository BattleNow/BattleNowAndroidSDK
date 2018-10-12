package com.allen.battlenowsdk.model.response.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserLoginResponseBody(
        var Payload: UserLoginPayload
) {
    data class UserLoginPayload(
            var token: String,
            var uid: Int,
            var username: String
    )

    data class UserProfile(
            val nickname: String,
            val personalize: String
    )

    data class FetchUserResponse(
            val id: Int,
            val username: String,
            val userprofile: UserProfile
    )

    data class AvatarResponse(
            val user: Int,
            val avatar: String
    )

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

