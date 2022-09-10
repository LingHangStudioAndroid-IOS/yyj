package com.example.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapp.AddCardActivity;
import com.example.myapp.R;
import com.example.myapp.adapter.CalendaAdapter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudyFragment extends Fragment {
    private ViewPager2 viewPager2;
    private CalendarView calendarView;
    private TextView dateTv;
    private ImageView arrowLeftImg,arrowRightImg;
    private Button sentButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        viewPager2 = view.findViewById(R.id.vpContainer);
        CalendaAdapter calendarAdapter = new CalendaAdapter();
        viewPager2.setAdapter(calendarAdapter);
        dateTv = view.findViewById(R.id.date_tv);
        arrowLeftImg = view.findViewById(R.id.arrow_left);
        arrowRightImg = view.findViewById(R.id.arrow_right);
        sentButton = (Button)view.findViewById(R.id.sent_card);
        calendarAdapter.SetOnItemClickListener(new CalendaAdapter.OnItemClickListener() {
            @Override
            public void click(View v, int position) {
                Toast.makeText(view.getContext(), "hhh" , Toast.LENGTH_SHORT).show();
            }
        });

        List<Calendar> data = new ArrayList<>();
        for (int i = 11; i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -i);
            data.add(calendar);
        }

        calendarAdapter.refreshData(data);
        viewPager2.setCurrentItem(11, false);
        dateTv.setText(data.get(data.size() - 1).get(Calendar.YEAR) + "-" + (data.get(data.size() - 1).get(Calendar.MONTH) + 1));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int year = data.get(position).get(Calendar.YEAR);
                int month = data.get(position).get(Calendar.MONTH) + 1;
                dateTv.setText(year + "-" + month);
                RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
                View view = recyclerView.getLayoutManager().findViewByPosition(position);
                if (view != null)
                    updatePagerHeightForChild(view, viewPager2);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }

            public void updatePagerHeightForChild(View view, ViewPager2 pager) {
                view.post(() -> {
                    int weightMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY);
                    int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    view.measure(weightMeasureSpec, heightMeasureSpec);
                    if (pager.getLayoutParams().height != view.getMeasuredHeight()) {
                        ViewGroup.LayoutParams layoutParams = pager.getLayoutParams();
                        layoutParams.height = view.getMeasuredHeight();
                        pager.setLayoutParams(layoutParams);
                    }
                });
            }

        });

        arrowRightImg.setOnClickListener(V -> {
            arrowRightImg.post(() -> {
                if (viewPager2.getCurrentItem() != 11)
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, false);
            });
        });
        arrowLeftImg.setOnClickListener(V -> {
            arrowLeftImg.post(() -> {
                if (viewPager2.getCurrentItem() != 0)
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1, false);
            });
        });

        sentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddCardActivity.class);
                startActivityForResult(intent,100);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:

        }
    }
}
