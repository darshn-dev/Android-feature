package dev.darshn.androdfeatures.boundService

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.darshn.androdfeatures.R
import dev.darshn.androdfeatures.databinding.ActivityBoundServiceBinding

class BoundServiceActivity : AppCompatActivity() {
    lateinit var binding : ActivityBoundServiceBinding
    var myBoundService: BoundService? = null
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initUI()
    }

    override fun onResume() {
        super.onResume()
        startService();
    }

    override fun onPause() {
        super.onPause()
        if(viewModel.getBinder()!=null){
            unbindService(viewModel.serviceConnection())
        }
    }

    private fun startService(){
        startService(Intent(this, BoundService::class.java))
        bindService()
    }

    private fun bindService(){
        bindService(Intent(this, BoundService::class.java), viewModel.serviceConnection(), BIND_AUTO_CREATE)
    }

    private fun toggleUpdate(){
            myBoundService?.let{
                if(it.mProgress == it.mMaxValue){
                    it.resetTask()
                    binding.btSubmit.setText("Start")
                }else{
                    if(it.isPaused){
                        it.startTheTask()
                        viewModel.isUpdating(true)
                    }else{
                        it.pauseTheTask()
                        viewModel.isUpdating(false)
                    }
                }
            }
    }

    fun initUI(){
        binding.btSubmit.setOnClickListener {
            toggleUpdate();
        }

        viewModel.getBinder().observe(this, Observer {
            myBoundService = it.getService()
        })

        viewModel.getIsProgressUpdating().observe(this,{

            var hanler = Handler()
            var runnable = object : Runnable{
                override fun run() {
                    if(it){
                        if(viewModel.getBinder().value!=null){
                            viewModel.isUpdating(false)
                        }

                        myBoundService?.let {
                            binding.progressBar.setProgress(it.mProgress)
                            binding.progressBar.max = it.mMaxValue
                            var progress = 100*it.mProgress / it.mMaxValue
                            binding.tvProgress.text = "$progress %"
                        }


                        hanler.postDelayed(this,100)
                    }else{
                        hanler.removeCallbacks(this)
                    }
                }

            }

            if(it){
                binding.btSubmit.text = "Pause"
                hanler.postDelayed(runnable, 100)
            }else{
                if(myBoundService?.mProgress == myBoundService?.mMaxValue){
                    binding.btSubmit.text = "Restart"
                }else{
                    binding.btSubmit.text = "Start"
                }
            }

        })
    }
}