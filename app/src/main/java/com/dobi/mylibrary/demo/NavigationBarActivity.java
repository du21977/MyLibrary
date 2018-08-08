package com.dobi.mylibrary.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dobi.common.base.BaseActivity;
import com.dobi.common.navigationbar.DefaultNavigationBar;
import com.dobi.mylibrary.R;

public class NavigationBarActivity extends BaseActivity {



    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_navigation_bar);
    }

    @Override
    protected void initTitle() {
        DefaultNavigationBar navigationBar = new
                DefaultNavigationBar.Builder(this)
                .setTitle("投稿")
                .builder();

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
