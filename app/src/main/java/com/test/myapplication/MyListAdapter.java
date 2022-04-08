package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.model.DataClass;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private DataClass listdata;

    public MyListAdapter(DataClass listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_id.setText(listdata.get(position).getId());
        holder.tv_type.setText(listdata.get(position).getType());

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));
        holder.recyclerView.setAdapter(new BatterAdapter(listdata.get(position).getBatters()));

        holder.top_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));
        holder.top_recyclerView.setAdapter(new ToppinAdapter(listdata.get(position).getTopping()));
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_id;
        public TextView tv_type;
        public RecyclerView recyclerView;
        public RecyclerView top_recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_id = (TextView) itemView.findViewById(R.id.id);
            this.tv_type = (TextView) itemView.findViewById(R.id.type);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_batters);
            this.top_recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_topping);
        }
    }
}