package com.dobi.common.recycleview.refreshLoad;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.dobi.common.R;
import com.dobi.common.recycleview.widget.LoadRecycleView;
import com.dobi.common.recycleview.widget.LoadRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LoadMoreActivity extends AppCompatActivity {

    LoadRecycleView load_more_recycleview;

    List<String> mDatas =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);
        load_more_recycleview = (LoadRecycleView) findViewById(R.id.load_more_recycleview);

        init();

        load_more_recycleview.addLoadViewCreator(new DefaultLoadCreator());
        load_more_recycleview.setLayoutManager(new LinearLayoutManager(this));
        final LoadMoreAdapter loadMoreAdapter = new LoadMoreAdapter();
        load_more_recycleview.setAdapter(loadMoreAdapter);

        load_more_recycleview.setOnLoadMoreListener(new LoadRefreshRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoad() {
                Toast.makeText(LoadMoreActivity.this,"下拉加载啦",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(mDatas.size()<20){
                            mDatas.add("杜成文"+100);
                            mDatas.add("杜成文"+100);
                            mDatas.add("杜成文"+100);
                            load_more_recycleview.onStopLoad();
                            loadMoreAdapter.notifyDataSetChanged();
                        }else {
                            load_more_recycleview.onSetNoMore();
                            loadMoreAdapter.notifyDataSetChanged();
                        }


                    }
                }, 1000);
            }
        });


    }

    private void init() {
        for(int i=0;i<5;i++){
            mDatas.add("杜成文"+i);
        }
    }

    class LoadMoreAdapter extends RecyclerView.Adapter<LoadMoreAdapter.ViewHolder>{


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_load_more_item, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            TextView textView = holder.itemView.findViewById(R.id.tv);
            textView.setText("和小胖 "+position);
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{


            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
