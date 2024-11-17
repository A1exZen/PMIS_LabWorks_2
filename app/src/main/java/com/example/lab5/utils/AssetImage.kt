package com.example.lab5.utils

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

//@Composable
//fun AssetImage(
//    imageName: String, contentDescription: String, modifier: Modifier
//) {
//    val context = LocalContext.current
//    try {
//        val assetManager = context.assets
//        val inputStream = assetManager.open(imageName)
//        val bitMap = BitmapFactory.decodeStream(inputStream)
//        Image(
//            bitmap = bitMap.asImageBitmap(),
//            contentDescription = contentDescription,
//            contentScale = ContentScale.Crop,
//            colorFilter = ColorFilter.tint(Color(0xBFFFFFFF)),
//            modifier = modifier
//        )
//    } catch (e: Exception) {
//        Text("Image not found: $imageName", color = Color.Red) // Отображение ошибки
//        e.printStackTrace() // Печать ошибки
//    }
//}


@Composable
fun AssetImage(imageName: String, contentDescription: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val assetManager = context.assets
    var imageBitmap: ImageBitmap? = null
    var errorState = false

    try {
        // Open the image from the assets folder
        val inputStream = assetManager.open(imageName)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        imageBitmap = bitmap?.asImageBitmap()
    } catch (e: Exception) {
        errorState = true
    }

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    } else if (errorState) {
        // Display error if image not found
        Text(
            text = "Image not found",
            color = Color.Red,
            modifier = modifier
        )
    } else {
        // Display a loading state if image is being processed
        Text(
            text = "Loading...",
            modifier = modifier
        )
    }
}
