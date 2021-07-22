package dev.darshn.androdfeatures.fragmentCommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import dev.darshn.androdfeatures.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreenFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "FRAGMENT_LIFE";
    private static final String FRAGMENT_NAME = "GreenFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GreenFragment newInstance(String param1, String param2) {
        GreenFragment fragment = new GreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        Log.d(TAG, "onCreate: "+FRAGMENT_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: "+FRAGMENT_NAME);
        return inflater.inflate(R.layout.fragment_green, container, false);
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: "+FRAGMENT_NAME);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: "+FRAGMENT_NAME);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: "+FRAGMENT_NAME);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: "+FRAGMENT_NAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: "+FRAGMENT_NAME);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: "+FRAGMENT_NAME);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: "+FRAGMENT_NAME);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+FRAGMENT_NAME);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: "+FRAGMENT_NAME);
    }
}