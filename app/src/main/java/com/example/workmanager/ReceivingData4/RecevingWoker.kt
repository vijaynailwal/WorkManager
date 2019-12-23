package com.example.workmanager.ReceivingData4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.workmanager.R

class RecevingWoker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        val taskDesc = inputData.getString(TASK_DESC)
        displayNotification("My Worker", taskDesc)
        //setting output data
        val data = Data.Builder()
            .putString(TASK_DESC, "The conclusion of the task")
            .build()
        // setOutputData(data);
        return Result.success()
    }

    private fun displayNotification(title: String, task: String?) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "simplifiedcoding",
                "simplifiedcoding",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        val notification =
            NotificationCompat.Builder(applicationContext, "simplifiedcoding")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, notification.build())
    }

    companion object {
        const val TASK_DESC = "task_desc"
    }
}