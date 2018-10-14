package com.allen.battlenowsdk.model.response.match

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GroupJoinMatchRequestBody(
        val group: Int,
        @SerializedName("group_members")
        val members: List<Int>
)