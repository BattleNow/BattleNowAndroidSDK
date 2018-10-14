package com.allen.battlenowsdk.model.response.game

import com.google.gson.annotations.SerializedName


data class SearchGameResult(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("series_name") val seriesName: String,
        @SerializedName("series_id") val seriesId: Int,
        @SerializedName("cover") val cover: String,
        @SerializedName("icon") val icon: String
)