package com.example.lab5.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.lab5.R
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Nunito Sans"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Nunito"),
        fontProvider = provider,
    )
)
val CustomFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal)
)
// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)

//val Nunito_Font = FontFamily(
//    Font(R.font.nunito_regular),
//    Font(R.font.nunito_bold, FontWeight.Bold),
//    Font(R.font.nunito_light, FontWeight.Light)
//)
//
//val Typography = Typography(
//    displayLarge = TextStyle( fontFamily = Nunito_Font ),
//    displayMedium = TextStyle( fontFamily = Nunito_Font ),
//    displaySmall = TextStyle( fontFamily = Nunito_Font ),
//    headlineLarge = TextStyle( fontFamily = Nunito_Font ),
//    headlineMedium = TextStyle( fontFamily = Nunito_Font ),
//    headlineSmall = TextStyle( fontFamily = Nunito_Font ),
//    titleLarge = TextStyle( fontFamily = Nunito_Font ),
//    titleMedium = TextStyle( fontFamily = Nunito_Font ),
//    titleSmall = TextStyle( fontFamily = Nunito_Font ),
//    bodyLarge = TextStyle( fontFamily = Nunito_Font ),
//    bodyMedium = TextStyle( fontFamily = Nunito_Font ),
//    bodySmall = TextStyle( fontFamily = Nunito_Font ),
//    labelLarge = TextStyle( fontFamily = Nunito_Font ),
//    labelMedium = TextStyle( fontFamily = Nunito_Font ),
//    labelSmall = TextStyle( fontFamily = Nunito_Font ),
//)