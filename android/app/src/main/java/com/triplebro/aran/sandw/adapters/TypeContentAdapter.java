package com.triplebro.aran.sandw.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.fragments.TypeFragment;
import com.triplebro.aran.sandw.views.InnerListView;

import java.util.List;

public class TypeContentAdapter extends BaseAdapter {

    private Context context;
    private String[] types;
    private List<String[]> type_more;

    public TypeContentAdapter(Context context, String[] types, List<String[]> type_more) {
        this.context = context;
        this.types = types;
        this.type_more = type_more;
    }

    @Override
    public int getCount() {
        return types.length;
    }

    @Override
    public Object getItem(int position) {
        return types[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_type, null);
            viewHolder.tv_item_type = convertView.findViewById(R.id.tv_item_type);
            viewHolder.ll_type_more = convertView.findViewById(R.id.ll_type_more);
            viewHolder.lv_type_more = convertView.findViewById(R.id.lv_type_more);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item_type.setText(types[position]);
        TypeMoreAdapter typeMoreAdapter = new TypeMoreAdapter(context, type_more.get(position));
        viewHolder.lv_type_more.setAdapter(typeMoreAdapter);
        viewHolder.tv_item_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.ll_type_more.getVisibility() == View.GONE) {
                    viewHolder.ll_type_more.setVisibility(View.VISIBLE);
                }else{
                    viewHolder.ll_type_more.setVisibility(View.GONE);
                }
            }
        });
        viewHolder.lv_type_more.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO 跳转页面，跳转到对应的类别商品展示页
            }
        });
        viewHolder.ll_type_more.setVisibility(View.GONE);
        return convertView;
    }

    private class ViewHolder {
        TextView tv_item_type;
        LinearLayout ll_type_more;
        InnerListView lv_type_more;
    }
}
