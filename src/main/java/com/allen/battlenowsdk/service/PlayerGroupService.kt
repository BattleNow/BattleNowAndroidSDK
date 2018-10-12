package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.model.response.group.PlayerGroupResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerGroupService {
    @GET("challenge/player/group/{groupId}")
    fun fetchGroup(
            @Path("groupId") groupId: Int
    ): Deferred<PlayerGroupResponse>
}