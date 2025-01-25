package com.shashank.day9.foreground

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.shashank.day9.R

class ForegroundService : Service() {

        private val channelId = "ForegroundServiceChannel"
        private lateinit var manager: NotificationManager

        companion object {
            const val TAG = "ForegroundService"
        }

        override fun onCreate() {
            super.onCreate()

            // Initialize NotificationManager
            manager = getSystemService(NotificationManager::class.java)

            // Create a Notification Channel (Android 8.0+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "Service Channel",
                    NotificationManager.IMPORTANCE_HIGH
                )
                manager.createNotificationChannel(channel)
            }
        }

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            // Build the notification
            val notification = NotificationCompat.Builder(this, channelId)
                .setContentTitle("Foreground Service")
                .setContentText("Running in the background")
                .setSmallIcon(R.drawable.ic_launcher_background) // Replace with a valid drawable resource
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

            // Start the service as a foreground service
            startForeground(1, notification)

            // Simulate a background task in a separate thread
            Thread {
                try {
                    for (i in 1..20) {
                        Log.d(TAG, "Count: $i")
                        Thread.sleep(1000) // Simulate work
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Thread interrupted: ${e.message}")
                }
                Log.d(TAG, "Service task completed.")
            }.start()

            return START_STICKY
        }

        override fun onBind(intent: Intent?): IBinder? {
            // This service is not bound
            return null
        }
    }
