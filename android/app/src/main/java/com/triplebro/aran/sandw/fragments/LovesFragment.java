package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triplebro.aran.sandw.R;


public class LovesFragment extends Fragment {

    private View fragment_loves;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        fragment_loves = inflater.inflate(R.layout.fragment_loves, null);
        return fragment_loves;
    }
}
