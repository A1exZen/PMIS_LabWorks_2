package com.example.lab5.ui_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.lab5.MainViewModel
import com.example.lab5.ui.theme.AppTypography
import com.example.lab5.utils.AssetImage
import com.example.lab5.utils.ListItem
import androidx.hilt.navigation.compose.hiltViewModel

//@Composable
//fun MovieList(movies: List<ListItem>) {
//    if (movies.isEmpty()) {
//        Text(
//            text = "No movies found",
//            fontWeight = FontWeight.Bold,
//            color = MaterialTheme.colorScheme.error,
//            style = AppTypography.bodyLarge,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 30.dp),
//            textAlign = TextAlign.Center
//        )
//    } else {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(8.dp)
//        ) {
//            items(movies) { movie ->
//                MovieItem(movie) { onItemClick(movie) }
//            }
//        }
//    }
//}

@Composable
fun MovieItem(mainViewModel: MainViewModel = hiltViewModel(), movie: ListItem, onClick: (ListItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick(movie) },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        ) {
            // Create references
            val (image, text, favoriteButton) = createRefs()

            // Movie image
            AssetImage(
                imageName = movie.imageName,
                contentDescription = movie.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(130.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 10.dp,
                            bottomStart = 10.dp
                        )
                    )
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            // Movie title
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 60.dp) // Leave space for the button
                        width = Dimension.fillToConstraints
                    }
            )

            // Favorite button
            IconButton(
                onClick = { mainViewModel.insertItem(movie.copy(isfav = !movie.isfav)) },
                modifier = Modifier
                    .size(40.dp)
                    .constrainAs(favoriteButton) {
                        top.linkTo(parent.top, margin = 8.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = if(movie.isfav) Color.Red else MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


