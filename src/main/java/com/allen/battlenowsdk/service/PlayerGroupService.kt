package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.requets.playergroup.CreatePlayerGroupRequestBody
import com.allen.battlenowsdk.model.response.group.*
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import retrofit2.http.*

interface PlayerGroupService {
    @GET("challenge/player/group/{groupId}")
    fun fetchGroup(
            @Path("groupId") groupId: Int
    ): Deferred<PlayerGroupResponse>

    @Multipart
    @PUT("/challenge/player/group/{group_id}/avatar")
    fun changePlayerGroupIcon(
            @Part icon: MultipartBody.Part,
            @Path("group_id") groupId: Int,
            @Header("Authorization") token: String
    ): Deferred<UploadPlayerGroupIconResponse>

    @GET("/web/group/search")
    fun searchGroups(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<PlayerGroupResponse>>

    @GET("challenge/player/groups")
    fun fetchPlayerGroups(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<PlayerGroupResponse>>

    @GET("challenge/player/group/{groupId}/statistics")
    fun fetchPlayerGroupStatistics(
            @Path("groupId") groupId: Int
    ): Deferred<PlayerGroupStatisticsResult>

    @GET("challenge/player/group/{groupId}/apply/list")
    fun fetchJoinPlayerGroupApply(
            @Path("groupId") groupId: Int,
            @Header("Authorization") token: String,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<PlayerGroupApplyResponseBody>>

    @PUT("challenge/player/group/join_request/{requestId}")
    fun responsePlayerGroupJoinApply(
            @Path("requestId") requestId: Int,
            @Header("Authorization") token: String,
            @Body requestBody: ResponsePlayerGroupJoinApplyRequestBody
    ): Deferred<Any>

    @DELETE("/challenge/player/group/{groupId}/remove")
    fun deletePlayerGroup(
            @Path("groupId") groupId: Int,
            @Header("Authorization") token: String
    ): Deferred<Any>

    @DELETE("challenge/player/group/{groupId}/member/{memberId}")
    fun deletePlayerGroupMember(
            @Path("groupId") groupId: Int,
            @Path("memberId") memberId: Int,
            @Header("Authorization") token: String
    ): Deferred<Any>


    @POST("challenge/player/group/create")
    fun createPlayerGroup(
            @Header("Authorization") token: String,
            @Body requestBody: CreatePlayerGroupRequestBody
    ): Deferred<CreatePlayerGroupResponse>

    @POST("challenge/player/group/{groupId}/apply")
    fun sendPlayerGroupApply(
            @Path("groupId") groupId: Int,
            @Header("Authorization") token: String
    ): Deferred<Any>

    @GET("challenge/player/group/{groupId}/members")
    fun getPlayerGroupMembers(
            @Path("groupId") groupId: Int,
            @QueryMap queryParamMap: Map<String, String>
    ): Deferred<ListResponse<GetUserResponseBody>>
}