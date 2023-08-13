package com.ahmet.bostanciklioglu.consumeapijetpackcompose.repo

import com.ahmet.bostanciklioglu.consumeapijetpackcompose.data.remote.GameService
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain.item.GameItem
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain.item.toGameItem
import javax.inject.Inject


class GameRepository @Inject constructor(
    private val gameService: GameService
) {
    suspend fun getGames(): List<GameItem> {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }
}