package com.example.finema

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.navigation.Navigation
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.util.appModule
import com.example.finema.ui.settings.NotificationService
import com.example.finema.util.AppPreference
import com.example.finema.util.APP_ACTIVITY
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//TODO добавить по аналогии
// findNavController(R.id.fragment_container)
//                    .addOnDestinationChangedListener { _, destination, _ ->
//                        if(SCREENS_WITHOUT_BOTTOM_BAR.contains(destination.id))
//                            binding.bottomBar.visibility = GONE
//                        else
//                            binding.bottomBar.visibility = VISIBLE
//                    }
class MainActivity : AppCompatActivity() {
    val NOTIFICATION_CHANNEL_ID = "10001"
    private val default_notification_channel_id = "default"
    private lateinit var binding: ActivityMainBinding

    private lateinit var service: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        AppPreference.getPreference(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        startKoin {
            androidContext(this@MainActivity)
            modules(
                appModule
            )
        }


        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {

                R.id.budget -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentHigherLower)

                R.id.tournament -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentTmp)

                R.id.settings -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentSettings)
            }

            true
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val notifications = sharedPreferences.getBoolean("notifications", true)

        if (notifications) {
            scheduleNotification(getNotification(), 5000)
        }
    }

    private fun scheduleNotification(notification: Notification, delay: Long){
        service = Intent(this, NotificationService::class.java)
        service.putExtra(NotificationService.NOTIFICATION_ID, 1)
        service.putExtra(NotificationService.NOTIFICATION, notification)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, service,
            PendingIntent.FLAG_UPDATE_CURRENT)
        val futureMillis: Long = SystemClock.elapsedRealtime() + delay
        val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureMillis, pendingIntent)
//        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, futureMillis,
//            AlarmManager.INTERVAL_HALF_DAY,pendingIntent)
    }

    private fun getNotification(): Notification {
        val resultIntent = Intent(this, MainActivity::class.java)
        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addParentStack(MainActivity::class.java)
        stackBuilder.addNextIntent(resultIntent)
        val resultPendingIntent: PendingIntent =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        return NotificationCompat.Builder(this, default_notification_channel_id)
            .setContentTitle("Стало скучно?")
            .setContentText("Выбери себе фильм на вечер.")
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setContentIntent(resultPendingIntent)
            .build()
    }
}