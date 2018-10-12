package com.allen.battlenowsdk.model.response.group

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlayerGroupResponse(
        val id: Int,
        @SerializedName("create_at")
        val createAt: String,
        val name: String,
        val leader: Int,
        val icon: String?,
        val members: List<Int>
) : Serializable