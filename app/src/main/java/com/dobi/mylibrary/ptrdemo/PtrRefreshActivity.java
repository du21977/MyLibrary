package com.dobi.mylibrary.ptrdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dobi.mylibrary.R;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class PtrRefreshActivity extends AppCompatActivity {

    private PtrClassicFrameLayout ptrLayout;
    private ListView lv;

    private ArrayAdapter<String> adapter;
    private List<String> dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptr_refresh);
        ptrLayout = (PtrClassicFrameLayout) findViewById(R.id.ptr_layout);
        lv = (ListView) findViewById(R.id.id_main_lv_lv);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initData();
        initView();
        initEvent();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 初始化ListView中展示的数据
        dataSource = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            dataSource.add("Existed Old List Item " + i);
        }
    }

    /**
     * 初始化布局控件
     */
    private void initView() {
        // 初始化ListView中的数据
        adapter = new ArrayAdapter<String>(PtrRefreshActivity.this, android.R.layout.simple_list_item_1, dataSource);
        lv.setAdapter(adapter);

        //设置有更新时间
        ptrLayout.setLastUpdateTimeRelateObject(this);


        // 自己定义的布局
        ptrLayout.setHeaderView(new MyPtrRefresher(PtrRefreshActivity.this));
        ptrLayout.addPtrUIHandler(new MyPtrHandler(PtrRefreshActivity.this, ptrLayout));
        //  ptrLayout.autoRefresh();
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        },2000);

    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        ptrLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataSource.add("New Bottom List Item");
                        adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                        //  lv.smoothScrollToPosition(dataSource.size() - 1);
                    }
                }, 3000);
            }
        });
    }

}
