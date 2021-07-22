package dev.darshn.androdfeatures.fragmentCommunication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.darshn.androdfeatures.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val TAG = "FRAGMENT_LIFE"
    private val FRAGMENT_NAME = "RedFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    interface dataReceiveListner{
        fun onDataReceived(msg:String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: $FRAGMENT_NAME")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: $FRAGMENT_NAME")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: $FRAGMENT_NAME")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $FRAGMENT_NAME")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $FRAGMENT_NAME")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: $FRAGMENT_NAME")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: $FRAGMENT_NAME")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $FRAGMENT_NAME")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: $FRAGMENT_NAME")
    }
}