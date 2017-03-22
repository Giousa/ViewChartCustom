package com.zmm.viewchartcustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zmm.viewchartcustom.act.ChartOneActivity;
import com.zmm.viewchartcustom.act.ChartTwoActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_1, R.id.btn_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                Intent intent1 = new Intent(MainActivity.this, ChartOneActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_2:
                Intent intent2 = new Intent(MainActivity.this, ChartTwoActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
