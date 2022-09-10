package com.example.myapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.bean.DateBean;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.List;

public class CalendarDateAdapter extends BaseAdapter {
    private Context context;
    private List<DateBean> mData;


    public CalendarDateAdapter(Context context, List<DateBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.dateTv = view.findViewById(R.id.date_tv);
            viewHolder.heartState = view.findViewById(R.id.heart_state);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DateBean data = mData.get(i);
        if (data.getDay() != 0) {
            viewHolder.dateTv.setText("" + data.getDay());
        } else {
            viewHolder.dateTv.setText("");
            viewHolder.heartState.setVisibility(View.GONE);
        }

        //选中日期 表示为签到
        Calendar calendar = Calendar.getInstance();
        List<DateBean> dateBeanList = LitePal.findAll(DateBean.class);
        for (int index = 0;index < dateBeanList.size();index ++){
            if (data.getYear() == dateBeanList.get(index).getYear() && data.getMonth() == dateBeanList.get(index).getMonth() && data.getDay() == dateBeanList.get(index).getDay()) {
                viewHolder.dateTv.setText("已签到");
                viewHolder.heartState.setImageBitmap(BitmapFactory.decodeResource(view.getResources(),R.drawable.card_no));
            }
        }
//        if (data.getYear() == calendar.get(Calendar.YEAR) && data.getMonth() == (calendar.get(Calendar.MONTH) + 1) && data.getDay() == calendar.get(Calendar.DAY_OF_MONTH)) {
//            viewHolder.dateTv.setText("今天");
//        }

        return view;

    }

    static class ViewHolder {
        public TextView dateTv;
        public ImageView heartState;
    }
}
