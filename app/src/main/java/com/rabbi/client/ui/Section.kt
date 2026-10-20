package com.rabbi.client.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.rabbi.client.R

enum class Section(
    val route: String,
    @StringRes val titleRes: Int,
    val icon: ImageVector
) {
    VERSIONS("versions", R.string.section_versions, Icons.Filled.Star),
    MODS("mods", R.string.section_mods, Icons.Filled.Build),
    SETTINGS("settings", R.string.section_settings, Icons.Filled.Settings),
    LOGS("logs", R.string.section_logs, Icons.Filled.Info),
    SKINS("skins", R.string.section_skins, Icons.Filled.Face)
}
