package com.allen.battlenowsdk.model.response.user

import com.google.gson.annotations.SerializedName


data class UserFollowResponseBody(
        val id: Int,
        @SerializedName("following_username")
        val followingUsername: String,
        @SerializedName("following_nickname")
        val followingNickname: String,
        @SerializedName("following_avatar")
        val followingAvatar: String,
        @SerializedName("user_username")
        val userUsername: String,
        @SerializedName("user_nickname")
        val userNickname: String,
        @SerializedName("user_avatar")
        val userAvatar: String,
        @SerializedName("following_user_id")
        val followingUserId: Int,
        @SerializedName("user_id")
        val userId: Int
)