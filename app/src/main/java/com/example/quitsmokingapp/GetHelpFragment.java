package com.example.quitsmokingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GetHelpFragment extends Fragment {

    RecyclerView recycleView;
    List<Help> helpList;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_help, container, false);

        recycleView = view.findViewById(R.id.recyclerView);
        initData();
        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        HelpAdapter helpAdapter = new HelpAdapter(helpList);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
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