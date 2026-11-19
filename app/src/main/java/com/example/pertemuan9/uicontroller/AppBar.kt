package com.example.myapplication.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.view.uicontroller.DestinasiHome
import com.example.myapplication.uicontroller.route.DestinasiDetailSiswa
import com.example.myapplication.uicontroller.route.DestinasiEditSiswa
import com.example.myapplication.view.DetailSiswaScreen
import com.example.myapplication.view.uicontroller.DestinasiEntry
import com.example.myapplication.view.uicontroller.EntrySiswaScreen
import com.example.myapplication.view.uicontroller.HomeScreen


@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                // edit 1 : tambahkan parameter navigateToItemUpdate
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/$it")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // edit 2 : tambahkan 2 composable route
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = {
                    navController.navigate("${DestinasiEditSiswa.route}/$it")
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }

        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            EditSiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}
