package com.allen.battlenowsdk.model.response.match

import com.google.gson.annotations.SerializedName

data class MatchPlayerGroupRankResponse(
        val rank: Int,
        @SerializedName("match_play_group_id")
        val matchPlayGroupId: Int,
        val score: Int,
        val name: String,
        val icon: String
)