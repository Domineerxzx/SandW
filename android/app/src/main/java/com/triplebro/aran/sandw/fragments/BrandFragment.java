package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;


public class BrandFragment extends Fragment {

    private View fragment_brand;
    private TextView tv_title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_brand = inflater.inflate(R.layout.fragment_brand, null);
        initView();
        initData();
        return fragment_brand;
    }

    private void initData() {
        tv_title.setText(R.string.title_brand);
    }

    private void initView() {
        tv_title = getActivity().findViewById(R.id.tv_title);
    }
}
