package com.shashank.musicapp.service

import android.R.raw
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.shashank.musicapp.R


class MusicService : Service() {

    private var mediaPlayer: MediaPlayer? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.getStringExtra("ACTION")
        when (action) {
            "PLAY" -> {
               playMusic()
            }

            "PAUSE" -> {
                      pauseMusic()
            }

            "NEXT_SONG" -> {

            }

            "PREVIOUS_SONG" -> {

            }
            "STOP_MUSIC"-> {
                stopMusic()
            }
        }
        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun playMusic() {
        if (mediaPlayer == null) {
            // Handle this is thing later
//            mediaPlayer = MediaPlayer()
//            mediaPlayer
        }
        mediaPlayer?.start()
        showNotification()
//        if (mediaPlayer != null && mediaPlayer!!.isPlaying){
//
//        }
    }

    private fun pauseMusic() {
        mediaPlayer?.pause()
    }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        stopForeground(true)
        stopSelf()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotification() {
        val notification = NotificationCompat.Builder(this, "MUSIC_CHANNEL")
            .setContentTitle("Music App")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .build()

        startForeground(1, notification)
    }


    override fun onBind(intent: Intent?): IBinder? {
      return null
    }
}