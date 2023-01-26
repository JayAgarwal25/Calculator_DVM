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
    private ArrayList results_id,workings_id;

    public MyAdapter(Context context, ArrayList results_id, ArrayList workings_id) {
        this.context = context;
        this.results_id = results_id;
        this.workings_id = workings_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.results_id.setText(String.valueOf(results_id.get(position)));
        holder.workings_id.setText(String.valueOf(workings_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return results_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView results_id,workings_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            results_id=itemView.findViewById(R.id.results);
            workings_id=itemView.findViewById(R.id.workings);
        }
    }
}