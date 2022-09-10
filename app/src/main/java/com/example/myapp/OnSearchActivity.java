package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.adapter.NoteRecycleViewAdapter;
import com.example.myapp.bean.MyNote;

import java.util.ArrayList;
import java.util.List;

public class OnSearchActivity extends AppCompatActivity {
    private List<MyNote> noteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_search);

        recyclerView = (RecyclerView) findViewById(R.id.note_recycle);
        backButton = (Button) findViewById(R.id.on_search_back);
        MyNote myNote1 = new MyNote("#高数#","高数太难了...","2020-03-04 12:12:12","热度243","xawm",0,12,23);
        MyNote myNote2 = new MyNote("#考研#","考研复习...","2020-03-23 12:12:12","热度245","dongx",0,32,230);
        MyNote myNote3 = new MyNote("#学习比记#","所谓的q...","2020-10-04 12:12:12","热度373","alex",0,120,11);
        List<MyNote> myNoteList = new ArrayList<>();
        myNoteList.add(myNote1);
        myNoteList.add(myNote2);
        myNoteList.add(myNote3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NoteRecycleViewAdapter adapter = new NoteRecycleViewAdapter(myNoteList);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new NoteRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void click(View v, int position) {
                Intent intent = new Intent(OnSearchActivity.this, ArticleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("tag",myNoteList.get(position).getTag());
                bundle.putString("content",myNoteList.get(position).getContent());
                bundle.putString("date",myNoteList.get(position).getDate());
                bundle.putString("hot",myNoteList.get(position).getHot());
                bundle.putString("authorName",myNoteList.get(position).getAuthorName());

                bundle.putInt("didscussNum",myNoteList.get(position).getDiscussNum());
                bundle.putInt("dzNum",myNoteList.get(position).getDzNum());
                bundle.putInt("scNum",myNoteList.get(position).getScNum());
                intent.putExtras(bundle);
                startActivityForResult(intent,100);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putString("input","wwwwww");
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}