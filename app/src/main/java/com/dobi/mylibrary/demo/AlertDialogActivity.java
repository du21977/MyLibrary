package com.dobi.mylibrary.demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dobi.common.base.BaseActivity;
import com.dobi.common.dialog.MyAlertDialog;
import com.dobi.mylibrary.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2018/8/8.
 */

public class AlertDialogActivity extends BaseActivity {


    @Bind(R.id.btn_alerdialog_system)
    Button btnAlerdialogSystem;
    @Bind(R.id.btn_alerdialog_common)
    Button btnAlerdialogCommon;
    @Bind(R.id.btn_alerdialog_mine)
    Button btnAlerdialogMine;

    @Override
    protected void setContentView() {

        setContentView(R.layout.activity_alertdialog);
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.btn_alerdialog_system, R.id.btn_alerdialog_common, R.id.btn_alerdialog_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_alerdialog_system:

              systemAlertDialog();

                break;
            case R.id.btn_alerdialog_common:

                commonAlertDialog();
                break;
            case R.id.btn_alerdialog_mine:
                niubiAlertDialog();
                break;
        }
    }




    AlertDialog systemDialog;
    private void systemAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.android_logo);
        builder.setTitle("头部");
        builder.setMessage("内容");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mActivity,"点击了是",Toast.LENGTH_LONG).show();
                systemDialog.dismiss();
            }
        });

        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mActivity,"点击了否",Toast.LENGTH_LONG).show();
                systemDialog.dismiss();
            }
        });
        systemDialog = builder.create();
        systemDialog.show();
    }


    /**
     * 自定义布局
     */
    AlertDialog commonDialog;
    private void commonAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this,R.layout.alertdialog_commom,null);
        Button button1 = view.findViewById(R.id.btn_common_1);
        Button button2 = view.findViewById(R.id.btn_common_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"button1",Toast.LENGTH_LONG).show();
                commonDialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"button2",Toast.LENGTH_LONG).show();
                commonDialog.dismiss();
            }
        });
        commonDialog = builder.create();
        commonDialog.setView(view,0,0,0,0);
        commonDialog.show();


    }


    /**
     * 万能的Dialog
     */
    MyAlertDialog niubiDialog;
    private void niubiAlertDialog() {
        niubiDialog = new MyAlertDialog.Builder(this)
                .setContentView(R.layout.alertdialog_commom)
                .formBottom(true).fullWidth().show();
//        Button button1 = niubiDialog.getView(R.id.btn_common_1);
//        Button button2 = niubiDialog.getView(R.id.btn_common_2);

        niubiDialog.setText(R.id.btn_common_1,"哈哈");
        niubiDialog.setOnclickListener(R.id.btn_common_1, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"button----1",Toast.LENGTH_LONG).show();
            }
        });
        niubiDialog.setOnclickListener(R.id.btn_common_2, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity,"button----2",Toast.LENGTH_LONG).show();
                niubiDialog.dismiss();
            }
        });
    }
}
