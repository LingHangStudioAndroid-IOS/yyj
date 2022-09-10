package com.example.myapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.bean.MyNote;

import java.util.ArrayList;
import java.util.List;

public class NoteRecycleViewAdapter<SetOn> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyNote> myNotes = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public NoteRecycleViewAdapter(List<MyNote> myNotes){
        this.myNotes = myNotes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_page_item,parent,false);
        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NoteViewHolder noteViewHolder = (NoteViewHolder) holder;
        final MyNote myNote = myNotes.get(position);
        noteViewHolder.tag.setText(myNote.getTag());
        noteViewHolder.content.setText(myNote.getContent());
        noteViewHolder.date.setText(myNote.getDate());
        noteViewHolder.hot.setText(myNote.getHot());
        noteViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.click(view,position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return myNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private TextView tag;
        private TextView content;
        private TextView date;
        private TextView hot;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tag = (TextView) view.findViewById(R.id.tag);
            content = (TextView) view.findViewById(R.id.content);
            date = (TextView) view.findViewById(R.id.date);
            hot = (TextView) view.findViewById(R.id.hot);
        }
    }

    public interface OnItemClickListener{
        void click(View v,int position);
    }

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}

