package com.allen.battlenowsdk.model.response.challenge

/**
 * Created by TakayamaAren on 2/22/2018.
 */


data class ChallengeTypesResult(
        val id: Int, //1
        val name: String, //安全驾驶
        val game: ChallengeTypesGame,
        val game_id: Int //4
) {

    data class ChallengeTypesGame(
            val id: Int, //4
            val name: String, //欧洲卡车模拟2
            val game_series_id: Int //2
    )
}
