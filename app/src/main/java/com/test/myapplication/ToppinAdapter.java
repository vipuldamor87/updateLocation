package com.test.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.model.Batters;
import com.test.myapplication.model.Topping;

import java.util.List;


public class ToppinAdapter  extends RecyclerView.Adapter<ToppinAdapter.ViewHolder> {

    List<Topping> listdata;

    public ToppinAdapter(List<Topping> topping) {
        listdata = topping;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_row_toppins, parent, false);
        ToppinAdapter.ViewHolder viewHolder = new ToppinAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText(listdata.get(position).getId());
        holder.tv_type.setText(listdata.get(position).getType());

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
