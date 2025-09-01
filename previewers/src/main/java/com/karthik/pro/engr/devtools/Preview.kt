package com.karthik.pro.engr.devtools

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@Preview(
    name = "Landscape",
    group = "Orientations",
    showBackground = true,
    showSystemUi = true,
    widthDp = 720,
    heightDp = 360,
    device = Devices.TABLET
)
@Preview(name = "Portrait",
    group = "Orientations",
    showBackground = true,
    showSystemUi = true)
@Preview(
    name = "DarkMode",
    group = "UiMode",
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "LightMode",
    group = "UiMode",
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_NO
)
annotation class AllVariantsPreview
