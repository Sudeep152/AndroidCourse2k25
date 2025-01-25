package com.shashank.day9.background

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BackgroundService : Service() {
  companion object{
      const val  TAG = "Background Service"
  }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"Service is created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(kotlinx.coroutines.Runnable {
            try {
                for (i in 1..20) {
                    Log.d(TAG, "Count: $i")
                    Thread.sleep(500) // Assuming you want a half-second delay between counts
                }
            } catch (e: InterruptedException) {
                Log.d(TAG, "Thread Interrupted")
            }
            Log.d(TAG, "Service is finished")
        }).start()
        
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
     return null
    }
}