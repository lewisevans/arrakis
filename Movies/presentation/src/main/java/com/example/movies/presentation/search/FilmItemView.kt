package com.example.movies.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movies.domain.FilmDomainEntity

@Composable
fun FilmItemView(item: FilmDomainEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp)
            .background(
                MaterialTheme.colors.onBackground.copy(alpha = .2f),
                RoundedCornerShape(4.dp)
            )
            .clickable {
                //callbackOpen(item)
            }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.poster,
            contentDescription = item.title,
            modifier = Modifier.size(96.dp)
                .background(MaterialTheme.colors.background.copy(alpha = .5f))
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = item.title,
                color = MaterialTheme.colors.onBackground,
            )
            Text(
                text = item.genre.joinToString(","),
                color = MaterialTheme.colors.onBackground,
            )
        }
    }
}