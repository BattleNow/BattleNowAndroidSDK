package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.response.game.GameResponseBody

/**
 * get challenge list
 * @param queryParam query parameter map
 */
public suspend fun BattleNowClient.getGameList(queryParam: Map<String, String>): ListResponse<GameResponseBody> {
    return gameService.fetchGames(queryParam).await()
}

/**
 * get single result game by id
 */
public suspend fun BattleNowClient.getGame(gameId: Int): GameResponseBody {
    return gameService.fetchGame(gameId).await()
}
