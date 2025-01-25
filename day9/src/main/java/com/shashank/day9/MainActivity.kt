package com.shashank.day9

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.shashank.day9.callreceiver.IncomingCallReceiver
import com.shashank.day9.databinding.ActivityMainBinding
import com.shashank.day9.foreground.ForegroundService

class MainActivity : AppCompatActivity() {
    private val callManager = IncomingCallReceiver()
    private var binding: ActivityMainBinding? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.READ_PHONE_STATE,
                    android.Manifest.permission.READ_CALL_LOG
                ),
                1
            )
        }

        val filter = IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
        registerReceiver(callManager, filter)

        binding?.tvStart?.setOnClickListener {
            notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            val serviceIntent = Intent(this, ForegroundService::class.java)
            serviceIntent.putExtra("foreground", true)
            startForegroundService(serviceIntent)
        }

    }

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission granted: Proceed with notification
                println("Notification permission granted!")
            } else {
                // Permission denied
                println("Notification permission denied.")
            }
        }

}