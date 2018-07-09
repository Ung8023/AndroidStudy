package com.ung8023.androidbase.view.fragment.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ung8023.androidbase.R;

public class SampleFragment extends Fragment {


    public SampleFragment() {
        Log.w("Fragment:", "构造方法");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.w("Fragment:", "onCreateView");
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("Fragment:", "onCreate");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.w("Fragment:", "onHiddenChange: " + hidden);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.w("Fragment:", "onActivityCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.w("Fragment:", "onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("Fragment:", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("Fragment:", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("Fragment:", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("Fragment:", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("Fragment:", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("Fragment:", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.w("Fragment:", "onDetach");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("Fragment:", "onViewCreated");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.w("Fragment:", "setUserVisibleHint: " + isVisibleToUser);
    }
}
