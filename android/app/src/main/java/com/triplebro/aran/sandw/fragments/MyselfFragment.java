package com.triplebro.aran.sandw.fragments;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.activities.LoginActivity;
import com.triplebro.aran.sandw.activities.RegisterActivity;
import com.triplebro.aran.sandw.utils.permissionUtils.PermissionUtils;
import com.triplebro.aran.sandw.views.TwoButtonDialog;


public class MyselfFragment extends Fragment implements View.OnClickListener {

    private View fragment_myself;
    private Button bt_create;
    private Button bt_login;
    private RadioButton rbt_sex_f;
    private RadioButton rbt_sex_m;
    private TextView tv_sex_f;
    private TextView tv_sex_m;
    private LinearLayout ll_contact_phone;
    private ImageView iv_contact_phone;
    private TextView tv_contact_phone;
    private LinearLayout ll_contact_email;
    private ImageView iv_contact_email;
    private TextView tv_contact_email;
    private TextView tv_title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_myself = inflater.inflate(R.layout.fragment_myself, null);
        initView();
        setOnClickListener();
        initData();
        return fragment_myself;
    }

    private void initData() {
        tv_title.setText(R.string.title_myself);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("--------------------onStart-------------------------");
        //TODO 重新请求，查看本地是否存在session,如果有就请求加载个人信息
        //TODO 同时更新UI.可视化注销及个人信息控件
    }


    private void setOnClickListener() {
        bt_create.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        rbt_sex_f.setOnClickListener(this);
        rbt_sex_m.setOnClickListener(this);
        tv_sex_f.setOnClickListener(this);
        tv_sex_m.setOnClickListener(this);
        ll_contact_phone.setOnClickListener(this);
        iv_contact_phone.setOnClickListener(this);
        tv_contact_phone.setOnClickListener(this);
        ll_contact_email.setOnClickListener(this);
        iv_contact_email.setOnClickListener(this);
        tv_contact_email.setOnClickListener(this);
    }

    private void initView() {
        bt_create = fragment_myself.findViewById(R.id.bt_create);
        bt_login = fragment_myself.findViewById(R.id.bt_login);
        rbt_sex_f = fragment_myself.findViewById(R.id.rbt_sex_f);
        rbt_sex_m = fragment_myself.findViewById(R.id.rbt_sex_m);
        tv_sex_f = fragment_myself.findViewById(R.id.tv_sex_f);
        tv_sex_m = fragment_myself.findViewById(R.id.tv_sex_m);
        ll_contact_phone = (LinearLayout) fragment_myself.findViewById(R.id.ll_contact_phone);
        iv_contact_phone = (ImageView) fragment_myself.findViewById(R.id.iv_contact_phone);
        tv_contact_phone = (TextView) fragment_myself.findViewById(R.id.tv_contact_phone);
        ll_contact_email = (LinearLayout) fragment_myself.findViewById(R.id.ll_contact_email);
        iv_contact_email = (ImageView) fragment_myself.findViewById(R.id.iv_contact_email);
        tv_contact_email = (TextView) fragment_myself.findViewById(R.id.tv_contact_email);
        tv_title = getActivity().findViewById(R.id.tv_title);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_create:
                Intent register = new Intent(getActivity(), RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.bt_login:
                Intent login = new Intent(getActivity(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.tv_sex_f:
            case R.id.rbt_sex_f:
                boolean checked_f = rbt_sex_f.isChecked();
                if (checked_f) {
                    rbt_sex_m.setChecked(false);
                    break;
                } else {
                    rbt_sex_f.setChecked(true);
                    rbt_sex_m.setChecked(false);
                    break;
                }
            case R.id.tv_sex_m:
            case R.id.rbt_sex_m:
                boolean checked_m = rbt_sex_m.isChecked();
                if (checked_m) {
                    rbt_sex_f.setChecked(false);
                    break;
                } else {
                    rbt_sex_f.setChecked(false);
                    rbt_sex_m.setChecked(true);
                    break;
                }
            case R.id.ll_contact_phone:
            case R.id.iv_contact_phone:
            case R.id.tv_contact_phone:
                PermissionUtils.requestCallPhonePermission(getActivity(), getActivity());
                TwoButtonDialog twoButtonDialog = new TwoButtonDialog();
                String title = "联系我们";
                String message = "拨打电话：18840919546";
                final String telephone = "18840919546";
                twoButtonDialog.show(title, message, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (ContextCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getActivity(), "未获得权限,请设置开启此权限", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + telephone));
                            getActivity().startActivity(intent);
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "取消呼叫", Toast.LENGTH_SHORT).show();
                    }
                }, getActivity().getFragmentManager());
                break;
            case R.id.ll_contact_email:
            case R.id.iv_contact_email:
            case R.id.tv_contact_email:
                //TODO 调用隐式意图发邮件
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, "374448535@qq.com");
                it.putExtra(Intent.EXTRA_TEXT, "XXXXXXXXXXXXXXXXXXXXXX");
                it.setType("text/plain");
                startActivity(Intent.createChooser(it, "Choose Email Client"));
                break;
        }
    }
}
