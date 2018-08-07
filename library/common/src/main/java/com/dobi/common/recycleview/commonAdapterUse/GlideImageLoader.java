package com.dobi.common.recycleview.commonAdapterUse;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dobi.common.R;
import com.dobi.common.recycleview.adapter.ViewHolder;


/**
 * Created by Darren on 2016/12/28.
 * Email: 240336124@qq.com
 * Description:
 */

public class GlideImageLoader extends ViewHolder.HolderImageLoader {

    public GlideImageLoader(String imagePath) {
        super(imagePath);
    }

    @Override
    public void displayImage(Context context, ImageView imageView, String imagePath) {
        Glide.with(context).load(imagePath).placeholder(R.drawable.ic_discovery_default_channel).centerCrop().into(imageView);
    }
}
