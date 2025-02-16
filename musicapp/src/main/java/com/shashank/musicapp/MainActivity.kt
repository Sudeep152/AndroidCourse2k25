package com.shashank.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shashank.musicapp.screen.MyMusicListScreen
import com.shashank.musicapp.ui.theme.AndroidCourse2k25Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourse2k25Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyMusicListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
