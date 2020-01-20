package me.blog.korn123.easydiary.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import me.blog.korn123.easydiary.activities.*

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val alarm = Alarm(intent.getIntExtra(DevActivity.ALARM_ID, -1), 0, 0, isEnabled = false, vibrate = false, soundTitle = "", soundUri = "", label = "")
        if (context.isScreenOn()) {
            context.showAlarmNotification(alarm)
        } else {
            Intent(context, DiaryReminderActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
            }
        }
    }
}