package com.example.lab5.pages

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.lab5.MainViewModel
import com.example.lab5.ui_components.DrawerMenu
import com.example.lab5.ui_components.Header
import com.example.lab5.ui_components.MovieItem
//import com.example.lab5.ui_components.MovieList
import com.example.lab5.utils.DrawerEvents
import com.example.lab5.utils.ListItem
import kotlinx.coroutines.launch
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Films(mainViewModel: MainViewModel = hiltViewModel(), onClick: (ListItem) -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val selectedCategory = rememberSaveable { mutableStateOf("Marvel") }
    val mainList = mainViewModel.mainList
    LaunchedEffect(Unit) {
        mainViewModel.getAllItemsByCategory(selectedCategory.value)
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerMenu() { event ->
                    when (event) {
                        is DrawerEvents.OnItemClick -> {
                            selectedCategory.value = event.title
                            mainViewModel.getAllItemsByCategory(event.title)

                        }
                    }
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    Header(title = selectedCategory.value, drawerState = drawerState){
                        selectedCategory.value = "Избранные"
                        mainViewModel.getFavorites()

                    }
                },
                content = { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                    ) {
                        items(mainList.value) { item ->
                            MovieItem(movie = item) { listItem -> onClick(listItem) }
                        }

                    }
                }
            )
        })
}

//private fun getListItemsByIndex(index: Int, context: Context): List<ListItem> {
//    val list = ArrayList<ListItem>()
//    val arrayList = context.resources.getStringArray(IdArrayList.listId[index])
//    arrayList.forEach { item ->
//        val itemArray = item.split("|")
//        list.add(
//            ListItem(
//                itemArray[0],
//                itemArray[1],
//                itemArray[2]
//            )
//        )
//    }
//    return list
//}
