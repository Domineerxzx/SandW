package com.triplebro.aran.sandw.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;

public class BrandMoreAdapter extends BaseAdapter {

    private Context context;
    private String[] brand_more;

    public BrandMoreAdapter(Context context, String[] brand_more) {
        this.context = context;
        this.brand_more = brand_more;
    }

    @Override
    public int getCount() {
        return brand_more.length;
    }

    @Override
    public Object getItem(int position) {
        return brand_more[position];
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
            convertView = View.inflate(context, R.layout.item_brand_more, null);
            viewHolder.tv_item_more_brand = convertView.findViewById(R.id.tv_item_more_brand);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item_more_brand.setText(brand_more[position]);
        return convertView;
    }

    private class ViewHolder {
        TextView tv_item_more_brand;
    }
}
