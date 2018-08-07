package com.dobi.common.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dobi.common.R;
import com.dobi.common.recycleview.basicUse.BasicUseActivity;
import com.dobi.common.recycleview.commonAdapterUse.CommonAdapterActivity;
import com.dobi.common.recycleview.dragItemAnimatorUse.DragItemAnimatorActivity;
import com.dobi.common.recycleview.headerFooterUse.HeaderFooterActivity;
import com.dobi.common.recycleview.refreshLoad.LoadMoreActivity;
import com.dobi.common.recycleview.refreshLoad.RefreshLoadActivity;


/**
 * Created by Darren on 2016/12/29.
 * Email: 240336124@qq.com
 * Description:
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //最基本用法
    public void basicUse(View view) {
        Intent intent = new Intent(this, BasicUseActivity.class);
        startActivity(intent);
    }

    //通用Adapter
    public void commonAdapter(View view) {
        Intent intent = new Intent(this, CommonAdapterActivity.class);
        startActivity(intent);
    }

    //拖拽列表排序删除
    public void dragItemAnimator(View view) {
        Intent intent = new Intent(this, DragItemAnimatorActivity.class);
        startActivity(intent);
    }


    //添加头部和底部
    public void headerFooter(View view) {
        Intent intent = new Intent(this, HeaderFooterActivity.class);
        startActivity(intent);
    }

    //下拉刷新和上拉加载
    public void refreshLoad(View view){
        Intent intent = new Intent(this, RefreshLoadActivity.class);
        startActivity(intent);
    }

    //上拉加载更多
    public void loadmore(View view){
        Intent intent = new Intent(this, LoadMoreActivity.class);
        startActivity(intent);
    }
}
