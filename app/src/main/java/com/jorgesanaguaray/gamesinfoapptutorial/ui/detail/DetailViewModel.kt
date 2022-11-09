package com.jorgesanaguaray.gamesinfoapptutorial.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgesanaguaray.gamesinfoapptutorial.domain.GetGameByIdUseCase
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.SpecificGameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

@HiltViewModel
class DetailViewModel @Inject constructor(private val getGameByIdUseCase: GetGameByIdUseCase) : ViewModel() {

    private val _game = MutableLiveData<SpecificGameItem>()
    val game: LiveData<SpecificGameItem> get() = _game

    private val _scrollViewVisibility = MutableLiveData<Boolean>()
    val scrollViewVisibility: LiveData<Boolean> get() = _scrollViewVisibility

    private val _textViewNoInternetVisibility = MutableLiveData<Boolean>()
    val textViewNoInternetVisibility: LiveData<Boolean> get() = _textViewNoInternetVisibility

    private val _progressBarVisibility = MutableLiveData<Boolean>()
    val progressBarVisibility: LiveData<Boolean> get() = _progressBarVisibility

    fun getGameById(id: Int) {

        showProgressBar()

        viewModelScope.launch {

            try {

                val game = getGameByIdUseCase(id)
                _game.value = game
                showScrollView()

            } catch (e: Exception) { // No internet connection.

                showTextViewNoInternet()

            }

        }

    }

    private fun showScrollView() {

        _scrollViewVisibility.value = true
        _textViewNoInternetVisibility.value = false
        _progressBarVisibility.value = false

    }

    private fun showTextViewNoInternet() {

        _scrollViewVisibility.value = false
        _textViewNoInternetVisibility.value = true
        _progressBarVisibility.value = false

    }

    private fun showProgressBar() {

        _scrollViewVisibility.value = false
        _textViewNoInternetVisibility.value = false
        _progressBarVisibility.value = true

    }

}