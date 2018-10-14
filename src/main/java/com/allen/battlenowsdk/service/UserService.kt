package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.requets.user.*
import com.allen.battlenowsdk.model.response.user.*
import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import retrofit2.Response
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

    @POST("user/password")
    fun changePassword(
            @Body body: ChangePasswordRequestBody
    ): Deferred<Any>

    @PUT("user/{uid}/profile")
    fun changeUserProfile(
            @Body body: ChangeUserProfileRequestBody,
            @Path("uid") uid: Int,
            @Header("Authorization") token: String
    ): Deferred<UserProfileResponse>

    @Multipart
    @PUT("user/{uid}/profile/avatar")
    fun changeUserAvatar(
            @Part avatar: MultipartBody.Part,
            @Path("uid") uid: Int,
            @Header("Authorization") token: String
    ): Deferred<ChangeAvatarResponse>

    @GET("user/{uid}/statistics")
    fun fetchUserStatistics(
            @Path("uid") uid: Int
    ): Deferred<UserStatisticsResponse>

    @GET("/web/user/search")
    fun searchUser(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<SearchUserResult>>

    @GET("/web/user/following")
    fun getUserFollowing(
            @QueryMap params: Map<String, String>
    ): Deferred<ListResponse<UserFollowResult>>

    @POST("/web/user/following/add")
    fun followUser(
            @Header("Authorization") token: String,
            @Body followingBody: FollowingUserReqeustBody
    ): Deferred<FollowUserResponse>


    @DELETE("/web/user/following/{fid}")
    fun unFollowUser(
            @Path("fid") fid: Int,
            @Header("Authorization") token: String
    ): Deferred<Any>
}