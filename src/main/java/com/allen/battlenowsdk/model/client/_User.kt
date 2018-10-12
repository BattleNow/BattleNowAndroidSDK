package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.requets.user.CreateUserReqeustBody
import com.allen.battlenowsdk.model.requets.user.UserLoginRequestBody
import com.allen.battlenowsdk.model.response.user.CreateUserResponseBody
import com.allen.battlenowsdk.model.response.user.GetUserResponseBody
import com.allen.battlenowsdk.model.response.user.UserFollowResponseBody
import com.allen.battlenowsdk.model.response.user.UserLoginResponseBody

public suspend fun BattleNowClient.getFollow(queryParam: Map<String, String>): ListResponse<UserFollowResponseBody> {
    return userService.fetchUserFollowing(queryParam).await()
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

public suspend fun BattleNowClient.getUserList(param: Map<String, String>): ListResponse<GetUserResponseBody> {
    return userService.fetchUserList(param).await()
}


