package com.rabbi.client.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rabbi.client.R

@Composable
fun TopBar(
    nickname: String,
    onNicknameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NewsPanel(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = nickname,
            onValueChange = onNicknameChange,
            modifier = Modifier.width(260.dp),
            singleLine = true,
            label = { Text(stringResource(R.string.nickname_label)) }
        )
    }
}
