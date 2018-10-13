package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.requets.user.CreateUserReqeustBody
import com.allen.battlenowsdk.model.requets.user.UserLoginRequestBody
import com.allen.battlenowsdk.model.response.user.CreateUserResponseBody
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import com.allen.battlenowsdk.model.response.user.UserFollowResponseBody
import com.allen.battlenowsdk.model.response.user.UserLoginResponseBody
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.*

interface UserService {
    @POST("user")
    fun createUser(
            @Body body: CreateUserReqeustBody
    ): Deferred<CreateUserResponseBody>

    @POST("user/auth")
    fun userLogin(
            @Body data: UserLoginRequestBody
    ): Deferred<UserLoginResponseBody>

    @GET("user/{id}")
    fun fetchUser(
            @Path("id") userId: Int
    ): Deferred<GetUserResponseBody>

    @GET("user")
    fun fetchUserList(
            @QueryMap param: Map<String, String>
    ): Deferred<ListResponse<GetUserResponseBody>>

    @GET("/web/user/following")
    fun fetchUserFollowing(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<UserFollowResponseBody>>
}