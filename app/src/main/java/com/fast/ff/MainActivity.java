package com.fast.ff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fast.ff.view.CustomBarbar;

public class MainActivity extends AppCompatActivity {

    private CustomBarbar barbar1, barbar2, barbar3, barbar4, barbar5, barbar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindData();
    }

    private void bindData() {
        barbar1.addMiddleViewExist(barbar1.getTextView("标题1"));


        barbar2.addMiddleViewExist(barbar2.getTextView("标题2"));
        barbar2.addLeftView(barbar2.getImageView(R.mipmap.back));

        barbar3.addMiddleViewExist(barbar3.getTextView("标题3"));
        barbar3.addLeftView(barbar3.getImageView(R.mipmap.back));
        barbar3.addLeftView(barbar3.getImageView(R.mipmap.back));


        barbar4.addLeftView(barbar4.getImageView(R.mipmap.back));
        barbar4.addMiddleViewExist(barbar4.getTextView("标题4"));
        barbar4.addRightView(barbar4.getTextView("右1"));
        barbar4.addRightView(barbar4.getTextView("右2"));

        barbar5.addMiddleViewExist(barbar5.getTextView("标题5"));
        barbar5.addLeftView(barbar5.getTextView("左1"));
        barbar5.addLeftView(barbar5.getTextView("左2"));
        barbar5.addRightView(barbar5.getImageView(R.mipmap.add));
        barbar5.addRightView(barbar5.getTextView("右2"));
        barbar5.addRightView(barbar5.getTextView("右3"));


        barbar6.addMiddleViewExist(barbar6.getTextView("标题6"));
        barbar6.addLeftView(barbar6.getTextView("左1"));
        barbar6.addLeftView(barbar6.getTextView("左2"));
        barbar6.addLeftView(barbar6.getTextView("左3"));
        barbar6.addRightView(barbar6.getImageView(R.mipmap.add));
        barbar6.addRightView(barbar6.getTextView("右2"));
        barbar6.addRightView(barbar6.getTextView("右3"));
        barbar6.addRightView(barbar6.getTextView("右4"));
    }

    private void init() {
        barbar1 = findViewById(R.id.custom1);
        barbar2 = findViewById(R.id.custom2);
        barbar3 = findViewById(R.id.custom3);
        barbar4 = findViewById(R.id.custom4);
        barbar5 = findViewById(R.id.custom5);
        barbar6 = findViewById(R.id.custom6);
    }
}