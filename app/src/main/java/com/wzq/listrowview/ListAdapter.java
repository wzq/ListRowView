package com.wzq.listrowview;

import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wzq on 2018/3/23.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {

    private List<String> data;
    public ListAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.title.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        private TextView title;
        private HorizontalGridView items;

        public Holder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.row_title);
            items = itemView.findViewById(R.id.row_children);
            items.setNumRows(1);
            items.setHasFixedSize(true);
            items.setAdapter(new RecyclerView.Adapter() {
                @Override
                public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                    View imt = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
                    ImageCardView v = new ImageCardView(parent.getContext());
                    ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(200, 250);
                    layoutParams.setMargins(15,25,15,25);
                    v.setLayoutParams(layoutParams);
                    v.setImageUrl(R.drawable.migu);

                    return new RecyclerView.ViewHolder(v) {};
                }

                @Override
                public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                }

                @Override
                public int getItemCount() {
                    return 20;
                }
            });
        }
    }

}
