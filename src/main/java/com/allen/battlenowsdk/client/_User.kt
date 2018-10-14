package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.AuthorizationUtil
import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.exceptions.NeedLoginException
import com.allen.battlenowsdk.model.requets.user.*
import com.allen.battlenowsdk.model.response.user.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

public suspend fun BattleNowClient.getFollow(queryParam: Map<String, String>): ListResponse<UserFollowResult> {
    return userService.getUserFollowing(queryParam).await()
}

public suspend fun BattleNowClient.createUser(username: String, email: String, password: String): CreateUserResponseBody {
    return userService.createUser(CreateUserReqeustBody(email, username, password)).await()
}

public suspend fun BattleNowClient.login(username: String, password: String): UserLoginResponseBody {
    userService.userLogin(UserLoginRequestBody(username, password)).await().let {
        tokenRepository.saveToken(it.Payload.token)
        return it
    }
}

public suspend fun BattleNowClient.getUser(userId: Int): GetUserResponseBody {
    return userService.fetchUser(userId).await()
}

/**
 * get user list
 * @return result of user list
 */
public suspend fun BattleNowClient.getUserList(param: Map<String, String>): ListResponse<GetUserResponseBody> {
    return userService.fetchUserList(param).await()
}

/**
 * change user password
 */
public suspend fun BattleNowClient.changePassword(body: ChangePasswordRequestBody) {
    userService.changePassword(body).await()
}

/**
 * change user profile
 */
public suspend fun BattleNowClient.changeUserProfile(userId: Int, body: ChangeUserProfileRequestBody): UserProfileResponse {
    tokenRepository.getToken()?.let {
        return userService.changeUserProfile(body, userId, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

/**
 * upload user avatar
 */
public suspend fun BattleNowClient.uploadUserAvatar(userId: Int, avatar: File): ChangeAvatarResponse {
    val requestFile = RequestBody.create(MediaType.parse("image/jpg"), avatar)
    val body = MultipartBody.Part.createFormData("avatar", "avatar.jpg", requestFile)
    tokenRepository.getToken()?.let {
        return userService.changeUserAvatar(body, userId, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

/**
 * get user statistics
 */
public suspend fun BattleNowClient.getUserStatistics(userId: Int): UserStatisticsResponse {
    return userService.fetchUserStatistics(userId).await()
}

/**
 * search user list
 * @return result of user list
 */
public suspend fun BattleNowClient.searchUser(param: Map<String, String>): ListResponse<SearchUserResult> {
    return userService.searchUser(param).await()
}

/**
 * follow user
 */
public suspend fun BattleNowClient.followUser(body: FollowingUserReqeustBody): FollowUserResponse {
    tokenRepository.getToken()?.let {
        return userService.followUser(AuthorizationUtil.buildAuthorizationHeader(it), body).await()
    } ?: throw NeedLoginException()
}

/**
 * unfollow user
 */
public suspend fun BattleNowClient.unFollowUser(followId: Int) {
    tokenRepository.getToken()?.let {
        userService.unFollowUser(followId, AuthorizationUtil.buildAuthorizationHeader(it)).await()
    } ?: throw NeedLoginException()
}

