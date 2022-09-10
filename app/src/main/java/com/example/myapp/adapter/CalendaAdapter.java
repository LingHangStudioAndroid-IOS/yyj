package com.example.myapp.adapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendaAdapter extends RecyclerView.Adapter<com.example.myapp.adapter.CalendarView> {
    private List<Calendar> calendar = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public CalendaAdapter() {

    }

    @NonNull
    @Override
    public com.example.myapp.adapter.CalendarView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.example.myapp.adapter.CalendarView(LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.myapp.adapter.CalendarView holder, @SuppressLint("RecyclerView") int position) {

        if (calendar.size() != 0)
            holder.initData(calendar.get(position));
    }

    @Override
    public int getItemCount() {
        return calendar.size();
    }

    public void refreshData(List<Calendar> data) {
        for (int i = 0; i < data.size(); i++) {
            calendar.add(data.get(i));
        }
        notifyDataSetChanged();

    }

    public class NoteViewHolder extends com.example.myapp.adapter.CalendarView{
        private View view;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }

    public interface OnItemClickListener{
        void click(View v,int position);
    }

    public void SetOnItemClickListener(CalendaAdapter.OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}

