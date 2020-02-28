package com.example.workmanager.Constraints5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.workmanager.R
import com.example.workmanager.ReceivingData4.RecevingWoker
import kotlinx.android.synthetic.main.activity_constraint.*
import androidx.lifecycle.Observer


class ConstraintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)


        val constraints: Constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val request = OneTimeWorkRequest.Builder(ConstraintWorker::class.java)
            .setConstraints(constraints)
            .build()


        btn_Constraint.setOnClickListener {
            WorkManager.getInstance().enqueue(request)
        }
        WorkManager.getInstance().getWorkInfoByIdLiveData(request.id)
            .observe(this, Observer { workInfo ->
                // receiving back the data
                if (workInfo != null && workInfo.state.isFinished)
                    textViewStatus.append(
                    workInfo.outputData.getString(RecevingWoker.TASK_DESC) + "\n"
                )
                textViewStatus.append(workInfo!!.state.name + "\n")
            })

    }
}
