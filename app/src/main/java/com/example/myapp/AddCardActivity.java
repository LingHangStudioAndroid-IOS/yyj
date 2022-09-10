package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.bean.DateBean;

import org.litepal.LitePal;

import java.util.Calendar;

public class AddCardActivity extends AppCompatActivity {
    private EditText cardTitle;
    private EditText cardContent;
    private Button cardFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        cardTitle = (EditText) findViewById(R.id.card_title_add);
        cardContent  = (EditText) findViewById(R.id.card_content_add);
        cardFinish = (Button) findViewById(R.id.card_finish_add);

        LitePal.initialize(this);
        LitePal.getDatabase();

        cardFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DateBean dateBean = new DateBean();
                dateBean.setYear(calendar.get(Calendar.YEAR));
                dateBean.setMonth(calendar.get(Calendar.MONTH) + 1);
                dateBean.setDay(calendar.get(Calendar.DAY_OF_MONTH));
                dateBean.save();

                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}