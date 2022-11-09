package com.jorgesanaguaray.gamesinfoapptutorial.domain

import com.jorgesanaguaray.gamesinfoapptutorial.domain.item.SpecificGameItem
import com.jorgesanaguaray.gamesinfoapptutorial.repo.GameRepository
import javax.inject.Inject

/**
 * Created by Jorge Sanaguaray
 */

class GetGameByIdUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(id: Int): SpecificGameItem {

        return gameRepository.getGameById(id)

    }

}