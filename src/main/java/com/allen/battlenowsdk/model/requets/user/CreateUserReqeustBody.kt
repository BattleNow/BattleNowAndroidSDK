package com.allen.battlenowsdk.model.requets.user

import com.google.gson.annotations.SerializedName

/**
 * Created by TakayamaAren on 2/25/2018.
 */

data class CreateUserReqeustBody(
        @SerializedName("email")
        val email: String,
        val username: String, //takayamaaren@gmail.com
        val password: String //4399123
)