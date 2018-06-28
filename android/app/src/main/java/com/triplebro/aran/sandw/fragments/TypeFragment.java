package com.triplebro.aran.sandw.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.adapters.TypeContentAdapter;

import java.util.ArrayList;
import java.util.List;


public class TypeFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private View fragment_type;
    private ListView lv_type_content;
    //TODO 类别名称服务器请求
    private String[] types_f = new String[]{"1", "1", "1", "1"};
    private String[] types_m = new String[]{"2", "2", "2", "2"};
    private String[] types_c = new String[]{"3", "3", "3", "3"};
    private List<String[]> type_more = new ArrayList<>();
    private LinearLayout ll_type_title_f;
    private Button bt_type_title_f;
    private View v_type_title_f;
    private LinearLayout ll_type_title_m;
    private Button bt_type_title_m;
    private View v_type_title_m;
    private LinearLayout ll_type_title_c;
    private Button bt_type_title_c;
    private View v_type_title_c;
    private Button lastClickButton;
    private View lastClickView;
    private TypeContentAdapter typeContentAdapter_f;
    private TypeContentAdapter typeContentAdapter_m;
    private TypeContentAdapter typeContentAdapter_c;
    private TextView tv_type_sale;
    private ImageView iv_type_sale;
    private RelativeLayout rl_type_sale;
    private TextView tv_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_type = inflater.inflate(R.layout.fragment_type, null);
        initView();
        setOnClickListener();
        initData();
        ReactInstanceManagerBuilder builder = ReactInstanceManager.builder();
        return fragment_type;
    }

    private void setOnClickListener() {
        ll_type_title_f.setOnClickListener(this);
        bt_type_title_f.setOnClickListener(this);
        ll_type_title_m.setOnClickListener(this);
        bt_type_title_m.setOnClickListener(this);
        ll_type_title_c.setOnClickListener(this);
        bt_type_title_c.setOnClickListener(this);
        lv_type_content.setOnItemClickListener(this);
        tv_type_sale.setOnClickListener(this);
        iv_type_sale.setOnClickListener(this);
        rl_type_sale.setOnClickListener(this);
    }

    private void initData() {
        tv_title.setText(R.string.title_type);
        typeContentAdapter_f = new TypeContentAdapter(getActivity(), types_f, type_more);
        lv_type_content.setAdapter(typeContentAdapter_f);
        //TODO 子类别服务器获取
        String[] type_more_1 = new String[]{"4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4"};
        String[] type_more_2 = new String[]{"5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5"};
        String[] type_more_3 = new String[]{"6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6"};
        String[] type_more_4 = new String[]{"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"};

        type_more.add(type_more_1);
        type_more.add(type_more_2);
        type_more.add(type_more_3);
        type_more.add(type_more_4);

    }

    private void initView() {
        tv_title = getActivity().findViewById(R.id.tv_title);
        lv_type_content = fragment_type.findViewById(R.id.lv_type_content);
        ll_type_title_f = fragment_type.findViewById(R.id.ll_type_title_f);
        bt_type_title_f = fragment_type.findViewById(R.id.bt_type_title_f);
        v_type_title_f = fragment_type.findViewById(R.id.v_type_title_f);
        ll_type_title_m = fragment_type.findViewById(R.id.ll_type_title_m);
        bt_type_title_m = fragment_type.findViewById(R.id.bt_type_title_m);
        v_type_title_m = fragment_type.findViewById(R.id.v_type_title_m);
        ll_type_title_c = fragment_type.findViewById(R.id.ll_type_title_c);
        bt_type_title_c = fragment_type.findViewById(R.id.bt_type_title_c);
        v_type_title_c = fragment_type.findViewById(R.id.v_type_title_c);
        lastClickButton = bt_type_title_f;
        lastClickView = v_type_title_f;
        tv_type_sale = fragment_type.findViewById(R.id.tv_type_sale);
        iv_type_sale = fragment_type.findViewById(R.id.iv_type_sale);
        rl_type_sale = fragment_type.findViewById(R.id.rl_type_sale);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_type_title_f:
            case R.id.bt_type_title_f:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_type_title_f.setTextColor(Color.BLACK);
                v_type_title_f.setBackgroundColor(Color.BLACK);
                lastClickView = v_type_title_f;
                lastClickButton = bt_type_title_f;
                if (typeContentAdapter_f == null) {

                    typeContentAdapter_f = new TypeContentAdapter(getActivity(), types_f, type_more);
                }
                lv_type_content.setAdapter(typeContentAdapter_f);
                break;
            case R.id.ll_type_title_m:
            case R.id.bt_type_title_m:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_type_title_m.setTextColor(Color.BLACK);
                v_type_title_m.setBackgroundColor(Color.BLACK);
                lastClickView = v_type_title_m;
                lastClickButton = bt_type_title_m;
                if (typeContentAdapter_m == null) {

                    typeContentAdapter_m = new TypeContentAdapter(getActivity(), types_m, type_more);
                }
                lv_type_content.setAdapter(typeContentAdapter_m);
                break;
            case R.id.ll_type_title_c:
            case R.id.bt_type_title_c:
                lastClickButton.setTextColor(Color.GRAY);
                lastClickView.setBackgroundColor(Color.GRAY);
                bt_type_title_c.setTextColor(Color.BLACK);
                v_type_title_c.setBackgroundColor(Color.BLACK);
                lastClickView = v_type_title_c;
                lastClickButton = bt_type_title_c;
                if (typeContentAdapter_c == null) {

                    typeContentAdapter_c = new TypeContentAdapter(getActivity(), types_c, type_more);
                }
                lv_type_content.setAdapter(typeContentAdapter_c);
                break;
            case R.id.tv_type_sale:
            case R.id.iv_type_sale:
            case R.id.rl_type_sale:
                //TODO 跳转折扣商品展示页--->Aran
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO 子类别服务器获取
        String[] type_more_1 = new String[]{"4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4"};
        String[] type_more_2 = new String[]{"5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5"};
        String[] type_more_3 = new String[]{"6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6"};
        String[] type_more_4 = new String[]{"7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"};

        type_more.add(type_more_1);
        type_more.add(type_more_2);
        type_more.add(type_more_3);
        type_more.add(type_more_4);
        LinearLayout ll_type_more = view.findViewById(R.id.ll_type_more);
        ll_type_more.setVisibility(View.VISIBLE);
    }
}
