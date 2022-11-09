package com.jorgesanaguaray.gamesinfoapptutorial.data.remote

import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model.GameModel
import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model.SpecificGameModel
import com.jorgesanaguaray.gamesinfoapptutorial.util.Constants.Companion.GAMES_ENDPOINT
import com.jorgesanaguaray.gamesinfoapptutorial.util.Constants.Companion.GAME_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jorge Sanaguaray
 */

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>

}