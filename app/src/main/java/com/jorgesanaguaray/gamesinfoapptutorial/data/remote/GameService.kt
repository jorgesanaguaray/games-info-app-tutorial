package com.jorgesanaguaray.gamesinfoapptutorial.data.remote

import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model.GameModel
import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model.SpecificGameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

class GameService @Inject constructor(private val gameApi: GameApi) {

    suspend fun getGames(): List<GameModel> {

        return withContext(Dispatchers.IO) {
            val games = gameApi.getGames()
            games.body() ?: emptyList()
        }

    }

    suspend fun getGameById(id: Int): SpecificGameModel {

        return withContext(Dispatchers.IO) {
            val game = gameApi.getGameById(id)
            game.body()!!
        }

    }

}