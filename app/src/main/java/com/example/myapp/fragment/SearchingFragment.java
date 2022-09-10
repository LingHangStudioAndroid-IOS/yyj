package com.example.myapp.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.OnSearchActivity;
import com.example.myapp.R;
import com.example.myapp.adapter.SearchAdapter;
import com.example.myapp.bean.SearchHistory;

import java.util.ArrayList;
import java.util.List;

public class SearchingFragment extends Fragment {
    private EditText searchInput;
    private Button searchOnclick;
    private RecyclerView recyclerViewOne;
    private RecyclerView recyclerViewTwo;
    List<SearchHistory> searchHistoryList = new ArrayList<>();
    List<SearchHistory> searchHistoryListHot = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerViewOne = (RecyclerView) view.findViewById(R.id.history);
        recyclerViewTwo = (RecyclerView) view.findViewById(R.id.hot_top);
        searchInput = (EditText) view.findViewById(R.id.search_input);
        searchOnclick = (Button) view.findViewById(R.id.search_onclick);

        SearchHistory searchHistory1 = new SearchHistory("abcd");
        searchHistoryList.add(searchHistory1);
        SearchHistory searchHistory2 = new SearchHistory("23");
        searchHistoryList.add(searchHistory2);
        SearchHistory searchHistory3 = new SearchHistory("wrgagr");
        searchHistoryList.add(searchHistory3);
        SearchHistory searchHistory4 = new SearchHistory("egergreggggggg");
        searchHistoryList.add(searchHistory4);
        SearchHistory searchHistory5 = new SearchHistory("argWGW");
        searchHistoryList.add(searchHistory5);
        SearchHistory searchHistory6 = new SearchHistory("abSRGRGRcd");
        searchHistoryList.add(searchHistory6);

        SearchHistory searchHistory01 = new SearchHistory("abcd");
        searchHistoryListHot.add(searchHistory01);
        SearchHistory searchHistory02 = new SearchHistory("23");
        searchHistoryListHot.add(searchHistory02);
        SearchHistory searchHistory03 = new SearchHistory("wrgagr");
        searchHistoryListHot.add(searchHistory03);
        SearchHistory searchHistory04 = new SearchHistory("egergreggggggg");
        searchHistoryListHot.add(searchHistory04);
        SearchHistory searchHistory05 = new SearchHistory("argWGW");
        searchHistoryListHot.add(searchHistory05);
        SearchHistory searchHistory06 = new SearchHistory("abSRGRGRcd");
        searchHistoryListHot.add(searchHistory06);

        SearchAdapter adapter = new SearchAdapter(searchHistoryList);
        recyclerViewOne.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(),4);
        recyclerViewOne.setLayoutManager(layoutManager);
        adapter.SetOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void click(View v, int position) {
                Toast.makeText(view.getContext(),"qqq",Toast.LENGTH_SHORT).show();
            }
        });

        SearchAdapter adapterHot = new SearchAdapter(searchHistoryListHot);
        recyclerViewTwo.setAdapter(adapterHot);
        GridLayoutManager layoutManagerTwo = new GridLayoutManager(view.getContext(),4);
        recyclerViewTwo.setLayoutManager(layoutManagerTwo);
        adapterHot.SetOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void click(View v, int position) {
                Toast.makeText(view.getContext(),"www",Toast.LENGTH_SHORT).show();
            }
        });

        searchOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search_line = searchInput.getText().toString();

                Intent intent = new Intent(view.getContext(), OnSearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("input",searchInput.getText().toString());
                intent.putExtras(bundle);
                searchInput.setText("");
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
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    SearchHistory searchHistoryNew = new SearchHistory(bundle.getString("input"));
                    searchHistoryList.add(0,searchHistoryNew);
                    SearchAdapter adapter = new SearchAdapter(searchHistoryList);
                    recyclerViewOne.setAdapter(adapter);
                }
        }
    }
}
