package com.shashank.day5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.day5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        mainBinding?.button?.setOnClickListener {
            val name = mainBinding?.teName?.getText().toString()
            val intent = Intent(this,BirthdayCardActivity::class.java)
            intent.putExtra("NAME",name)
            startActivity(intent)
        }

    }
}