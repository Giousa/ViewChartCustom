package com.zmm.viewchartcustom.act;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmm.viewchartcustom.R;
import com.zmm.viewchartcustom.view.LineView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/22
 * Time:下午4:21
 */

public class ChartTwoActivity extends AppCompatActivity {

    @InjectView(R.id.lineview)
    LineView mLineView;

    private static final int MSG_DATA_CHANGE = 0x11;
    private static final int MSG_DATA_CHANGE2 = 0x12;
    private Handler mHandler;
    private int mX = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_DATA_CHANGE:
                        mLineView.setLinePoint(msg.arg1, msg.arg2);
                        break;

                    case MSG_DATA_CHANGE2:
                        mLineView.setLinePoint2(msg.arg1, msg.arg2);
                        break;

                    default:
                        break;
                }
                super.handleMessage(msg);
            }
        };

        new Thread(){
            public void run() {
                for (int index=0; index<50; index++)
                {
                    Message message = new Message();
                    message.what = MSG_DATA_CHANGE;
                    message.arg1 = mX;
                    message.arg2 = (int)(Math.random()*200);
                    mHandler.sendMessage(message);
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mX += 10;
                }
            }
        }.start();

        new Thread(){
            public void run() {
                for (int index=0; index<60; index++)
                {
                    Message message = new Message();
                    message.what = MSG_DATA_CHANGE2;
                    message.arg1 = mX;
                    message.arg2 = (int)(Math.random()*200);
                    mHandler.sendMessage(message);
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mX += 10;
                }
            }
        }.start();
    }

}
