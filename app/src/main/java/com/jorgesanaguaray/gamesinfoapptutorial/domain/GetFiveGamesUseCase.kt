package com.jorgesanaguaray.gamesinfoapptutorial.domain

import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.GameItem
import com.jorgesanaguaray.gamesinfoapptutorial.repo.GameRepository
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

class GetFiveGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameItem> {

        val games = gameRepository.getGames()
        return games.shuffled().take(5)

    }

}