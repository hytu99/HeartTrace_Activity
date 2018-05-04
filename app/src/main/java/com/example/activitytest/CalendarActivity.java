package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private int        year;
    private int        month;//月份是从0开始算的.
    private int        day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);去掉标题栏
        datePicker = (DatePicker) findViewById(R.id.datepicker);

        initData();
    }
    public void initData(){
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(CalendarActivity.this, year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void cancel(View v){
        Toast.makeText(this, "取消,按照工单给的补抄日期", Toast.LENGTH_SHORT).show();
    }
    public void confirm(View v){
        Toast.makeText(this, "确认", Toast.LENGTH_SHORT).show();
    }
}

