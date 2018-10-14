package com.allen.battlenowsdk.model.requets.challenge

import com.google.gson.annotations.SerializedName

data class CreateChallengeRequestBody(
        val rival: ChallengePlayer,
        @SerializedName("live_url")
        val liveUrl: String,
        val time: String,
        val title: String,
        val content: String,
        val challenger: ChallengePlayer,
        val type: Int,
        val match: Int?
) {
    data class ChallengePlayer(
            @SerializedName("player_type")
            val playerType: String,
            val group: Int?,
            val user: Int?
    )


}