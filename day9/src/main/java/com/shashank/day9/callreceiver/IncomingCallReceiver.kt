package com.shashank.day9.callreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class IncomingCallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val phoneNum = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
                Log.d("IncomingCallReceiver", "Incoming call detected $phoneNum")
            } else if (state == TelephonyManager.EXTRA_STATE_OFFHOOK){
                Log.d("IncomingCallReceiver", "Call answered from $phoneNum")
            }
        }
    }
}