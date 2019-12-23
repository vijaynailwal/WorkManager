package com.example.workmanager.PeriodicRequest2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.PeriodicRequest2.PeriodicWork
import com.example.workmanager.R
import kotlinx.android.synthetic.main.activity_periodic_work_request.*

class PeriodicWorkRequestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periodic_work_request)


        val data = Data.Builder()
            .putString("task_desc", "The task data passed from MainActivity").build()
        Log.e("data1", data.getString("task_desc"))
        val oneTimeWorkRequest =
            OneTimeWorkRequest.Builder(PeriodicWork::class.java).setInputData(data).build()
        buttonEnqueue.setOnClickListener{
            WorkManager.getInstance().enqueue(oneTimeWorkRequest)
        }
        WorkManager.getInstance().getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, Observer { workInfo -> textViewStatus.append(workInfo!!.state.name + "\n") })
    }
}