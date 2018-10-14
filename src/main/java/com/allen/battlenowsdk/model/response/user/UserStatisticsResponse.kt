package com.allen.battlenowsdk.model.response.user

import com.google.gson.annotations.SerializedName

/**
 * Created by TakayamaAren on 3/3/2018.
 */

data class UserStatisticsResponse(
        @SerializedName("ranking_score")
        val rankingScore: Int,
        @SerializedName("challenge_create")
        val challengeCreate: Int,
        @SerializedName("challenge_win")
        val challengeWin: Int,
        @SerializedName("challenge_request_received")
        val challengeRequestReceived: Int,
        @SerializedName("challenge_lose")
        val challengeLose: Int,
        @SerializedName("challenge_done")
        val challengeDone: Int,
        @SerializedName("challenge_doubt")
        val challengeDoubt: Int
)