package com.dobi.common.recycleview.refreshLoad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dobi.common.R;
import com.dobi.common.recycleview.widget.LoadRecycleView;
import com.dobi.common.recycleview.widget.LoadViewCreator;


/**
 * Created by Darren on 2017/1/3.
 * Email: 240336124@qq.com
 * Description: 默认样式的加载底部辅助类
 * 如淘宝、京东、不同的样式可以自己去实现
 */

public class DefaultLoadCreator extends LoadViewCreator {
    // 加载数据的ImageView
    private TextView mLoadTv;
    private View mRefreshIv;

    @Override
    public View getLoadView(Context context, ViewGroup parent) {
        View refreshView = LayoutInflater.from(context).inflate(R.layout.layout_load_footer_view, parent, false);
        mLoadTv = (TextView) refreshView.findViewById(R.id.load_tv);
        mRefreshIv = refreshView.findViewById(R.id.refresh_iv);
        return refreshView;
    }

    @Override
    public void onPull(int currentDragHeight, int refreshViewHeight, int currentRefreshStatus) {
//        if (currentRefreshStatus == LoadRefreshRecyclerView.LOAD_STATUS_PULL_DOWN_REFRESH) {
//            mLoadTv.setText("上拉加载更多");
//        }
//        if (currentRefreshStatus == LoadRefreshRecyclerView.LOAD_STATUS_LOOSEN_LOADING) {
//            mLoadTv.setText("松开加载更多");
//        }

        //add by me
        if (currentRefreshStatus == LoadRecycleView.LOAD_STATUS_PULL_DOWN_REFRESH) {
            mLoadTv.setText("上拉加载更多");
        }
        if (currentRefreshStatus == LoadRecycleView.LOAD_STATUS_LOOSEN_LOADING) {
            mLoadTv.setText("松开加载更多");
        }
    }

    @Override
    public void onLoading() {
        //mLoadTv.setVisibility(View.INVISIBLE);
      //  mRefreshIv.setVisibility(View.VISIBLE);

        // 加载的时候不断旋转
//        RotateAnimation animation = new RotateAnimation(0, 720,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setRepeatCount(-1);
//        animation.setDuration(1000);
//        mRefreshIv.startAnimation(animation);

        //add by me

        Log.e("状态onLoading",LoadRecycleView.mCurrentLoadStatus+"");
        if(LoadRecycleView.mCurrentLoadStatus == LoadRecycleView.LOAD_STATUS_NO_MORE){
            mLoadTv.setText("没有更多了");
        }else{
            mLoadTv.setText("正在加载中...");
        }
    }

    @Override
    public void onStopLoad() {
//        // 停止加载的时候清除动画
//        mRefreshIv.setRotation(0);
//        mRefreshIv.clearAnimation();
//        mLoadTv.setText("上拉加载更多");
//        mLoadTv.setVisibility(View.VISIBLE);
//        mRefreshIv.setVisibility(View.INVISIBLE);

        //add by me
        Log.e("状态onStopLoad",LoadRecycleView.mCurrentLoadStatus+"");
        if(LoadRecycleView.mCurrentLoadStatus == LoadRecycleView.LOAD_STATUS_NO_MORE){
            mLoadTv.setText("没有更多了");
        }else{
            mLoadTv.setText("上拉加载更多");
        }

    }
}
