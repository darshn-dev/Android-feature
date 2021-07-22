package dev.darshn.androdfeatures.fragmentCommunication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.darshn.androdfeatures.R
import dev.darshn.androdfeatures.databinding.ActivityCommunicationBinding

class CommunicationActivity : AppCompatActivity(), RedFragment.dataReceiveListner {


    lateinit var binding : ActivityCommunicationBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_communication)
    }

    override fun onDataReceived(msg: String) {

    }
}