/*
package com.example.sample;
import java.io.File;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.Calendar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisplayHistoryActivity extends AppCompatActivity {

    ListView list;
    //int[] array = new int[]{};
    List<String> integerData = new ArrayList<String>();

    //integerData.add(1);

    //integerData.add(2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);
        loadData();
        Intent intent1 = getIntent();


        int intValue = intent1.getIntExtra("feedbacksubmitted", 0);

        //if(intValue!=0) integerData.add(intValue);

        Date currentTime = Calendar.getInstance().getTime();
        //format(date)

        Date todaysDate = new Date();

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String str = df.format(todaysDate);
        String str1 =String.valueOf(intValue);

        if(intValue!=0) integerData.add(str1+"                  "+str);

        saveData();
        //File file = new File(context.getFilesDir(), filename);
        //File.createTempFile(filename, null, this.getCacheDir());

        //String filename="temp.txt";
        //File.createTempFile(filename, null, this.getCacheDir());

        //File cacheFile = new File(this.getCacheDir(), filename);


        list = findViewById(R.id.list);
            ArrayList<String> arrayList = new ArrayList<String>();
            for(String s:integerData) {
                arrayList.add(s);
            }

            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, arrayList);
            list.setAdapter(adapter);

    }
    private void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(integerData);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences=getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        integerData =gson.fromJson(json,type);

        if(integerData==NULL){
            integerData=new ArrayList<>();
        }
        return integerData;

    }

    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(DisplayHistoryActivity);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(DisplayHistoryActivity);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }




}

*/


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

