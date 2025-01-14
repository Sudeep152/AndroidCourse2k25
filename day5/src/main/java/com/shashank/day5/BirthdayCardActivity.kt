package com.shashank.day5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.day5.databinding.ActivityBirthdayCardBinding

class BirthdayCardActivity : AppCompatActivity() {
    private var mainBinding: ActivityBirthdayCardBinding? = null
    private var name:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityBirthdayCardBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
        name = intent.getStringExtra("NAME")
        mainBinding?.tvName?.text = name
    }
}