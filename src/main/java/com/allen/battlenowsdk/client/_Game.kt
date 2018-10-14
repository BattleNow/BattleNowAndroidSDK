package com.allen.battlenowsdk.client

import com.allen.battlenowsdk.common.ListResponse
import com.allen.battlenowsdk.model.response.game.GameResponseBody
import com.allen.battlenowsdk.model.response.game.SearchGameResult

/**
 * get game list
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

/**
 * get search games
 * @param queryParam query parameter map
 */
public suspend fun BattleNowClient.searchGame(queryParam: Map<String, String>): ListResponse<SearchGameResult> {
    return gameService.searchGame(queryParam).await()
}
