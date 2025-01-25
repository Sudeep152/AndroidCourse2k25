package com.shashank.day10.screens

import android.R.color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HelloScreen() {
    Scaffold(modifier = Modifier.padding(16.dp)) { innerpadding ->
            LazyColumn {
                items(1000) { index ->
                    Text("Item $index")
                }
            }
    }
}


@Composable
fun MyCustomBox(color: Color = Color.LightGray) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
            .padding(16.dp)
    ) {
        Text("Hello")
    }
}


