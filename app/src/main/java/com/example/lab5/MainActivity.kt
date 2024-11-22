package com.example.lab5

import androidx.navigation.compose.composable
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.lab5.pages.About
import com.example.lab5.pages.Films
import com.example.lab5.pages.Home
import com.example.lab5.pages.InfoScreen
//import com.example.lab5.pages.getListItemsByIndex
import com.example.lab5.ui.theme.AppTheme
import com.example.lab5.ui.theme.AppTypography
import com.example.lab5.utils.ItemSaver
//import com.example.lab5.utils.ItemSaver
import com.example.lab5.utils.ListItem
//import com.example.lab5.utils.NavRoutes
import com.example.lab5.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val item = rememberSaveable(stateSaver = ItemSaver) {
                mutableStateOf(
                    ListItem(
                        id = 0, title = "", imageName = "",
                        htmlName = "", isfav = false, category = ""
                    )
                )
            }
            AppTheme() {
                NavHost(
                    navController = navController,
                    startDestination = Routes.MAIN_SCREEN.route
                ) {
                    composable(Routes.MAIN_SCREEN.route) {
                        Films() { listItem ->
                            item.value = ListItem(
                                listItem.id,
                                listItem.title,
                                listItem.imageName,
                                listItem.htmlName,
                                listItem.isfav,
                                listItem.category
                            )
                            navController.navigate(Routes.INFO_SCREEN.route)
                        }
                    }
                    composable(Routes.INFO_SCREEN.route) {
                        InfoScreen(item = item.value!!)
                    }
                }
            }
        }
    }
}

//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun Main(isDarkTheme: Boolean, mainList: MutableState<List<ListItem>>, onThemeSwitch: () -> Unit) {
//    var currentScreen by rememberSaveable { mutableStateOf(NavRoutes.Home.route) }
//    var selectedItem by rememberSaveable(stateSaver = ItemSaver) { mutableStateOf(ListItem("", "", "")) }
//
//    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
//        Box(modifier = Modifier.weight(1f)) {
//            Crossfade(targetState = currentScreen) { screen ->
//                when {
//                    screen == NavRoutes.Home.route -> Home()
//                    screen == NavRoutes.Films.route -> Films(mainList) { item ->
//                        selectedItem = item
//                        currentScreen = NavRoutes.Info.createRoute(item)
//                    }
//                    screen.startsWith("info/") -> {
//                        val params = screen.split("/")
//                        if (params.size == 4) {
//                            InfoScreen(
//                                ListItem(
//                                    title = params[1],
//                                    imageName = params[2],
//                                    htmlName = params[3]
//                                )
//                            )
//                        }
//                    }
//                    screen == NavRoutes.About.route -> About(isDarkTheme = isDarkTheme, onThemeSwitch = onThemeSwitch)
//                }
//            }
//        }
//        NavBar(
//            currentScreen = currentScreen,
//            onItemSelected = { selectedScreen ->
//                currentScreen = selectedScreen
//            }
//        )
//    }
//}
//
//
//@Composable
//fun NavBar(currentScreen: String, onItemSelected: (String) -> Unit) {
//    Row(
//        horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Black)
//            .padding(8.dp)
//    ) {
//        NavBarItem("Home", Icons.Default.Home, NavRoutes.Home.route, currentScreen, onItemSelected)
//        NavBarItem(
//            "Films",
//            Icons.Default.Star,
//            NavRoutes.Films.route,
//            currentScreen,
//            onItemSelected
//        )
//        NavBarItem(
//            "About",
//            Icons.Default.Menu,
//            NavRoutes.About.route,
//            currentScreen,
//            onItemSelected
//        )
//    }
//}
//
//@Composable
//fun NavBarItem(
//    label: String,
//    icon: ImageVector,
//    route: String,
//    currentScreen: String,
//    onItemSelected: (String) -> Unit
//) {
//    val isSelected = currentScreen == route
//    val textColor = if (isSelected) colorResource(R.color.purple_200) else Color.White
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .clickable { onItemSelected(route) }
//    ) {
//        Icon(
//            icon,
//            contentDescription = label,
//            tint = textColor,
//            modifier = Modifier.size(24.dp)
//        )
//        Text(
//            text = label,
//            fontSize = 12.sp,
//            color = textColor,
//            style = AppTypography.labelSmall
//        )
//    }
//}

