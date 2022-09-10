package com.example.myapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.bean.DiscussBean;

import java.util.ArrayList;
import java.util.List;

public class DiscussAdapter<SetOn> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DiscussBean> myNotes = new ArrayList<>();

    public DiscussAdapter(List<DiscussBean> myNotes){
        this.myNotes = myNotes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discuss_item,parent,false);
        return new DiscussVIewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DiscussVIewHolder noteViewHolder = (DiscussVIewHolder) holder;
        DiscussBean discussBean = myNotes.get(position);
        noteViewHolder.content.setText(discussBean.getContent());
        noteViewHolder.writerID.setText(discussBean.getWriterID());
    }


    @Override
    public int getItemCount() {
        return myNotes.size();
    }

    public class DiscussVIewHolder extends RecyclerView.ViewHolder{
        private View view;
        private TextView content;
        private TextView writerID;
        public DiscussVIewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            content = (TextView) view.findViewById(R.id.discuss_content);
            writerID = (TextView) view.findViewById(R.id.discuss_writer);
        }
    }

}

