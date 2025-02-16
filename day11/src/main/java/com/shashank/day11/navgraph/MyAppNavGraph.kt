package com.shashank.day11.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.shashank.day11.routes.MyAppRoute
import com.shashank.day11.screens.HomScreen
import com.shashank.day11.screens.LoginScreen

@Composable
fun MyAppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = MyAppRoute.Login) {
        composable<MyAppRoute.Login> {
            LoginScreen(navController = navController)
        }
        composable<MyAppRoute.HomeScree> {
            val arg = it.toRoute<MyAppRoute.HomeScree>()
            HomScreen(email = arg.name)
        }
    }
}