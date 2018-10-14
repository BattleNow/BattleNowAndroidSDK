package com.allen.battlenowsdk.model.response.group

import com.google.gson.annotations.SerializedName

data class PlayerGroupStatisticsResult(
        @SerializedName("last_update_ranking")
        val lastUpdateRanking: String,
        @SerializedName("rank_score")
        val rankScore: Int,
        @SerializedName("challenge_win")
        val challengeWin: Int,
        @SerializedName("challenge_done")
        val challengeDone: Int,
        @SerializedName("challenge_doubt")
        val challengeDoubt: Int,
        @SerializedName("challenge_lose")
        val challengeLose: Int,
        val group: Int
)