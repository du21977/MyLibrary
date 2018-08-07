package com.dobi.common.recycleview.basicUse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.dobi.common.R;
import com.dobi.common.recycleview.widget.WrapRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2016/12/29.
 * Email: 240336124@qq.com
 * Description:  RecyclerView基本使用
 */

public class BasicUseActivity extends AppCompatActivity {

    //WrapRecyclerView是添加了addHeaderView功能的RecyclerView
    private WrapRecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();

        mRecyclerView = (WrapRecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new HomeAdapter(this, mDatas);
        //设置RecycleView样式
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        // 设置item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.id_action_gridview:
//                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//                break;
//            case R.id.id_action_listview:
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                break;
        }
        return true;
    }

    /**
     * 普通的RecyclerView 的Adapter
     */
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        private List<String> mDatas;
        private LayoutInflater mInflater;


        public HomeAdapter(Context context, List<String> datas) {
            mInflater = LayoutInflater.from(context);
            mDatas = datas;
        }

        //加载item 的布局  创建ViewHolder实例
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //创建View
            MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                    R.layout.item_home, parent, false));
            return holder;
        }

        //对RecyclerView子项数据进行赋值
        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas.get(position));
        }

        //返回子项个数
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        //ViewHolder的创建
        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
