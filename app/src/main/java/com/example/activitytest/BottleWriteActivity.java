package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarMode;

import java.util.Date;

public class BottleWriteActivity extends AppCompatActivity {
    private ImageButton confirm;
    private ImageButton source;
    private ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_write);
        confirm = (ImageButton) findViewById(R.id.confirm);
        source = (ImageButton) findViewById(R.id.source);
        setting = (ImageButton) findViewById(R.id.setting);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            //在当前onClick方法中监听点击Button的动作
            public void onClick(View v) {

            }
        });

        source.setOnClickListener(new View.OnClickListener() {
            @Override
            //在当前onClick方法中监听点击Button的动作
            public void onClick(View v) {

            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            //在当前onClick方法中监听点击Button的动作
            public void onClick(View v) {

            }
        });

    }

}
