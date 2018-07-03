package com.triplebro.aran.sandw.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;
import com.triplebro.aran.sandw.views.TwoButtonDialog;

public class ShopBagAdapter extends BaseAdapter {

    private Context context;
    private String[] s;

    public ShopBagAdapter(Context context, String[] s) {
        this.context = context;
        this.s = s;
    }

    @Override
    public int getCount() {
        return s.length;
    }

    @Override
    public Object getItem(int position) {
        return s[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ShopBagAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ShopBagAdapter.ViewHolder();
            convertView = View.inflate(context, R.layout.item_shop_bag, null);
            viewHolder.iv_count = convertView.findViewById(R.id.iv_count);
            viewHolder.ll_size = convertView.findViewById(R.id.ll_size);
            viewHolder.ll_count = convertView.findViewById(R.id.ll_count);
            viewHolder.iv_delete_goods = convertView.findViewById(R.id.iv_delete_goods);
            viewHolder.tv_coast = convertView.findViewById(R.id.tv_coast);
            viewHolder.tv_size_title = convertView.findViewById(R.id.tv_size_title);
            viewHolder.tv_count_title = convertView.findViewById(R.id.tv_count_title);
            viewHolder.tv_size = convertView.findViewById(R.id.tv_size);
            viewHolder.tv_count = convertView.findViewById(R.id.tv_count);
            viewHolder.tv_goods_name = convertView.findViewById(R.id.tv_goods_name);
            viewHolder.iv_goods = convertView.findViewById(R.id.iv_goods);
            viewHolder.iv_size = convertView.findViewById(R.id.iv_size);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ShopBagAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.iv_delete_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoButtonDialog twoButtonDialog = new TwoButtonDialog();
                twoButtonDialog.show("移除商品", "确定要将该商品移出购物袋吗？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO 告知服务器移除商品
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                },((Activity)context).getFragmentManager());
            }
        });
        return convertView;
    }

    private class ViewHolder{
        private ImageView iv_goods;
        private TextView tv_goods_name;
        private TextView tv_count;
        private TextView tv_size;
        private TextView tv_count_title;
        private TextView tv_size_title;
        private TextView tv_coast;
        private ImageView iv_delete_goods;
        private LinearLayout ll_count;
        private LinearLayout ll_size;
        private ImageView iv_count;
        private ImageView iv_size;
    }
}
