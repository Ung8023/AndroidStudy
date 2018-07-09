package com.ung8023.androidbase.view.fragment.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ung8023.androidbase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SamplePageFragment extends Fragment {


    public SamplePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample_page, container, false);
    }

}
