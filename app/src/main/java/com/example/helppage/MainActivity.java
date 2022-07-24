package com.example.helppage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helppage.Help;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;

    List<Help> helpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        HelpAdapter helpAdapter = new HelpAdapter(helpList);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(helpAdapter);
    }

    private void initData() {
        helpList = new ArrayList<>();
        helpList.add(new Help("1. Activities to Do Instead of Smoking", "2008", "Blah Blah"));
        helpList.add(new Help("2. Methods of Quitting", "2008", "Blah Blah"));
        helpList.add(new Help("3. Signs of Addiction to Smoking", "2010", "Blah Blah"));
        helpList.add(new Help("4. Tip for a Successful Tolerance Break", "2011", "Blah Blah"));
        helpList.add(new Help("5. What is CBD", "2011", "Blah Blah"));
        helpList.add(new Help("6. What is a Tolerance Break", "2012", "Blah Blah"));
        helpList.add(new Help("7. Tolerance Break Guide","2013","Blah Blah"));
        helpList.add(new Help("8. THC Calculator","2013","Blah Blah"));
        helpList.add(new Help("9. Communities","2014","Blah Blah"));
        helpList.add(new Help("10. What is CHS","2015","Blah Blah"));
    }

}