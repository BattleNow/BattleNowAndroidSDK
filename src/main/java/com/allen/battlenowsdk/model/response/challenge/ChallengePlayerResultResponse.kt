package com.allen.battlenowsdk.model.response.challenge

import com.google.gson.annotations.SerializedName



data class ChallengePlayerResultResponse(
        @SerializedName("challenge_id")
        val challengeId: Int,
        @SerializedName("player_id")
        val playerId: Int,
        @SerializedName("create_at")
        val createAt: String,
        val result: Int
)