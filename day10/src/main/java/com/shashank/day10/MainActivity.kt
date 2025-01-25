package com.shashank.day10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shashank.day10.screens.HelloScreen
import com.shashank.day10.ui.theme.AndroidCourse2k25Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourse2k25Theme {
                    HelloScreen()
            }
        }
    }
}
