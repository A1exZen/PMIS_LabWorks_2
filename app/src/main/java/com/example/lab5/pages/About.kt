package com.example.lab5.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.R
import com.example.lab5.ui.theme.AppTypography


@Composable
fun About(isDarkTheme: Boolean, onThemeSwitch: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize().padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    style = AppTypography.titleLarge,
                    color = colorResource(R.color.purple_200),
                    modifier = Modifier.padding(top = 36.dp)
                )
                Text(
                    text = "Version " + stringResource(id = R.string.app_version),
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
        item {
            Column(
                modifier = Modifier.padding(25.dp, 5.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                ListItem(
                    title = "Privacy",
                    icon = Icons.Outlined.Lock,
                    onClick = { /*TODO*/ })
                ListItem(
                    title = "Contact Support",
                    icon = Icons.Outlined.Call,
                    onClick = { /*TODO*/ })
                ListItem(
                    title = "Send Feedback",
                    icon = Icons.Outlined.Email,
                    onClick = { /*TODO*/ })
                ListItem(
                    title = "Open in Google Play",
                    icon = Icons.Outlined.ShoppingCart,
                    onClick = { /*TODO*/ })
                ListItem(
                    title = "Rate us",
                    icon = Icons.Outlined.Star,
                    onClick = { /*TODO*/ })
            }
        }
        item{
            ThemeSwitch(isDarkTheme, onThemeSwitch)
        }
    }
}

@Composable
fun ThemeSwitch(isDarkTheme: Boolean, onThemeSwitch: () -> Unit) {
    FloatingActionButton(
        onClick = { onThemeSwitch() },
    ) {
        Icon(Icons.Filled.Add, "Switch Theme")
    }
}

@Composable
fun ListItem(title: String, icon: ImageVector, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.gray_transparent))
                .padding(horizontal = 15.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Icon(
                icon, contentDescription = null, modifier = Modifier.size(28.dp),
                tint = Color.White
            )
            Text(title, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}


//@Preview
//@Composable
//fun AboutPreview() {
//    About()
//}