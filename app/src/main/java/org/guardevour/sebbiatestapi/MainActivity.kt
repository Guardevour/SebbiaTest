package org.guardevour.sebbiatestapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.guardevour.sebbiatestapi.ui.theme.SebbiaTestAPITheme
import org.guardevour.sebbiatestapi.views.CategoriesScreen
import org.guardevour.sebbiatestapi.views.DetailedArticleScreen
import org.guardevour.sebbiatestapi.views.NewsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SebbiaTestAPITheme {
                val navHostController = rememberNavController()

                NavHost(
                    navController = navHostController,
                    startDestination = Routes.CATEGORIES.text
                ){
                    composable(Routes.CATEGORIES.text) {
                        CategoriesScreen(navHostController = navHostController)
                    }
                    composable(
                        "${Routes.CATEGORIES.text}/{categoryId}",
                        arguments = listOf(navArgument("categoryId") {
                            type = NavType.IntType
                        })
                    ) {backStackEntry ->
                        NewsScreen(
                            categoryId = backStackEntry.arguments?.getInt("categoryId")!!,
                            navHostController = navHostController
                        )
                    }
                    composable(
                        "${Routes.NEWS.text}/{newsId}",
                        arguments = listOf(navArgument("newsId") {
                            type = NavType.IntType
                        })
                    ) {backStackEntry ->
                        DetailedArticleScreen(
                            newsId = backStackEntry.arguments?.getInt("newsId")!!,
                        )
                    }
                }
            }
        }
    }
}

enum class Routes(val text: String){
    CATEGORIES("categories"),
    NEWS("news")
}