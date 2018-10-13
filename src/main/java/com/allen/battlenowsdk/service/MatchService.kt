package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.response.match.MatchPlayerGroupRankResponse
import com.allen.battlenowsdk.model.response.match.MatchResponse
import com.allen.battlenowsdk.model.response.match.MatchUserRankResponse
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import com.allen.battlenowsdk.model.response.match.MatchPlayerGroupResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

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
}