package dev.darshn.androdfeatures.boundService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log

class BoundService : Service() {

    private val TAG = "BoundService"
    var binder = MyBinder()
    lateinit var handler :Handler;
    var mProgress : Int = 0;
    var mMaxValue = 5000;
    var isPaused = true;


    //called when service is first created
    override fun onCreate() {
        super.onCreate()
       handler = Handler()
        Log.d(TAG, "onCreate: ")
    }


    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    public fun longRunningTask(){
        var runnable = object : Runnable{
            override fun run() {
                if(mProgress >= mMaxValue||isPaused){
                    Log.d(TAG, "run: removing callback ")
                    handler.removeCallbacks(this)
                    pauseTheTask()
                }else{
                    Log.d(TAG, "run: progress $mProgress")
                    mProgress +=100
                    handler.postDelayed(this,100)
                }
            }

        }

        handler.postDelayed(runnable,100)
    }

    public fun pauseTheTask(){
        isPaused = true
    }

    public fun startTheTask(){
        isPaused = false
        longRunningTask()
    }

    public fun resetTask(){
        isPaused = true
    }

    //Triggered when app is removed from recent list
    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopSelf()
    }





    //Access point to access service
    //Used to get instance of service
    //Binder helps other component to connect with this service
    inner class MyBinder : Binder(){
        fun getService():BoundService{
            return this@BoundService
        }
    }
}