package dev.darshn.androdfeatures.workmanager

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker.Result.Success
import androidx.work.ListenableWorker.Result.success
import androidx.work.Operation
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class RandomNumberWorker1(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {

    private  val TAG = "RandomNumberWorker1"

    override fun doWork(): Result {


        generateNumber()
        return success()
    }


    override fun onStopped() {
        super.onStopped()
    }

    private fun generateNumber(){

        var i = 5;
        while (i>0){
            Thread.sleep(1000)
            Log.d(TAG, "generateNumber: ${Random.nextInt(19)}" )
            i--;
        }
    }
}