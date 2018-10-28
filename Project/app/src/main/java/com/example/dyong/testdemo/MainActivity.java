package com.example.dyong.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.flexboxLayout)
    FlexboxLayout flexboxLayout;

    String[] tabs = new String[]{
            "今日头条", "美团", "阿里巴巴", "京东", "腾讯科技有限公司",
            "蘑菇街", "名创优品", "b百佳华", "千百度", "小李飞刀",
            "今日打老虎", "玉面郎君"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        flexboxLayout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
        flexboxLayout.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP);
//        for (int i = 0; i < 12; i++) {
//            TextView tab = new TextView(this);
//            tab.setText(tabs[i]);
//            tab.setPadding(12,6,12,6);
//            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            lp.leftMargin = 16;
//            lp.topMargin = 16;
//            tab.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
//            flexboxLayout.addView(tab,lp);
//        }
        for (int i = 0; i < 12; i++) {
            TextView textView = (TextView) LayoutInflater.from(this).inflate(R.layout.item_tab, null);
            textView.setText(tabs[i]);
            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.leftMargin = 20;
            lp.topMargin = 20;
            flexboxLayout.addView(textView, lp);
        }
    }
}
