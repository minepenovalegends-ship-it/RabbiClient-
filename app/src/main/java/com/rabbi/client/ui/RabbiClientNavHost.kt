package com.rabbi.client.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rabbi.client.R
import com.rabbi.client.data.NicknameRepository

private const val ROUTE_MAIN = "main"

@Composable
fun RabbiClientNavHost(nicknameRepository: NicknameRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ROUTE_MAIN) {
        composable(ROUTE_MAIN) {
            RabbiClientScreen(
                nicknameRepository = nicknameRepository,
                onOpenSection = { navController.navigate(it.route) }
            )
        }
        Section.entries.forEach { section ->
            composable(section.route) {
                StubScreen(
                    title = stringResource(section.titleRes),
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
private fun StubScreen(title: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = stringResource(R.string.stub_text),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
