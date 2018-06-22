package com.triplebro.aran.sandw.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.views.InnerListView;

import java.util.List;

public class BrandContentAdapter extends BaseAdapter {

    private Context context;
    private String[] brands;
    private List<String[]> brand_more;

    public BrandContentAdapter(Context context, String[] brands, List<String[]> brand_more) {
        this.context = context;
        this.brands = brands;
        this.brand_more = brand_more;
    }

    @Override
    public int getCount() {
        return brands.length;
    }

    @Override
    public Object getItem(int position) {
        return brands[position];
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
            convertView = View.inflate(context, R.layout.item_brand, null);
            viewHolder.tv_item_brand = convertView.findViewById(R.id.tv_item_brand);
            viewHolder.ll_brand_more = convertView.findViewById(R.id.ll_brand_more);
            viewHolder.lv_brand_more = convertView.findViewById(R.id.lv_brand_more);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item_brand.setText(brands[position]);
        BrandMoreAdapter brandMoreAdapter = new BrandMoreAdapter(context, brand_more.get(0));
        viewHolder.lv_brand_more.setAdapter(brandMoreAdapter);
        viewHolder.lv_brand_more.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO 跳转页面，跳转到对应的品牌商品展示页
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView tv_item_brand;
        LinearLayout ll_brand_more;
        InnerListView lv_brand_more;
    }
}
