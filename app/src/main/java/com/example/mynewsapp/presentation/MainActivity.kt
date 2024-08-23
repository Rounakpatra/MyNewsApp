package com.example.mynewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mynewsapp.presentation.bookmarks.BookMarkScreen
import com.example.mynewsapp.presentation.home.HomeScreen
import com.example.mynewsapp.presentation.news_details.NewsDetailsScreen
import com.example.mynewsapp.ui.theme.MyNewsAppTheme
import com.example.mynewsapp.utils.NavRoute
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNewsAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar {
                            val currentRoute =
                                navController.currentBackStackEntryAsState().value?.destination?.route
                            bottomNavItems.forEach {
                                NavigationBarItem(
                                    icon = { Image(imageVector = it.icon, contentDescription = null)},
                                    label = { Text(text = it.title)},
                                    selected =currentRoute==it.route ,
                                    onClick = {
                                        navController.navigate(it.route){
                                            popUpTo(navController.graph.startDestinationId){
                                                saveState=true
                                            }
                                            launchSingleTop=true
                                            restoreState=true
                                        }
                                    }
                                )
                            }
                        }
                    }

                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),

                        color = MaterialTheme.colorScheme.background
                    ) {


                        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
                            composable(NavScreen.Home.route) {
                                HomeScreen(navController)
                            }
                            composable("/details/news={news}&isLocal={isLocal}") {
                                val newsJson = it.arguments?.getString("news")
                                val isLocal = it.arguments?.getString("isLocal").toBoolean()
                                val news = NavRoute.getNewsFromRoute(newsJson!!)
                                NewsDetailsScreen(navController = navController, news,isLocal?:false)


                            }

                            composable(NavScreen.Bookmarks.route) {
                                BookMarkScreen(navController)
                            }
                        }


                    }
                }


            }
        }
    }

}

sealed class NavScreen(val route: String, val icon: ImageVector, val title: String) {

    object Home : NavScreen("/home", Icons.Default.Home, "Home")
    object Bookmarks : NavScreen("/bookmarks", Icons.Default.Favorite, "Bookmarks")

}

val bottomNavItems = listOf(
    NavScreen.Home,
    NavScreen.Bookmarks
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyNewsAppTheme {
        Greeting("Android")
    }
}