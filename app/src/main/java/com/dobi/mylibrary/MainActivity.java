package com.dobi.mylibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dobi.common.base.BaseActivity;
import com.dobi.mylibrary.demo.AlertDialogActivity;
import com.dobi.mylibrary.demo.NavigationBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tv)
    TextView tv;

    @Bind(R.id.btn_dialog)
    TextView btn_dialog;

    @Bind(R.id.btn_navigation_bar)
    TextView btn_navigation_bar;



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ButterKnife.bind(this);
//    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        tv.setText("大王炸小王");
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
    }

    @OnClick({R.id.tv, R.id.btn_dialog,R.id.btn_navigation_bar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                break;
            case R.id.btn_dialog:
            startActivity(AlertDialogActivity.class);
                break;
            case R.id.btn_navigation_bar:
                startActivity(NavigationBarActivity.class);
                break;

        }
    }
}
