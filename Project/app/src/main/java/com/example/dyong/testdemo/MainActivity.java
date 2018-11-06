package com.example.dyong.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.dyong.testdemo.list_adapter.SimpleItemAdapter;
import com.google.android.flexbox.FlexboxLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.flexboxLayout)
    FlexboxLayout flexboxLayout;

    String[] tabs = new String[]{
            "今日头条", "美团", "阿里巴巴", "京东", "腾讯科技有限公司",
            "蘑菇街", "名创优品", "b百佳华", "千百度", "小李飞刀",
            "今日打老虎", "玉面郎君"
    };
    @BindView(R.id.container)
    LinearLayout container;


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


    @OnClick({R.id.btnShowBottomSheetDialog, R.id.showPopupWindow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnShowBottomSheetDialog:
//                BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
//                View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet_list, null);
//                RecyclerView rv = contentView.findViewById(R.id.rv);
//                rv.setLayoutManager(new LinearLayoutManager(this));
//                rv.setAdapter(new SimpleItemAdapter(tabs));
//                mBottomSheetDialog.setContentView(contentView);

//                mBottomSheetDialog.show();
                break;
            case R.id.showPopupWindow:

                View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet_list, null);
                RecyclerView rv = contentView.findViewById(R.id.rv);
                rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(new SimpleItemAdapter(tabs));
                int height = ViewGroup.LayoutParams.WRAP_CONTENT;
                if (tabs.length > 6) {
                    height = 600;
                }
                PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,height);
                popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
                popupWindow.setFocusable(false);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setContentView(contentView);
                popupWindow.showAtLocation(container, Gravity.BOTTOM, 0, 0);
                break;
        }
    }
}
