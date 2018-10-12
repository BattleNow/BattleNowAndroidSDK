package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.exceptions.NeedLoginException
import com.allen.battlenowsdk.model.response.challenge.ChallengeResponse

/**
 * get challenge list
 * @param queryParam query parameter map
 */
public suspend fun BattleNowClient.getChallengeList(queryParam: Map<String, String>): ListResponse<ChallengeResponse> {
    return challengeService.fetchChallengeList(queryParam).await()
}

/**
 * get single result challenge by id
 */
public suspend fun BattleNowClient.getChallenge(challengeId: Int): ChallengeResponse {
    return challengeService.fetchChallenge(challengeId).await()
}

/**
 * accept challenge
 * @param challengeId challenge id
 * @throws NeedLoginException  you must login before do it
 */
public suspend fun BattleNowClient.acceptChallenge(challengeId: Int): Any {

    tokenRepository.getToken()?.let {
        return challengeService.acceptChallenge(challengeId, it).await()
    } ?: throw NeedLoginException()
}