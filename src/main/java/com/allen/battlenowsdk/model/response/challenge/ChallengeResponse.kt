package com.allen.battlenowsdk.model.response.challenge

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChallengeResponse(
        val id: Int, //1
        val challenger: ChallengePlayer,
        val rival: ChallengePlayer,
        val title: String, //测试挑战
        val type: Type,
        val content: String, //测试挑战
        val time: String, //2017-12-10 09:46:00
        var status: Int, //4
        val enable: Boolean, //true
        @SerializedName("live_url")
        val liveUrl: String, //http://www.baidu.com
        @SerializedName("create_at")
        val createAt: String, //2017-12-29 04:29:25
        @SerializedName("update_at")
        val updateAt: String //2017-12-30 05:55:37
) : Serializable {
    data class Type(
            val id: Int, //2
            val name: String, //限时运输
            val game: Game,
            val game_id: Int //4
    ) : Serializable

    data class Game(
            val id: Int, //4
            val name: String, //欧洲卡车模拟2
            @SerializedName("game_series_id")
            val gameSeriesName: Int, //2
            val cover: String,
            val icon: String
    ) : Serializable

    data class ChallengePlayer(
            val id: Int,
            val user: Int?,
            @SerializedName("group")
            val groupId: Int?

    )
}




