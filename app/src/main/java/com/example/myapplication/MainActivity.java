package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calendar = (Button) findViewById(R.id.calendar);
        Button diary_edit= (Button) findViewById(R.id.diary_edit);
        Button bottle_edit= (Button) findViewById(R.id.bottle_edit);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_calendar = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent_calendar);
            }
        });
        diary_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_diary_w = new Intent(MainActivity.this, DiaryWriteActivity.class);
                startActivity(intent_diary_w);
            }
        });
        bottle_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_bottle_w = new Intent(MainActivity.this, BottleWriteActivity.class);
                startActivity(intent_bottle_w);
            }
        });
    }
}