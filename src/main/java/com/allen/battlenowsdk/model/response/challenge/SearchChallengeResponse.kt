package com.allen.battlenowsdk.model.response.challenge

import com.google.gson.annotations.SerializedName


data class SearchChallengeResponse(
        val id: Int,
        val initiator: Initiator,
        val challenger: Challenger,
        val rival: Rival,
        val title: String,
        val type: Type,
        val content: String,
        val time: String,
        val status: Int,
        val enable: Boolean,
        @SerializedName("live_url")
        val liveUrl: String,
        @SerializedName("create_at")
        val createAt: String,
        @SerializedName("update_at")
        val updateAt: String,
        val views: Int
) {
    data class Initiator(
            val id: Int,
            val username: String,
            val userprofile: Userprofile,
            val email: String
    ) {
        data class Userprofile(
                val nickname: String,
                val personalize: String,
                val avatar: String,
                val phone: Any,
                @SerializedName("verify_by_email")
                val verifyByEmail: Boolean,
                @SerializedName("verify_by_phone")
                val verifyByPhone: Boolean
        )
    }

    data class Rival(
            val id: Int,
            val group: PlayerGroupResponse?,
            val user: User?
    ) {
        data class User(
                val id: Int,
                val username: String,
                val userprofile: Userprofile,
                val email: String
        ) {
            data class Userprofile(
                    val nickname: String,
                    val personalize: String,
                    val avatar: String,
                    val phone: Any,
                    @SerializedName("verify_by_email")
                    val verifyByEmail: Boolean,
                    @SerializedName("verify_by_phone")
                    val verifyByPhone: Boolean
            )
        }
    }

    data class Challenger(
            val id: Int,
            val group: PlayerGroupResponse?,
            val user: User?
    ) {
        data class User(
                val id: Int,
                val username: String,
                val userprofile: Userprofile,
                val email: String
        ) {
            data class Userprofile(
                    val nickname: String,
                    val personalize: String,
                    val avatar: String,
                    val phone: Any,
                    @SerializedName("verify_by_email")
                    val verifyByEmail: Boolean,
                    @SerializedName("verify_by_phone")
                    val verifyByPhone: Boolean
            )
        }
    }

    data class Type(
            val id: Int,
            val name: String,
            val game: Game,
            @SerializedName("game_id")
            val gameId: Int
    ) {
        data class Game(
                val id: Int,
                val name: String,
                @SerializedName("game_series_id")
                val gameSeriesId: Int,
                val cover: String,
                val icon: String
        )
    }

    data class PlayerGroupResponse(
            val id: Int,
            val create_at: String,
            val name: String,
            val leader: Int,
            val icon: String?,
            val members: List<Int>
    )
}