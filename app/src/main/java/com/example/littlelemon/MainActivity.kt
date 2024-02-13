package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                AppScreen()
//                MyNavigation()
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MyBottomNavigation(navController)
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = Home.route){
                composable(HomeMain.route){
                    MainBottomScreen()
                }
                composable(Home.route){
                    HomeScreen(navController)
                }
                composable(Menu.route){
                    MenuListScreen()
                }
                composable(Setting.route){
                    SettingScreen()
                }
                composable(LazyLayout.route){
                    LazyLayoutScreen()
                }
                composable(Theme.route){
                    ThemeLayout()
                }

            }
        }
    }

}

@Composable
fun MyBottomNavigation(navController : NavController){
    val navItems = listOf<BottomNavDestination>(
        Home,
        Menu,
        Setting,
        LazyLayout,
        Theme
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation(){
        navItems.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.contentDescription) },
                label = { Text(text = item.contentDescription) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(navItems[index].route){
                        popUpTo(HomeMain.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}


// Normal Navigation
@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
//        startDestination = Home.route
        startDestination = HomeMain.route
    ) {

        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(Menu.route) {
            MenuListScreen()
        }
        composable(Setting.route) {
            SettingScreen()
        }
        composable(HomeMain.route) {
            MainBottomScreen()
        }
        composable(LazyLayout.route) {
            LazyLayoutScreen()
        }

    }
}
@Composable
private fun AppScreen() {
    Scaffold(topBar = {
        TopAppBar()
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}