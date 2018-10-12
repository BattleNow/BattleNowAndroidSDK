package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.model.response.group.PlayerGroupResponse

public suspend fun BattleNowClient.getPlayerGroup(groupId: Int): PlayerGroupResponse {
    return playerGroupService.fetchGroup(groupId).await()
}