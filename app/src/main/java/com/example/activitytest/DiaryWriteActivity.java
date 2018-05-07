package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarMode;

import java.util.Date;

public class DiaryWriteActivity extends AppCompatActivity {
    private ImageButton confirm;
    private ImageButton get_source;
    private ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_write);
        confirm = (ImageButton) findViewById(R.id.confirm);
        get_source = (ImageButton) findViewById(R.id.source);
        setting = (ImageButton) findViewById(R.id.setting);

        confirm.setOnClickListener((View.OnClickListener) this);
        get_source.setOnClickListener((View.OnClickListener) this);
        setting.setOnClickListener((View.OnClickListener) this);
    }

        public void onClick (View view) {
            switch(view.getId()) {
                case R.id.confirm:
                    break;
                case R.id.source:
                    break;
                case R.id.setting:
                    break;
            }
    }
}
