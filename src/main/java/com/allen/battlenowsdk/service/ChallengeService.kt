package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.requets.challenge.CreateChallengeRequestBody
import com.allen.battlenowsdk.model.response.challenge.*
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

    @GET("challenges/types")
    fun fetchChallengeTypes(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<ChallengeTypesResult>>


    @POST("web/challenge/create")
    fun createChallenge(
            @Body body: CreateChallengeRequestBody,
            @Header("Authorization") token: String
    ): Deferred<CreateChallengeResponse>

    @GET("/challenge/{cid}/result")
    fun fetchChallengeResult(
            @Path("cid") challengeId: Int
    ): Deferred<ListResponse<ChallengePlayerResultResponse>>

    @GET("/web/challenge/search")
    fun searchChallenge(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<SearchChallengeResponse>>

    @POST("challenge/{challengeId}/result/upload")
    fun uploadChallengeResult(
            @Path("challengeId") challengeId: Int,
            @Header("Authorization") token: String,
            @Body body: UploadChallengeResultRequestBody
    ): Deferred<Any>
}