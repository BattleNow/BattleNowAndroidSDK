package com.allen.battlenowsdk.service

import com.allen.battlenowsdk.model.common.ListResponse
import com.allen.battlenowsdk.model.response.game.GameResponseBody
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface GameService {
    @GET("games")
    fun fetchGames(
            @QueryMap queryParam: Map<String, String>
    ): Deferred<ListResponse<GameResponseBody>>

    @GET("games/{GameId}")
    fun fetchGame(
            @Path("GameId") gameId: Int
    ): Deferred<GameResponseBody>
}