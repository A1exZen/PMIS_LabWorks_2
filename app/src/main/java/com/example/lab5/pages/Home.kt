package com.example.lab5.pages

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.R
//import com.example.lab5.ui_components.MovieList
import com.example.lab5.utils.ListItem

@Composable
fun Home() {
//    val context = LocalContext.current
//    val allMovies = remember { mutableStateOf(getAllMovies(context)) }
//    var item: ListItem? = null
//    Text(
//        text = "All Movies",
//        fontSize = 30.sp,
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//    )
//    Spacer(modifier = Modifier.height(8.dp))
//    MovieList(movies = allMovies.value){listItem ->
//        item = listItem}
}
//
//fun getAllMovies(context: Context): List<ListItem> {
//    val list = ArrayList<ListItem>()
//
//    // Список всех строковых массивов из XML
//    val movieCategories = listOf(
//        R.array.Marvel,
//        R.array.DC,
//        R.array.Comedy,
//        R.array.Adventure,
//        R.array.Fantastic,
//        R.array.Horror,
//        R.array.Fiction
//    )
//
//    // Перебираем все категории фильмов
//    for (category in movieCategories) {
//        val arrayList = context.resources.getStringArray(category)
//        for (item in arrayList) {
//            val itemArray = item.split("|")
//            if (itemArray.size == 2) {
//                list.add(ListItem(itemArray[0], itemArray[1], itemArray[2]))
//            }
//        }
//    }
//    return list
//}
//
