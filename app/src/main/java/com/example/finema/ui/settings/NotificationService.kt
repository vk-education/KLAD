package com.example.finema.ui.settings

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.finema.MainActivity


class NotificationService(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams){

    override fun doWork(): Result {
        sendNotification();
        return Result.success();
    }

    private fun sendNotification() {
        val notificationManager =
            applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val resultIntent = Intent(applicationContext, MainActivity::class.java)
        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(applicationContext)
        stackBuilder.addParentStack(MainActivity::class.java)
            .addNextIntent(resultIntent)
        val resultPendingIntent: PendingIntent =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(applicationContext, "default")
            .setContentTitle("Стало скучно?")
            .setContentText("Выбери себе фильм на вечер.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.mipmap.sym_def_app_icon)
            .setAutoCancel(true)
            .setContentIntent(resultPendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notification.build())
    }
}