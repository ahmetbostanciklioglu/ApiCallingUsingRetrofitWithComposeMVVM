package com.ahmet.bostanciklioglu.consumeapijetpackcompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain.GetGameUseCase
import com.ahmet.bostanciklioglu.consumeapijetpackcompose.domain.item.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGamesUseCase: GetGameUseCase
) : ViewModel(){
    private  val _games = MutableStateFlow(emptyList<GameItem>())
    val games : StateFlow<List<GameItem>>
        get() = _games

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games
            } catch (_: Exception) { }
        }
    }
}