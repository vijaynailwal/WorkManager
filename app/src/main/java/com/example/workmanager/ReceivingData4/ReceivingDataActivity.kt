package com.example.workmanager.ReceivingData4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.R
import com.example.workmanager.SendingData3.ReceiveWorker
import kotlinx.android.synthetic.main.activity_receiving_data.*

class ReceivingDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiving_data)
        val data = Data.Builder()
            .putString(ReceiveWorker.TASK_DESC, "The task data passed from MainActivity")
            .build()
        val workRequest = OneTimeWorkRequest.Builder(ReceiveWorker::class.java)
            .setInputData(data)
            .build()
        buttonEnqueue.setOnClickListener{
            WorkManager.getInstance().enqueue(workRequest)
        }
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer { workInfo ->
                // receiving back the data
                if (workInfo != null && workInfo.state.isFinished) textViewStatus.append(
                    workInfo.outputData.getString(RecevingWoker.TASK_DESC) + "\n"
                )
                textViewStatus.append(workInfo!!.state.name + "\n")
            })
    }
}