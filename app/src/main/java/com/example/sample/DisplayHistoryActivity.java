package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class DisplayHistoryActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        Intent intent1 = getIntent();

        //Intent intent = getIntent();
        Bundle args = intent1.getBundleExtra("BUNDLE");
        ArrayList<String> object = (ArrayList<String>) args.getSerializable("ARRAYLIST");


        list = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<String>();
        for(String s:object) {
            arrayList.add(s);
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);


    }


}

