package com.allen.battlenowsdk.model.response.match

import com.google.gson.annotations.SerializedName

data class MatchResponse(
        val id: Int,
        val summary: String,
        val name: String,
        @SerializedName("start_time")
        val startTime: String,
        @SerializedName("end_time")
        val endTime: String,
        val cover: String,
        @SerializedName("player_count")
        val playerCount: Int
)