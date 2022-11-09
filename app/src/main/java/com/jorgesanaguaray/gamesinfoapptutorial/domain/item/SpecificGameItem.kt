package com.jorgesanaguaray.gamesinfoapptutorial.domain.item

import com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model.SpecificGameModel

/**
 * Created by Jorge Sanaguaray
 */

data class SpecificGameItem(

    val id: Int,
    val title: String,
    val thumbnail: String,
    val game_url: String,
    val description: String,
    val status: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_date: String

)

fun SpecificGameModel.toSpecificGameItem() = SpecificGameItem(id, title, thumbnail, game_url, description, status, genre, platform, publisher, developer, release_date)