package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.response.match.MatchResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MatchService {
    @GET("match/list")
    fun fetchMatches(
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<MatchResponse>>
}