package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.activities.RegisterActivity;


public class MyselfFragment extends Fragment implements View.OnClickListener{

    private View fragment_myself;
    private Button bt_create;
    private Button bt_login;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_myself = inflater.inflate(R.layout.fragment_myself, null);
        initView();
        setOnClickListener();
        return fragment_myself;
    }

    private void setOnClickListener() {
        bt_create.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    private void initView() {
        bt_create = fragment_myself.findViewById(R.id.bt_create);
        bt_login = fragment_myself.findViewById(R.id.bt_login);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_create:
                Intent register = new Intent(getActivity(), RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.bt_login:
                Intent login = new Intent(getActivity(), LoginActivity.class);
                startActivity(login);
                break;
        }

    }
}
