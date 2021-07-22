package dev.darshn.androdfeatures.boundService

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private  val TAG = "MainActivityViewModel"
    
    private var isProgressUpdating = MutableLiveData<Boolean>()
    private var mBinder = MutableLiveData<BoundService.MyBinder>()

    private var serviceConnection = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.d(TAG, "onServiceConnected: connected to service")
            mBinder.postValue(p1 as BoundService.MyBinder)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected: connected to service")
            mBinder.postValue(null)
        }

    }

    public fun  getIsProgressUpdating() : LiveData<Boolean> =  isProgressUpdating

    public fun getBinder() : LiveData<BoundService.MyBinder> = mBinder

    public fun serviceConnection() = serviceConnection

    public fun isUpdating(isUpdating: Boolean) {
        isProgressUpdating.value = isUpdating
    }
}