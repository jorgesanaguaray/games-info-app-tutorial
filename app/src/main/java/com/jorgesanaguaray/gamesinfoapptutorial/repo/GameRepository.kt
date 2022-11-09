package com.jorgesanaguaray.gamesinfoapptutorial.repo

import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.GameService
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.GameItem
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.SpecificGameItem
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.toGameItem
import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.toSpecificGameItem
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames(): List<GameItem> {

        return gameService.getGames().map {
            it.toGameItem()
        }

    }

    suspend fun getGameById(id: Int): SpecificGameItem {

        return gameService.getGameById(id).toSpecificGameItem()

    }

}