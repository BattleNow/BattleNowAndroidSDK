package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.AuthorizationUtil
import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.exceptions.NeedLoginException
import com.allen.battlenowsdk.model.response.match.*
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody

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

public suspend fun BattleNowClient.userJoinMatch(matchId: Int, body: UserJoinMatchRequestBody) {
    tokenRepository.getToken()?.let {
        matchService.userJoinMatch(matchId, AuthorizationUtil.buildAuthorizationHeader(it), body).await()
    } ?: throw NeedLoginException()
}

public suspend fun BattleNowClient.playerGroupJoinMatch(matchId: Int, body: GroupJoinMatchRequestBody) {
    tokenRepository.getToken()?.let {
        matchService.groupJoinMatch(matchId, AuthorizationUtil.buildAuthorizationHeader(it), body).await()
    } ?: throw NeedLoginException()
}

public suspend fun BattleNowClient.getMatchPlayerGroupMemberList(matchId: Int, matchPlayerGroupId: Int, params: Map<String, String> = mapOf()): ListResponse<GetUserResponseBody> {
    return matchService.getMatchPlayerGroupMembers(matchId, matchPlayerGroupId, params).await()
}
