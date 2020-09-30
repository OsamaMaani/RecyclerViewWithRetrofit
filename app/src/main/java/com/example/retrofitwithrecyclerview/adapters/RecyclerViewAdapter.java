package com.example.retrofitwithrecyclerview.adapters;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.retrofitwithrecyclerview.R;
import com.example.retrofitwithrecyclerview.models.Post;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private  List<Post> list;
    public RecyclerViewAdapter(List<Post> list){
        this.list = list;
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RecyclerViewAdapter ", "onCreateViewHolder: start");
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,
                        parent,  false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("RecyclerViewAdapter ", "onBindViewHolder: start");
        holder.tvID.setText(String.valueOf(list.get(position).getId()));
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvBody.setText(list.get(position).getBody());
        Log.d("RecyclerViewAdapter ", "onBindViewHolder: start");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvID;
        TextView tvTitle;
        TextView tvBody;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvTitle= itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            Log.d("RecyclerViewAdapter ", "HOlder Constructor: start");
        }
    }
}
