package com.rabbi.client.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabbi.client.R
import com.rabbi.client.data.NicknameRepository
import com.rabbi.client.ui.components.SidebarButton
import com.rabbi.client.ui.components.TopBar

private const val MAX_NICKNAME_LENGTH = 16

@Composable
fun RabbiClientScreen(
    nicknameRepository: NicknameRepository,
    onOpenSection: (Section) -> Unit
) {
    val context = LocalContext.current
    var nickname by rememberSaveable { mutableStateOf(nicknameRepository.load()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TopBar(
            nickname = nickname,
            onNicknameChange = {
                val value = it.take(MAX_NICKNAME_LENGTH)
                nickname = value
                nicknameRepository.save(value)
            }
        )

        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Левая колонка кнопок
            Column(
                modifier = Modifier
                    .width(190.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Section.entries.forEach { section ->
                    SidebarButton(
                        text = stringResource(section.titleRes),
                        icon = section.icon,
                        onClick = { onOpenSection(section) }
                    )
                }
            }

            // Центральное превью 16:9
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_preview_placeholder),
                    contentDescription = stringResource(R.string.preview_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(16f / 9f)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }

        // Кнопка «ИГРАТЬ»
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    context.getString(R.string.launching_game),
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp)
        ) {
            Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = null)
            Text(
                text = stringResource(R.string.play),
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
