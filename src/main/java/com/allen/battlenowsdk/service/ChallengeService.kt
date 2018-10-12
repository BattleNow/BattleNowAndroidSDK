package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.response.challenge.ChallengeResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*

interface ChallengeService {
    @GET("challenges")
    fun fetchChallengeList(
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<ChallengeResponse>>

    @GET("challenge/{id}")
    fun fetchChallenge(
            @Path("id") challengeId: Int
    ): Deferred<ChallengeResponse>

    @POST("web/challenge/{id}/accept")
    fun acceptChallenge(
            @Path("id") challengeId: Int,
            @Header("Authorization") token: String

    ): Deferred<Any>
}