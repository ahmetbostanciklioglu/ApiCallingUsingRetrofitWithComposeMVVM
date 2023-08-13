package com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain

import com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain.item.GameItem
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.repo.GameRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun  invoke(): List<GameItem> {
        return gameRepository.getGames().shuffled()
    }
}