package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int intValue=7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        String str = String.valueOf(intValue);
        button.setText("Rating 1-"+str);

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplaySliderActivity.class);
        intent.putExtra("intVariableName", intValue);
        startActivity(intent);
    }
}
