package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.response.match.MatchPlayerGroupRankResponse
import com.allen.battlenowsdk.model.response.match.MatchResponse
import com.allen.battlenowsdk.model.response.match.MatchUserRankResponse
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import com.allen.battlenowsdk.model.response.match.MatchPlayerGroupResponse

public suspend fun BattleNowClient.getMatchList(params: Map<String, String>): ListResponse<MatchResponse> {
    return matchService.fetchMatches(params).await()
}

public suspend fun BattleNowClient.getMatchPlayerGroupRankList(
        matchId: Int,
        params: Map<String, String> = mapOf()
): ListResponse<MatchPlayerGroupRankResponse> {
    return matchService.getMatchPlayerGroupRank(matchId, params).await()
}

public suspend fun BattleNowClient.getMatchUserRankList(
        matchId: Int,
        params: Map<String, String> = mapOf()
): ListResponse<MatchUserRankResponse> {
    return matchService.getMatchUserRank(matchId, params).await()
}

public suspend fun BattleNowClient.getMatchUserList(
        matchId: Int,
        params: Map<String, String> = mapOf()
): ListResponse<GetUserResponseBody> {
    return matchService.getMatchPlayerList(matchId, params).await()
}

public suspend fun BattleNowClient.getMatchPlayerGroupList(
        matchId: Int,
        params: Map<String, String> = mapOf()
): ListResponse<MatchPlayerGroupResponse> {
    return matchService.getMatchPlayerGroupList(matchId, params).await()
}