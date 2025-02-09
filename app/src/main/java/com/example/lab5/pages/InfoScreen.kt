package com.example.lab5.pages

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.lab5.utils.AssetImage
import com.example.lab5.utils.ListItem
import java.io.IOException

@Composable
fun InfoScreen(item: ListItem) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
//        AssetImage(
//            imageName = item.imageName,
//            contentDescription = item.title,
//            modifier = Modifier
//                .fillMaxWidth()
//        )
        HtmlLoader(htmlName = item.htmlName)
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun HtmlLoader(htmlName: String) {
    var backEnabled by remember { mutableStateOf(false) }
    var webView: WebView? = null
    val context = LocalContext.current
    val assetManger = context.assets

    // Открываем HTML файл из assets
    val inputStream = assetManger.open("html/$htmlName")
    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    val htmlString = String(buffer)

    // Встраиваем WebView
    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                        backEnabled = view.canGoBack()
                    }
                }
                settings.javaScriptEnabled = true

                // Загружаем HTML с использованием utf-8
                loadDataWithBaseURL(
                    "file:///android_asset/html/",
                    htmlString,
                    "text/html",
                    "utf-8",
                    null
                )

                webView = this
            }
        },
        update = {
            webView = it
        }
    )

    // Обработка нажатия назад для возврата на предыдущую страницу
    BackHandler(enabled = backEnabled) {
        webView?.goBack()
    }
}