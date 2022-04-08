package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.model.Batter;
import com.test.myapplication.model.Batters;
import com.test.myapplication.model.DataClass;

public class BatterAdapter  extends RecyclerView.Adapter<BatterAdapter.ViewHolder>{

    Batters listdata;
    public BatterAdapter(Batters listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_row_batters, parent, false);
        BatterAdapter.ViewHolder viewHolder = new BatterAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText(listdata.getBatter().get(position).getId());
        holder.tv_type.setText(listdata.getBatter().get(position).getType());

    }

    @Override
    public int getItemCount() {
        return listdata.getBatter().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_id;
        public TextView tv_type;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_id = (TextView) itemView.findViewById(R.id.id);
            this.tv_type = (TextView) itemView.findViewById(R.id.type);
        }
    }
}
