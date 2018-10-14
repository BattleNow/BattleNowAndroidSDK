package com.allen.battlenowsdk.model.requets.user

import com.google.gson.annotations.SerializedName

/**
 * Created by TakayamaAren on 2/26/2018.
 */

data class ChangePasswordRequestBody(
        val username: String,
        @SerializedName("prev_password")
        val prev_password: String,
        @SerializedName("new_password")
        val newPassword: String
)