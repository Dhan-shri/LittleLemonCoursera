package com.example.littlelemon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

//interface Destination {
//    val route: String
//}
//
//object Home : Destination {
//    override val route: String = "home"
//}
//object Menu : Destination {
//    override val route: String = "menu"
//}




// BottomNavigation Destination

interface BottomNavDestination {
    val route: String
    val icon: ImageVector
    val contentDescription: String

}

object Home : BottomNavDestination {
    override val route: String = "home"
    override val icon: ImageVector = Icons.Filled.Home
    override val contentDescription: String = "Home"
}
object Menu : BottomNavDestination {
    override val route: String = "menu"
    override val icon: ImageVector = Icons.Filled.Menu
    override val contentDescription: String = "Menu"
}

object LazyLayout : BottomNavDestination {
    override val route: String = "lazyLayout"
    override val icon: ImageVector = Icons.Filled.LocationOn
    override val contentDescription: String = "Lazy"
}
object Setting : BottomNavDestination {
    override val route: String = "setting"
    override val icon : ImageVector = Icons.Filled.Settings
    override val contentDescription: String = "Setting"

}
object HomeMain : BottomNavDestination{
    override val route: String = "homeMain"
    override val icon: ImageVector = Icons.Filled.Home
    override val contentDescription: String = "Home"

}