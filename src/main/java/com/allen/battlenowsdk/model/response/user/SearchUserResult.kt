package com.allen.battlenowsdk.model.response.user
import com.google.gson.annotations.SerializedName



data class SearchUserResult(
		@SerializedName("id") val id: Int,
		@SerializedName("username") val username: String,
		@SerializedName("nickname") val nickname: String,
		@SerializedName("personalize") val personalize: String,
		@SerializedName("challenge_done") val challengeDone: Int,
		@SerializedName("score") val score: Int,
		@SerializedName("avatar") val avatar: String
)