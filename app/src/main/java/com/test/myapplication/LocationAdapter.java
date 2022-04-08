package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.model.Batters;
import com.test.myapplication.model.UserModel;

import java.util.ArrayList;

public class LocationAdapter  extends RecyclerView.Adapter<LocationAdapter.ViewHolder>{

    ArrayList<UserModel> listdata;
    public LocationAdapter(ArrayList<UserModel> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_row_batters, parent, false);
        LocationAdapter.ViewHolder viewHolder = new LocationAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        holder.tv_id.setText(listdata.get(position).getLat());
        holder.tv_type.setText(listdata.get(position).getLongi());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
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

