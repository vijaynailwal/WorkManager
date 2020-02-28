package com.example.workmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import com.example.workmanager.Constraints5.ConstraintActivity
import com.example.workmanager.OneTimeRequest1.OneTimeWorkRequestActivity
import com.example.workmanager.PeriodicRequest2.PeriodicWorkRequestActivity
import com.example.workmanager.ReceivingData4.ReceivingDataActivity
import com.example.workmanager.SendingData3.SendingAndReceivingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_onetimerequest.setOnClickListener {
            val intent = Intent(this, OneTimeWorkRequestActivity::class.java)
            startActivity(intent)
        }
        btn_periodicrequest.setOnClickListener {
            val intent = Intent(this, PeriodicWorkRequestActivity::class.java)
            startActivity(intent)
        }
        btn_receivedata.setOnClickListener {
            val intent = Intent(this, ReceivingDataActivity::class.java)
            startActivity(intent)
        }
        btn_receivedata.setOnClickListener {
            val intent = Intent(this, SendingAndReceivingActivity::class.java)
            startActivity(intent)

        }
        btn_constraint.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)

        }

    }
}