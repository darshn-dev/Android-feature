package dev.darshn.androdfeatures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import dev.darshn.androdfeatures.databinding.ActivityMainBinding
import dev.darshn.androdfeatures.workmanager.WorkManagerActivity
import kotlin.math.log

private const val TAG = "ACTIVITYLIFE"
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding


    var is20mlSelected = true
    var syringeString = "1,2,1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: MainActivity")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.image.setOnClickListener {
            Log.d(TAG, "Button Clicked: ")
           startActivity(Intent(this, WorkManagerActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: MainActivity ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: MainActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: MainActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: MainActivity")
    }



    var sVolume = "0.1";
    var sDispense = "0.001";

    fun showDialogSyringe(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.layout_syringe, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        //show dialog
        val  mAlertDialog = mBuilder.show()
        val etVol= mDialogView.findViewById<EditText>(R.id.etVolume)
        val etDispense= mDialogView.findViewById<EditText>(R.id.etDispensingRate)
        val tv20Ml= mDialogView.findViewById<TextView>(R.id.tv20ml)
        val tv50Ml= mDialogView.findViewById<TextView>(R.id.tv50ml)
        val btSubmit= mDialogView.findViewById<Button>(R.id.btSubmit)
        val btClear= mDialogView.findViewById<TextView>(R.id.btClear)
        val seekbarVol= mDialogView.findViewById<SeekBar>(R.id.seekBarVolume)
        val seekbarDispense= mDialogView.findViewById<SeekBar>(R.id.seekBarDispense)

         seekbarVol.incrementProgressBy(1)

        seekbarVol.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) {
                    Log.d("SEEKBAr", "onProgressChanged: $progress")
                    sVolume = "${(progress)/10f}";
                    Log.d("SEEKBAr", "new value: $sVolume")
                    etVol.setText(sVolume)
                }
            }
        })

        seekbarDispense.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) {
                    Log.d("SEEKBAr", "onProgressChanged: $progress")
                    sDispense = "${(progress)/1000f}";
                    Log.d("SEEKBAr", "new value: $sDispense")
                    etDispense.setText(sDispense)
                }
            }
        })

        if(is20mlSelected){
            seekbarVol.max = 200
            seekbarDispense.max = 20000
            tv50Ml.alpha = 0.5F
            tv20Ml.alpha = 1.0F
        }else{
            seekbarVol.max = 500
            seekbarDispense.max = 50000
            tv20Ml.alpha = 0.5F
            tv50Ml.alpha = 1.0F
        }

        seekbarVol.setProgress((sVolume.toFloat() * 10).toInt())
        seekbarDispense.setProgress((sDispense.toFloat() * 1000).toInt())
        etDispense.setText(sDispense)
        etVol.setText(sVolume)

        tv20Ml.setOnClickListener {
            seekbarVol.max = 200
            seekbarDispense.max = 20000
            tv50Ml.alpha = 0.5F
            tv20Ml.alpha = 1.0F
            is20mlSelected = true
            seekbarVol.setProgress(1)
            seekbarDispense.setProgress(1)
             sVolume = "0.1";
             sDispense = "0.001";
            etDispense.setText(sDispense)
            etVol.setText(sVolume)
        }

        tv50Ml.setOnClickListener {
            seekbarVol.max = 500
            seekbarDispense.max = 50000
            tv20Ml.alpha = 0.5F
            tv50Ml.alpha = 1.0F

            is20mlSelected = false
            seekbarVol.setProgress(1)
            seekbarDispense.setProgress(1)
            sVolume = "0.1";
            sDispense = "0.001";
            etDispense.setText(sDispense)
            etVol.setText(sVolume)
        }

        btSubmit.setOnClickListener {
            var syringe =  if(is20mlSelected){
               20
            }else{
                50
            }
            syringeString = "${sDispense.toFloat() * 1000},${sVolume.toFloat() * 10},$syringe"
            Log.d("MAIN", "showDialogSyringe: $syringeString")
            mAlertDialog.dismiss()
        }


        btClear.setOnClickListener {
            seekbarVol.setProgress(1)
            seekbarDispense.setProgress(1)
             sVolume = "0.1";
             sDispense = "0.001";
            etDispense.setText(sDispense)
            etVol.setText(sVolume)

        }

        //login button click of custom layout

        //cancel button click of custom layout

    }
}