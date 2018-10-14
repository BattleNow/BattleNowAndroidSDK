package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.response.match.*
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*

interface MatchService {
    @GET("match/list")
    fun fetchMatches(
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<MatchResponse>>

    @GET("match/{matchId}/group/rank")
    fun getMatchPlayerGroupRank(
            @Path("matchId") matchId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<MatchPlayerGroupRankResponse>>

    @GET("match/{matchId}/user/rank")
    fun getMatchUserRank(
            @Path("matchId") matchId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<MatchUserRankResponse>>

    @GET("match/{matchId}/players")
    fun getMatchPlayerList(
            @Path("matchId") matchId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<GetUserResponseBody>>

    @GET("match/{matchId}/groups")
    fun getMatchPlayerGroupList(
            @Path("matchId") matchId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<MatchPlayerGroupResponse>>

    @PUT("match/{matchId}/join")
    fun userJoinMatch(
            @Path("matchId") matchId: Int,
            @Header("Authorization") token: String,
            @Body requestBody: UserJoinMatchRequestBody
    ): Deferred<Any>

    @PUT("match/{matchId}/join")
    fun groupJoinMatch(
            @Path("matchId") matchId: Int,
            @Header("Authorization") token: String,
            @Body requestBody: GroupJoinMatchRequestBody
    ): Deferred<Any>

    @GET("match/{matchId}/group/{groupId}/members")
    fun getMatchPlayerGroupMembers(
            @Path("matchId") matchId: Int,
            @Path("groupId") matchGroupId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<GetUserResponseBody>>
}