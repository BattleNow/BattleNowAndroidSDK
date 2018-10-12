package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.response.match.MatchResponse

public suspend fun BattleNowClient.getMatchList(params: Map<String, String>): ListResponse<MatchResponse> {
    return matchService.fetchMatches(params).await()
}