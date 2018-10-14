package com.allen.battlenowsdk.model.response.group

import com.allen.battlenowsdk.model.response.group.PlayerGroupResponse
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import com.google.gson.annotations.SerializedName

data class PlayerGroupApplyResponseBody(
        val id: Int,
        @SerializedName("player_group")
        val playerGroup: PlayerGroupResponse,
        @SerializedName("apply_user")
        val applyUser: GetUserResponseBody,
        val state: String,
        @SerializedName("create_at")
        val createAt: String
) {
}