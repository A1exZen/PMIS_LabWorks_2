package com.example.lab5.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.R
import com.example.lab5.utils.DrawerEvents
//import com.example.lab5.utils.fetchMovies
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(
    onEvent: (DrawerEvents) -> Unit,
) {
    val categories = stringArrayResource(id = R.array.drawer_list)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(16.dp)
            .width(250.dp)
    ) {
        Text(
            text = "Categories",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.purple_200)
        )
        Divider(
            modifier = Modifier
                .height(2.dp),
            color = MaterialTheme.colorScheme.primary
        )
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(categories) { index, category ->
//                val isSelected = category == selectedCategory
//                val backgroundColor = if (isSelected) Color(0xFF6200EE) else Color.Transparent
//                val textColor = if (category == selectedCategory) Color.White else Color.White
//                val interactionSource = remember { MutableInteractionSource() }
//                val isHovered by interactionSource.collectIsHoveredAsState()
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable { onEvent(DrawerEvents.OnItemClick(category, index)) },
//                        .background(if (isHovered) Color.Red else Color.Blue)
//                        .hoverable(interactionSource = interactionSource),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = category,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(16.dp).clickable {
                            onEvent(DrawerEvents.OnItemClick(category,index))
                        },
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

//@Composable
//fun DrawerMenu(
//    selectedCategory: String,
//    onCategorySelected: (String) -> Unit
//) {
//    val categories = listOf("Marvel", "DC", "Star Wars")
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Categories",
//            fontWeight = FontWeight.Bold,
//            fontSize = 24.sp,
//            modifier = Modifier.padding(vertical = 16.dp)
//        )
//        Divider(modifier = Modifier.height(1.dp), color = MaterialTheme.colorScheme.primary)
//        LazyColumn {
//            items(categories) { category ->
//                val isSelected = category == selectedCategory
//                Text(
//                    text = category,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { onCategorySelected(category) }
//                        .padding(8.dp),
//                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
//                )
//            }
//        }
//    }
//}
