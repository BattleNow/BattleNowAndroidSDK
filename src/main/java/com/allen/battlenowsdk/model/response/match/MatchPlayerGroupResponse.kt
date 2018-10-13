package com.allen.battlenowsdk.model.response.match
import com.google.gson.annotations.SerializedName


data class MatchPlayerGroupResponse(
        val id: Int,
        @SerializedName("player_group")
    val group: Group,
        val members: List<Int>,
        @SerializedName("create_at")
    val createAt: String
) {
    data class Group(
        val id: Int,
        val icon: String,
        val name: String,
        val leader: Int
    )
}