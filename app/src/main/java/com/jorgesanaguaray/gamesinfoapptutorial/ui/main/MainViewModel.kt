package com.jorgesanaguaray.gamesinfoapptutorial.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgesanaguaray.gamesinfoapptutorial.domain.GetFiveGamesUseCase
import com.jorgesanaguaray.gamesinfoapptutorial.domain.GetGameUseCase
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

@HiltViewModel
class MainViewModel @Inject constructor(

    private val getGameUseCase: GetGameUseCase,
    private val getFiveGamesUseCase: GetFiveGamesUseCase

    ) : ViewModel() {

    private val _game = MutableLiveData<GameItem>()
    val game: LiveData<GameItem> get() = _game

    private val _gamesA = MutableLiveData<List<GameItem>>()
    val gamesA: LiveData<List<GameItem>> get() = _gamesA

    private val _gamesB = MutableLiveData<List<GameItem>>()
    val gamesB: LiveData<List<GameItem>> get() = _gamesB

    private val _gamesC = MutableLiveData<List<GameItem>>()
    val gamesC: LiveData<List<GameItem>> get() = _gamesC

    private val _nestedScrollViewVisibility = MutableLiveData<Boolean>()
    val nestedScrollViewVisibility: LiveData<Boolean> get() = _nestedScrollViewVisibility

    private val _textViewNoInternetVisibility = MutableLiveData<Boolean>()
    val textViewNoInternetVisibility: LiveData<Boolean> get() = _textViewNoInternetVisibility

    private val _progressBarVisibility = MutableLiveData<Boolean>()
    val progressBarVisibility: LiveData<Boolean> get() = _progressBarVisibility

    init {
        getGame()
        getFiveGames()
    }

    fun getGame() {

        showProgressBar()

        viewModelScope.launch {

            try {

                val game = getGameUseCase()
                _game.value = game
                showNestedScrollView()

            } catch (e: Exception) { // No internet connection.

                showTextViewNoInternet()

            }

        }

    }

    fun getFiveGames() {

        viewModelScope.launch {

            try {

                val gamesA = getFiveGamesUseCase()
                _gamesA.value = gamesA

                val gamesB = getFiveGamesUseCase()
                _gamesB.value = gamesB

                val gamesC = getFiveGamesUseCase()
                _gamesC.value = gamesC

            } catch (_: Exception) {}

        }

    }

    private fun showNestedScrollView() {

        _nestedScrollViewVisibility.value = true
        _textViewNoInternetVisibility.value = false
        _progressBarVisibility.value = false

    }

    private fun showTextViewNoInternet() {

        _nestedScrollViewVisibility.value = false
        _textViewNoInternetVisibility.value = true
        _progressBarVisibility.value = false

    }

    private fun showProgressBar() {

        _nestedScrollViewVisibility.value = false
        _textViewNoInternetVisibility.value = false
        _progressBarVisibility.value = true

    }

}