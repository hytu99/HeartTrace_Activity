package com.example.activitytest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.app.PendingIntent.getActivity;

public class CalendarActivity extends AppCompatActivity {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    private View view;
    MaterialCalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendar=(MaterialCalendarView) findViewById(R.id.calendar);
        initdata();
    }

    private void initdata()
    {
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

}

