package com.example.myapp.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapp.ArticleActivity;
import com.example.myapp.R;
import com.example.myapp.adapter.NoteRecycleViewAdapter;
import com.example.myapp.bean.MyNote;

import java.util.ArrayList;
import java.util.List;

public class GiveFragment extends Fragment {
    private List<MyNote> noteList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_head_page, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.note_recycle);
        MyNote myNote1 = new MyNote("#高数#","高数太难了...","2020-03-04 12:12:12","热度243","xawm",0,12,23);
        MyNote myNote2 = new MyNote("#考研#","考研复习...","2020-03-23 12:12:12","热度245","dongx",0,32,230);
        MyNote myNote3 = new MyNote("#学习比记#","所谓的q...","2020-10-04 12:12:12","热度373","alex",0,120,11);
        List<MyNote> myNoteList = new ArrayList<>();
        myNoteList.add(myNote1);
        myNoteList.add(myNote2);
        myNoteList.add(myNote3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        NoteRecycleViewAdapter adapter = new NoteRecycleViewAdapter(myNoteList);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new NoteRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void click(View v, int position) {
                Intent intent = new Intent(view.getContext(), ArticleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("tag",myNoteList.get(position).getTag());
                bundle.putString("content",myNoteList.get(position).getContent());
                bundle.putString("date",myNoteList.get(position).getDate());
                bundle.putString("hot",myNoteList.get(position).getHot());
                bundle.putString("authorName",myNoteList.get(position).getAuthorName());
                bundle.putInt("discussNum",myNoteList.get(position).getDiscussNum());
                bundle.putInt("dzNum",myNoteList.get(position).getDzNum());
                bundle.putInt("scNum",myNoteList.get(position).getScNum());
                intent.putExtras(bundle);
                startActivityForResult(intent,100);
            }
        });

        return view;
    }
}
