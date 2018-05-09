package com.example.myapplication;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;


public class DiaryWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout editor;
    private EditText diary;
    private ImageButton confirm;
    private ImageButton get_source;
    private ImageButton setting;
    private android.support.design.widget.CoordinatorLayout layout;
    private BottomSheetBehavior contentBottomSheetBehavior;
    private BottomSheetBehavior settingBottomSheetBehavior;
    private Button set_theme1;
    private Button set_theme2;
    private Button set_theme3;
    private Button set_theme4;
    private Button set_theme5;
    private Button set_theme6;
    private DiscreteSeekBar set_size;
    private Button set_font1;
    private Button set_font2;
    private Button set_font3;
    private TextView font_text1;
    private TextView font_text2;
    private TextView font_text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_write);

        editor = (TextInputLayout) findViewById(R.id.editLayout);
        diary = (EditText) findViewById(R.id.diaryWrite);
        confirm = (ImageButton) findViewById(R.id.confirm);
        get_source = (ImageButton) findViewById(R.id.source);
        setting = (ImageButton) findViewById(R.id.setting);
        layout = (android.support.design.widget.CoordinatorLayout) findViewById(R.id.diaryWriteLayout);
        contentBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.contentBottomSheetLayout));
        settingBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.settingBottomSheetLayout));
        set_theme1 = (Button) findViewById(R.id.theme1);
        set_theme2 = (Button) findViewById(R.id.theme2);
        set_theme3 = (Button) findViewById(R.id.theme3);
        set_theme4 = (Button) findViewById(R.id.theme4);
        set_theme5 = (Button) findViewById(R.id.theme5);
        set_theme6 = (Button) findViewById(R.id.theme6);
        set_size = (DiscreteSeekBar) findViewById(R.id.set_size);
        set_font1 = (Button) findViewById(R.id.font1);
        set_font2 = (Button) findViewById(R.id.font2);
        set_font3 = (Button) findViewById(R.id.font3);
        font_text1 = (TextView) findViewById(R.id.font_text1);
        font_text2 = (TextView) findViewById(R.id.font_text2);
        font_text3 = (TextView) findViewById(R.id.font_text3);

        init();

        confirm.setOnClickListener(this);
        get_source.setOnClickListener(this);
        setting.setOnClickListener(this);

        set_size.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                diary.setTextSize(6*set_size.getProgress());
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        set_font1.setOnClickListener(this);
        set_font2.setOnClickListener(this);
        set_font3.setOnClickListener(this);

        set_theme1.setOnClickListener(this);
        set_theme2.setOnClickListener(this);
        set_theme3.setOnClickListener(this);
        set_theme4.setOnClickListener(this);
        set_theme5.setOnClickListener(this);
        set_theme6.setOnClickListener(this);

    }

    public void init()
    {
        AssetManager mgr=getAssets();
        Typeface tf1=Typeface.createFromAsset(mgr, "fonts/font1.ttf");
        font_text1.setTypeface(tf1);
        Typeface tf2=Typeface.createFromAsset(mgr, "fonts/font2.ttf");
        font_text2.setTypeface(tf2);
        Typeface tf3=Typeface.createFromAsset(mgr, "fonts/font3.otf");
        font_text3.setTypeface(tf3);
        diary.setTypeface(tf1);
        diary.setTextSize(30);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.confirm:
                Toast.makeText(DiaryWriteActivity.this,diary.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.source:
                Toast.makeText(DiaryWriteActivity.this,"Get Source",Toast.LENGTH_SHORT).show();
                contentBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.setting:
                //confirm.setClickable(false);
                //get_source.setClickable(false);
                //setting.setClickable(false);
                settingBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            //case R.id.set_size:
                //diary.setTextSize(set_size.getProgress());
                //break;
            case R.id.font1:
                AssetManager mgr1=getAssets();
                Typeface tf1=Typeface.createFromAsset(mgr1, "fonts/font1.ttf");
                diary.setTypeface(tf1);
                break;
            case R.id.font2:
                AssetManager mgr2=getAssets();
                Typeface tf2=Typeface.createFromAsset(mgr2, "fonts/font2.ttf");
                diary.setTypeface(tf2);
                break;
            case R.id.font3:
                AssetManager mgr3=getAssets();
                Typeface tf3=Typeface.createFromAsset(mgr3, "fonts/font3.otf");
                diary.setTypeface(tf3);
                break;
            case R.id.theme1:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.moccasin));
                confirm.setBackgroundColor(getResources().getColor(R.color.moccasin));
                get_source.setBackgroundColor(getResources().getColor(R.color.moccasin));
                setting.setBackgroundColor(getResources().getColor(R.color.moccasin));
                break;
            case R.id.theme2:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.dark_turquoise));
                confirm.setBackgroundColor(getResources().getColor(R.color.dark_turquoise));
                get_source.setBackgroundColor(getResources().getColor(R.color.dark_turquoise));
                setting.setBackgroundColor(getResources().getColor(R.color.dark_turquoise));
                break;
            case R.id.theme3:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.ivory));
                confirm.setBackgroundColor(getResources().getColor(R.color.ivory));
                get_source.setBackgroundColor(getResources().getColor(R.color.ivory));
                setting.setBackgroundColor(getResources().getColor(R.color.ivory));
                break;
            case R.id.theme4:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.dark_gray));
                confirm.setBackgroundColor(getResources().getColor(R.color.dark_gray));
                get_source.setBackgroundColor(getResources().getColor(R.color.dark_gray));
                setting.setBackgroundColor(getResources().getColor(R.color.dark_gray));
                break;
            case R.id.theme5:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.burly_wood));
                confirm.setBackgroundColor(getResources().getColor(R.color.burly_wood));
                get_source.setBackgroundColor(getResources().getColor(R.color.burly_wood));
                setting.setBackgroundColor(getResources().getColor(R.color.burly_wood));
                break;
            case R.id.theme6:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                confirm.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                get_source.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                setting.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                break;
        }
    }
}
