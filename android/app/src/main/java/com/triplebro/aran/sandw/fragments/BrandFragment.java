package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.activities.BrandListActivity;


public class BrandFragment extends Fragment implements View.OnClickListener{

    private View fragment_brand;
    private TextView tv_title;
    private TextView tv_brand_list;
    private RelativeLayout rl_brand_list;
    private ImageView iv_brand_list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_brand = inflater.inflate(R.layout.fragment_brand, null);
        initView();
        initData();
        setOnClickListener();
        return fragment_brand;
    }

    private void setOnClickListener() {
        tv_brand_list.setOnClickListener(this);
        rl_brand_list.setOnClickListener(this);
        iv_brand_list.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText(R.string.title_brand);
    }

    private void initView() {
        tv_title = getActivity().findViewById(R.id.tv_title);
        tv_brand_list = (TextView) fragment_brand.findViewById(R.id.tv_brand_list);
        rl_brand_list = (RelativeLayout) fragment_brand.findViewById(R.id.rl_brand_list);
        iv_brand_list = (ImageView) fragment_brand.findViewById(R.id.iv_brand_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_brand_list:
            case R.id.rl_brand_list:
            case R.id.iv_brand_list:
                Intent brandList = new Intent(getActivity(), BrandListActivity.class);
                getActivity().startActivity(brandList);
                break;

        }
    }
}
