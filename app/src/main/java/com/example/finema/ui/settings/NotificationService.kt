package com.example.finema.ui.settings

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build


class NotificationService: BroadcastReceiver() {

    private val channel = "MyChannel2"
    private val id = 111




//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Log.d(tag, "CREATE NOTIF")
//
//        Thread.sleep(5000)
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            val channel =
//                NotificationChannel(channel, "My channel", NotificationManager.IMPORTANCE_MIN)
//            val notificationService: NotificationManager =
//                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//            notificationService.createNotificationChannel(channel)
//        }
//
//        val notification = NotificationCompat.Builder(this, channel)
//            .setContentTitle("Стало скучно?")
//            .setContentText("Выбери себе фильм на вечер.")
//            .setPriority(NotificationCompat.PRIORITY_LOW)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setAutoCancel(true)
//            .build()
//
//        startForeground(id, notification)
//
//        return START_NOT_STICKY
//    }

    companion object {

        var NOTIFICATION_ID = "notification-id"
        var NOTIFICATION = "notification"
    }
//    override fun onReceive(context: Context?, intent: Intent?) {
//        val notification = NotificationCompat.Builder(context)
//            .setContentTitle("Стало скучно?")
//            .setContentText("Выбери себе фильм на вечер.")
//            .setPriority(NotificationCompat.PRIORITY_LOW)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setAutoCancel(true)
//            .build()
//
//        val manager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        manager.notify(0, notification)
//    }

    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification: Notification = intent.getParcelableExtra(NOTIFICATION)!!
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("10001", "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_MIN)
            notificationManager.createNotificationChannel(channel)
        }
        val id = intent.getIntExtra(NOTIFICATION_ID, 0)
        notificationManager.notify(id, notification)
    }
}