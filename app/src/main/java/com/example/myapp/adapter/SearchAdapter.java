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
import com.example.myapp.bean.SearchHistory;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter<SetOn> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<SearchHistory> myNotes = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public SearchAdapter(List<SearchHistory> myNotes){
        this.myNotes = myNotes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item,parent,false);
        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NoteViewHolder noteViewHolder = (NoteViewHolder) holder;
        final SearchHistory myNote = myNotes.get(position);
        noteViewHolder.content.setText(myNote.getContent());
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
        private TextView content;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            content = (TextView) view.findViewById(R.id.history_content);
        }
    }

    public interface OnItemClickListener{
        void click(View v,int position);
    }

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}

