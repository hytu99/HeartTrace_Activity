package com.example.activitytest;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitytest.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;


public class DiaryWriteActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int TAKE_PHOTO = 1;

    public static final int CHOOSE_PHOTO = 2;

    private ImageView picture;

    private Uri imageUri;

    private LinearLayout settingBottomSheetLayout;
    private TextInputLayout editor;
    private EditText diary;
    private ImageButton confirm;
    private ImageButton get_source;
    private ImageButton setting;
    private android.support.design.widget.CoordinatorLayout layout;
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
    private Button drop_down;
    private TextView font_text1;
    private TextView font_text2;
    private TextView font_text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_write);

        getView();
        setOnListener();
        init();

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

    }

    public void getView()
    {
        editor = (TextInputLayout) findViewById(R.id.editLayout);
        diary = (EditText) findViewById(R.id.diaryWrite);
        confirm = (ImageButton) findViewById(R.id.confirm);
        get_source = (ImageButton) findViewById(R.id.source);
        setting = (ImageButton) findViewById(R.id.setting);
        layout = (android.support.design.widget.CoordinatorLayout) findViewById(R.id.diaryWriteLayout);
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
        drop_down = (Button) findViewById(R.id.drop_down);
        font_text1 = (TextView) findViewById(R.id.font_text1);
        font_text2 = (TextView) findViewById(R.id.font_text2);
        font_text3 = (TextView) findViewById(R.id.font_text3);
        settingBottomSheetLayout = (LinearLayout) findViewById(R.id.settingBottomSheetLayout);
    }

    public void setOnListener()
    {
        confirm.setOnClickListener(this);
        get_source.setOnClickListener(this);
        setting.setOnClickListener(this);
        set_font1.setOnClickListener(this);
        set_font2.setOnClickListener(this);
        set_font3.setOnClickListener(this);
        drop_down.setOnClickListener(this);
        set_theme1.setOnClickListener(this);
        set_theme2.setOnClickListener(this);
        set_theme3.setOnClickListener(this);
        set_theme4.setOnClickListener(this);
        set_theme5.setOnClickListener(this);
        set_theme6.setOnClickListener(this);
        editor.setOnClickListener(this);

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
        switch (view.getId()) {
            case R.id.confirm:
                Toast.makeText(DiaryWriteActivity.this, diary.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.source:
                if (ContextCompat.checkSelfPermission(DiaryWriteActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DiaryWriteActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    openAlbum();
                }
                break;
            case R.id.setting:
                settingBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.drop_down:
                settingBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.font1:
                AssetManager mgr1 = getAssets();
                Typeface tf1 = Typeface.createFromAsset(mgr1, "fonts/font1.ttf");
                diary.setTypeface(tf1);
                break;
            case R.id.font2:
                AssetManager mgr2 = getAssets();
                Typeface tf2 = Typeface.createFromAsset(mgr2, "fonts/font2.ttf");
                diary.setTypeface(tf2);
                break;
            case R.id.font3:
                AssetManager mgr3 = getAssets();
                Typeface tf3 = Typeface.createFromAsset(mgr3, "fonts/font3.otf");
                diary.setTypeface(tf3);
                break;
            case R.id.theme1:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.mediumpurple));
                confirm.setBackgroundColor(getResources().getColor(R.color.mediumpurple));
                get_source.setBackgroundColor(getResources().getColor(R.color.mediumpurple));
                setting.setBackgroundColor(getResources().getColor(R.color.mediumpurple));
                break;
            case R.id.theme2:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.lime));
                confirm.setBackgroundColor(getResources().getColor(R.color.lime));
                get_source.setBackgroundColor(getResources().getColor(R.color.lime));
                setting.setBackgroundColor(getResources().getColor(R.color.lime));
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
                layout.setBackgroundColor(getResources().getColor(R.color.goldenrod));
                confirm.setBackgroundColor(getResources().getColor(R.color.goldenrod));
                get_source.setBackgroundColor(getResources().getColor(R.color.goldenrod));
                setting.setBackgroundColor(getResources().getColor(R.color.goldenrod));
                break;
            case R.id.theme5:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.lightsalmon));
                confirm.setBackgroundColor(getResources().getColor(R.color.lightsalmon));
                get_source.setBackgroundColor(getResources().getColor(R.color.lightsalmon));
                setting.setBackgroundColor(getResources().getColor(R.color.lightsalmon));
                break;
            case R.id.theme6:
                //diary.setTextColor(getResources().getColor(R.color.colorBase));
                layout.setBackgroundColor(getResources().getColor(R.color.colorBase));
                confirm.setBackgroundColor(getResources().getColor(R.color.colorBase));
                get_source.setBackgroundColor(getResources().getColor(R.color.colorBase));
                setting.setBackgroundColor(getResources().getColor(R.color.colorBase));
                break;
        }
    }

        private void openAlbum(){
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            startActivityForResult(intent, CHOOSE_PHOTO); // 打开相册
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, String[]permissions, int[] grantResults) {
            switch (requestCode) {
                case 1:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        openAlbum();
                    } else {
                        Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    // 判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        // 4.4及以上系统使用这个方法处理图片
                        handleImageOnKitKat(data);
                    } else {
                        // 4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        Log.d("TAG", "handleImageOnKitKat: uri is " + uri);
        if (DocumentsContract.isDocumentUri(this, uri)) {
            // 如果是document类型的Uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1]; // 解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // 如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // 如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath); // 根据图片路径显示图片
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        // 通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            picture.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }


}

