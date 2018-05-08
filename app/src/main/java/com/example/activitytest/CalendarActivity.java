package com.example.activitytest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    private View view;
    MaterialCalendarView calendar;
    private TextView change_mode;
    private TextView change_to_today;
    boolean month_mode=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        change_mode =(TextView)findViewById(R.id.change_mode);
        change_to_today =(TextView)findViewById(R.id.move_to_today);

        change_mode.setOnClickListener((View.OnClickListener) this);
        change_to_today.setOnClickListener((View.OnClickListener) this);

        calendar=(MaterialCalendarView) findViewById(R.id.calendar);
        initdata();
    }

    private void initdata()
    {
        calendar.setPagingEnabled(true);
        calendar.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
        calendar.setSelectedDate(new Date());
        calendar.setSelectionColor(getResources().getColor(R.color.colorBase));
        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                CalendarDay selected_date = calendar.getSelectedDate();
                Toast.makeText(CalendarActivity.this, FORMATTER.format(selected_date.getDate()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.change_mode:
                if( month_mode == true ) {
                    calendar.state().edit().setCalendarDisplayMode(CalendarMode.WEEKS).commit();
                    change_mode.setText("月模式");
                    month_mode = false;
                }
                else{
                    calendar.state().edit().setCalendarDisplayMode(CalendarMode.MONTHS).commit();
                    change_mode.setText("周模式");
                    month_mode = true;
                }
                break;
            case R.id.move_to_today:
                calendar.setSelectedDate(new Date());
                break;
        }
    }

}

