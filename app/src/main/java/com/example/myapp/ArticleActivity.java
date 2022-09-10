package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.adapter.DiscussAdapter;
import com.example.myapp.bean.DiscussBean;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {
    private Button backBt;
    private ImageView authorHead;
    private TextView authorName;
    private TextView tag;
    private TextView sentTimeT;
    private TextView inputContentT;
    private EditText editText;
    private Button discussSent;
    private TextView discussNumTextview;
    private ImageView dz;
    private TextView dzNumTextview;
    private RecyclerView discussRecycle;

    String authorNameString = "xawm";
    String tagString = "#考研#";
    String sentTime = "发布时间:2020-12-12 12:12:12";
    String inPutContent;
    int discussNum;
    int dzNum;
    int scNum;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        discussNum = bundle.getInt("discussNum");
        dzNum = bundle.getInt("dzNum");
        scNum = bundle.getInt("scNum");
        authorNameString = bundle.getString("authorName");
        tagString = bundle.getString("tag");
        sentTime = bundle.getString("date");
        inPutContent = bundle.getString("content");

        List<DiscussBean> discussBeanList = new ArrayList<>();
        DiscussBean discussBean1 = new DiscussBean(123,"xawm","wdnmd");
        for(int i = 0;i < 10;i ++ ){
            discussBeanList.add(discussBean1);
        }

        backBt = (Button) findViewById(R.id.back_detail);
        authorHead = (ImageView) findViewById(R.id.author_head);
        authorName = (TextView) findViewById(R.id.autor_id);
        tag = (TextView) findViewById(R.id.author_tag);
        sentTimeT = (TextView) findViewById(R.id.sent_time);
        inputContentT = (TextView) findViewById(R.id.detail_content);
        editText = (EditText) findViewById(R.id.discuss);
        discussSent = (Button) findViewById(R.id.discuss_sent);
        discussNumTextview = (TextView) findViewById(R.id.discuss_num);
        dz = (ImageView) findViewById(R.id.dz_bt);
        dzNumTextview = (TextView) findViewById(R.id.dz_num);
        dzNumTextview.setText(new StringBuilder().append(dzNum).toString());

        discussRecycle = (RecyclerView) findViewById(R.id.discuss_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        discussRecycle.setLayoutManager(layoutManager);
        DiscussAdapter adapter = new DiscussAdapter(discussBeanList);
        discussRecycle.setAdapter(adapter);

        authorName.setText(authorNameString);
        tag.setText(tagString);
        sentTimeT.setText(sentTime);
        inputContentT.setText(inPutContent);
        discussNumTextview.setText(new StringBuilder().append(discussNum).toString());
        dzNumTextview.setText(new StringBuilder().append(dzNum).toString());

        dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dzNum++;
                dzNumTextview.setText(new StringBuilder().append(dzNum).toString());
            }
        });

        discussSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscussBean discussBeanNew = new DiscussBean(123,"xawm",editText.getText().toString());
                discussBeanList.add(discussBeanNew);
                DiscussAdapter adapterNew = new DiscussAdapter(discussBeanList);
                discussRecycle.setAdapter(adapterNew);
                editText.setText("");
                discussNum++;
                discussNumTextview.setText(new StringBuilder().append(discussNum).toString());
            }
        });
    }
}