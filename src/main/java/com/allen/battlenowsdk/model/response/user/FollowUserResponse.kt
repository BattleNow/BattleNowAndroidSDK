package com.allen.battlenowsdk.model.response.user
import com.google.gson.annotations.SerializedName



data class FollowUserResponse(
		@SerializedName("id") val id: Int,
		@SerializedName("from_user") val user: Int,
		@SerializedName("following") val following: Int
)