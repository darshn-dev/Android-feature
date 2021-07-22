package dev.darshn.androdfeatures.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import dev.darshn.androdfeatures.databinding.ActivityWorkManagerBinding
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    private  val TAG = "ACTIVITYLIFE"

    lateinit var binding : ActivityWorkManagerBinding
    lateinit var workManager : WorkManager
    lateinit var workRequest: WorkRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate:WorkManagerActivity ")

        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btStartWork.setOnClickListener {
            finish()
        }
        //initUI()

    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart: WorkManagerActivity ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: WorkManagerActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: WorkManagerActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: WorkManagerActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: WorkManagerActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: WorkManagerActivity")
    }



    private fun initUI(){

        workManager = WorkManager.getInstance(applicationContext)
        workRequest = PeriodicWorkRequest.Builder(RandomNumberWorker1::class.java,15,TimeUnit.MINUTES).build()
        binding.btStartWork.setOnClickListener {
            workManager.enqueue(workRequest)
        }

        binding.btStopWork.setOnClickListener {
            workManager.cancelWorkById(workRequest.id)
        }
    }


}