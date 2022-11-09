package com.jorgesanaguaray.gamesinfoapptutorial.data.remote.model

data class SpecificGameModel(

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