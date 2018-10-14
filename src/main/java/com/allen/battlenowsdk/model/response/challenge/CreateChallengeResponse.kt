package com.allen.battlenowsdk.model.response.challenge

/**
 * Created by TakayamaAren on 2/24/2018.
 */

data class CreateChallengeResponse(
        val result: String, //ok
        val payload: CreateChallengeResponsePayload
) {
    data class CreateChallengeResponsePayload(
            val id: Int, //64
            val rival: Int, //2
            val time: String, //2018-02-27T17:19:00
            val live_url: String,
            val title: String, //测试挑战236
            val content: String, //测试挑战236
            val type: Int //1
    )
}

