package com.example.workmanager.OneTimeRequest1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.R
import kotlinx.android.synthetic.main.activity_one_time_requset.*

class OneTimeWorkRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_time_requset)

        //        WorkRequest subclass is
//        i)PeriodicWorkRequest
//        ii)OneTimeWorkRequest
        val oneTimeWorkRequest =
            OneTimeWorkRequest.Builder(MyWorker::class.java).build()
        buttonEnqueue.setOnClickListener {
            WorkManager.getInstance().enqueue(oneTimeWorkRequest)

        }

    }
}