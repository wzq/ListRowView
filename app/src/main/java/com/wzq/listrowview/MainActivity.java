package com.wzq.listrowview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BasePresenter{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListRowView listView = findViewById(R.id.list);

        listView.setHasFixedSize(true);
        listView.setNumColumns(1);
        listView.setPresenter(this);
    }


    @Override
    public List<String> createRow() {
        List<String> s= new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            s.add("item"+i);
        }
        return s;
    }
}
