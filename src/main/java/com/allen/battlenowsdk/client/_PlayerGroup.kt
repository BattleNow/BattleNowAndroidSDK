package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.AuthorizationUtil
import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.exceptions.NeedLoginException
import com.allen.battlenowsdk.model.requets.playergroup.CreatePlayerGroupRequestBody
import com.allen.battlenowsdk.model.response.group.*
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

public suspend fun BattleNowClient.getPlayerGroup(groupId: Int): PlayerGroupResponse {
    return playerGroupService.fetchGroup(groupId).await()
}

/**
 * upload player group avatar
 */
public suspend fun BattleNowClient.uploadPlayerGroupIcon(groupId: Int, icon: File): UploadPlayerGroupIconResponse {
    val requestFile = RequestBody.create(MediaType.parse("image/jpg"), icon)
    val body = MultipartBody.Part.createFormData("icon", "icon.jpg", requestFile)
    tokenRepository.getToken()?.let {
        return playerGroupService.changePlayerGroupIcon(body, groupId, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

/**
 * search player group
 */
public suspend fun BattleNowClient.searchPlayerGroup(queryParam: Map<String, String>): ListResponse<PlayerGroupResponse> {
    return playerGroupService.searchGroups(queryParam).await()
}

/**
 * get player group list
 */
public suspend fun BattleNowClient.getPlayerGroupList(queryParam: Map<String, String>): ListResponse<PlayerGroupResponse> {
    return playerGroupService.fetchPlayerGroups(queryParam).await()
}

/**
 * get player group statistics
 */
public suspend fun BattleNowClient.getPlayerGroupStatistics(groupId: Int): PlayerGroupStatisticsResult {
    return playerGroupService.fetchPlayerGroupStatistics(groupId).await()
}

/**
 * get player group apply list
 */
public suspend fun BattleNowClient.getPlayerGroupList(playerGroupId: Int, queryParam: Map<String, String>): ListResponse<PlayerGroupApplyResponseBody> {
    tokenRepository.getToken()?.let {
        return playerGroupService.fetchJoinPlayerGroupApply(playerGroupId, AuthorizationUtil.buildAuthorizationHeader(it), queryParam).await()
    } ?: throw NeedLoginException()
}

/**
 * response join request
 */
public suspend fun BattleNowClient.responseJoinApply(joinRequestId: Int, body: ResponsePlayerGroupJoinApplyRequestBody) {
    tokenRepository.getToken()?.let {
        playerGroupService.responsePlayerGroupJoinApply(joinRequestId, AuthorizationUtil.buildAuthorizationHeader(it), body)
    } ?: throw NeedLoginException()
}

/**
 * delete player group
 */
public suspend fun BattleNowClient.deletePlayerGroup(playerGroupId: Int) {
    tokenRepository.getToken()?.let {
        playerGroupService.deletePlayerGroup(playerGroupId, it)
    } ?: throw NeedLoginException()
}

/**
 * remove player group member
 */
public suspend fun BattleNowClient.removePlayerGroupMember(playerGroupId: Int, memberId: Int) {
    tokenRepository.getToken()?.let {
        playerGroupService.deletePlayerGroupMember(playerGroupId, memberId, AuthorizationUtil.buildAuthorizationHeader(it))
    } ?: throw NeedLoginException()
}

/**
 * create player group
 */
public suspend fun BattleNowClient.createPlayerGroup(body: CreatePlayerGroupRequestBody) {
    tokenRepository.getToken()?.let {
        playerGroupService.createPlayerGroup(AuthorizationUtil.buildAuthorizationHeader(it), body)
    } ?: throw NeedLoginException()
}

/**
 * send player group join apply
 */
public suspend fun BattleNowClient.createJoinApply(playerGroupId: Int) {
    tokenRepository.getToken()?.let {
        playerGroupService.sendPlayerGroupApply(playerGroupId, AuthorizationUtil.buildAuthorizationHeader(it))
    } ?: throw NeedLoginException()
}

/**
 * get player group member list
 */
public suspend fun BattleNowClient.searchPlayerGroup(playerGroupId: Int, queryParam: Map<String, String>): ListResponse<GetUserResponseBody> {
    return playerGroupService.getPlayerGroupMembers(playerGroupId, queryParam).await()
}
