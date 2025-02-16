package com.shashank.day11.routes

import kotlinx.serialization.Serializable


sealed class MyAppRoute {

    @Serializable
    data object Login

    @Serializable
    data class HomeScree(val name: String)
}