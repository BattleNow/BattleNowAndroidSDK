package com.allen.battlenowsdk.model.client

import com.allen.battlenowsdk.TokenRepository
import com.allen.battlenowsdk.service.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BattleNowClient {
    lateinit var tokenRepository: TokenRepository
    lateinit var retrofit: Retrofit
    lateinit var userService: UserService
    lateinit var gameService: GameService
    lateinit var playerGroupService: PlayerGroupService
    lateinit var matchService: MatchService
    lateinit var challengeService: ChallengeService

    class Builder {
        private val retrofitBuilder = Retrofit.Builder()
        private lateinit var repository: TokenRepository
        fun setBaseUrl(url: String): Builder {
            retrofitBuilder.baseUrl(url)
            return this
        }

        fun setTokenRepository(repository: TokenRepository): Builder {
            this.repository = repository
            return this
        }

        fun custom(builderCall: (Retrofit.Builder) -> Unit): Builder {
            builderCall.invoke(retrofitBuilder)
            return this
        }

        fun build(): BattleNowClient {
            return BattleNowClient().apply {
                retrofit = retrofitBuilder
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                tokenRepository = repository
                userService = retrofit.create(UserService::class.java)
                gameService = retrofit.create(GameService::class.java)
                playerGroupService = retrofit.create(PlayerGroupService::class.java)
                matchService = retrofit.create(MatchService::class.java)
                challengeService = retrofit.create(ChallengeService::class.java)
            }
        }
    }



}