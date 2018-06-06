package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triplebro.aran.sandw.R;


public class BrandFragment extends Fragment {

    private View fragment_brand;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_brand = inflater.inflate(R.layout.fragment_brand, null);
        return fragment_brand;
    }
}
