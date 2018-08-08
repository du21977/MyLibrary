package com.dobi.mylibrary.ptrdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.dobi.mylibrary.R;

/**
 * Created by Admin on 2018/7/5.
 */

public class MyPtrRefresher extends LinearLayout {
    public MyPtrRefresher(Context context) {
        this(context, null);
    }

    public MyPtrRefresher(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public MyPtrRefresher(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_ptrrefresher, this);
    }
}