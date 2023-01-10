package com.project.calculatordvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList resultsTV_id,workingsTV_id;

    public MyAdapter(Context context, ArrayList resultsTV_id, ArrayList workingsTV_id) {
        this.context = context;
        this.resultsTV_id = resultsTV_id;
        this.workingsTV_id = workingsTV_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.resultsTV_id.setText(String.valueOf(resultsTV_id.get(position)));
        holder.workingsTV_id.setText(String.valueOf(workingsTV_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return resultsTV_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView resultsTV_id,workingsTV_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resultsTV_id=itemView.findViewById(R.id.results);
            workingsTV_id=itemView.findViewById(R.id.workings);
        }
    }
}