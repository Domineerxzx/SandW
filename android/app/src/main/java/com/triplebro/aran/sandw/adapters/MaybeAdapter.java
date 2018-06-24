package com.triplebro.aran.sandw.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.triplebro.aran.sandw.R;

public class MaybeAdapter extends RecyclerView.Adapter<MaybeAdapter.ViewHolder> {

    private Context context;

    public MaybeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_search_maybe, null);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.iv_maybe = view.findViewById(R.id.iv_maybe);
        viewHolder.tv_maybe = view.findViewById(R.id.tv_maybe);
        viewHolder.tv_maybe_more = view.findViewById(R.id.tv_maybe_more);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_maybe;
        private TextView tv_maybe;
        private TextView tv_maybe_more;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
