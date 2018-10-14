package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.AuthorizationUtil
import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.exceptions.NeedLoginException
import com.allen.battlenowsdk.model.requets.challenge.CreateChallengeRequestBody
import com.allen.battlenowsdk.model.response.challenge.*

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
        return challengeService.acceptChallenge(challengeId, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

/**
 * get challenge type
 * @param queryParam query parameter map
 */
public suspend fun BattleNowClient.getChallengeTypeList(queryParam: Map<String, String>): ListResponse<ChallengeTypesResult> {
    return challengeService.fetchChallengeTypes(queryParam).await()
}

/**
 * create challenge
 * @param body create challenge option
 */
public suspend fun BattleNowClient.createChallenge(body: CreateChallengeRequestBody): Any {
    tokenRepository.getToken()?.let {
        return challengeService.createChallenge(body, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

/**
 * get challenge player result list
 * @param challengeId challenge id
 */
public suspend fun BattleNowClient.getChallengeList(challengeId: Int): ListResponse<ChallengePlayerResultResponse> {
    return challengeService.fetchChallengeResult(challengeId).await()
}

/**
 * get search challenge
 * @param queryParam query parameter map
 */
public suspend fun BattleNowClient.searchChallenge(queryParam: Map<String, String>): ListResponse<SearchChallengeResponse> {
    return challengeService.searchChallenge(queryParam).await()
}

/**
 * upload challenge result
 */
public suspend fun BattleNowClient.uploadChallengeResult(challengeId: Int, body: UploadChallengeResultRequestBody): Any {
    tokenRepository.getToken()?.let {
        return challengeService.uploadChallengeResult(challengeId, AuthorizationUtil.buildAuthorizationHeader(it), body).await()
    } ?: throw NeedLoginException()
}