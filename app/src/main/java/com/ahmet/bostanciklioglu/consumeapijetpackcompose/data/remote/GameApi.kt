package com.ahmet.bostanciklioglu.consumeapijetpackcompose.data.remote

import com.ahmet.bostanciklioglu.consumeapijetpackcompose.data.remote.model.GameModel
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.util.Constants.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET


interface GameApi {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}