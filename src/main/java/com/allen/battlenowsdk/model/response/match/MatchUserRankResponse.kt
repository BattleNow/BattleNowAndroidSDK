package com.allen.battlenowsdk.model.response.match
import com.google.gson.annotations.SerializedName


data class MatchUserRankResponse(
    val rank: Int,
    @SerializedName("user_id")
    val userId: Int,
    val score: Int,
    val nickname: String,
    val personalize: String,
    val avatar: String
)