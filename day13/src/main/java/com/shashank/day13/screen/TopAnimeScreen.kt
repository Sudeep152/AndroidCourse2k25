package com.shashank.day13.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.shashank.day13.remote.data.AnimeItem
import com.shashank.day13.viewmodel.AnimeViewModel

@Composable
fun TopAnimeScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<AnimeViewModel>()
    val topAnime = viewModel.animeList.collectAsState()
    Column(modifier = modifier) {
        LazyColumn {
            items(topAnime.value.data) { anime ->
                AnimeCard(animeItem = anime)
            }
        }
    }
}


@Composable
fun AnimeCard(animeItem: AnimeItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = animeItem.images?.jpg?.imageUrl, contentDescription = ""
            )

            Text(text = animeItem.titleEnglish.toString())
            Spacer(Modifier.height(5.dp))
            Text(text = animeItem.synopsis.toString())
            Spacer(Modifier.height(5.dp))
            Text(text = animeItem.duration.toString())
        }
    }
}