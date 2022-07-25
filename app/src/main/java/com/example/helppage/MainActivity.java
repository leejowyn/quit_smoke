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
        helpList.add(new Help("1. Activities to Do Instead of Smoking", "2008", " Distract yourself and the urge to smoke will pass"));
        helpList.add(new Help("2. Methods of Quitting", "2008", "Try nicotine replacement therapy. Ask your health care provider about nicotine replacement therapy."));
        helpList.add(new Help("3. Signs of Addiction to Smoking", "2010", "You can't stop smoking. You've made one or more serious, but unsuccessful, attempts to stop."));
        helpList.add(new Help("4. Tip for a Successful Tolerance Break", "2011", "Acknowledge the Difficulty of the Task at Hand."));
        helpList.add(new Help("5. What is CBD", "2011", "Cannabidiol is a phytocannabinoid discovered in 1940. It is one of 113 identified cannabinoids in cannabis plants, along with tetrahydrocannabinol, and accounts for up to 40% of the plant's extract."));
        helpList.add(new Help("6. What is a Tolerance Break", "2012", "Tolerance breaks are when you give your body a break from cannabis in order to reset your cannabinoid receptors"));
        helpList.add(new Help("7. Tolerance Break Guide","2013","Tolerance Break Guide"));
        helpList.add(new Help("8. THC Calculator","2013","Calculate how long THC will detectible in your urine in order to pass a drug test."));
        helpList.add(new Help("9. Communities","2014","A group of people living in the same place or having a particular characteristic in common."));
        helpList.add(new Help("10. What is CHS","2015","Cannabis hyperemesis syndrome (CHS) is a condition caused by long-term cannabis (marijuana) use."));
    }

}