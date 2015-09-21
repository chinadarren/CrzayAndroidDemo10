package com.example.cl.crzayandroiddemo10;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends Activity implements View.OnClickListener{
Chronometer ch;
    Button start;
    Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //获取计时器组件
        ch = (Chronometer) findViewById(R.id.ch);
        //获取开始按钮
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

//为Chronometer绑定事件监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //如果从开始计时叨腺癌超过了20s
                if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                //设置开始计时时间
                ch.setBase(SystemClock.elapsedRealtime());
                //启动计时器
                ch.start();
                start.setEnabled(false);
                break;
            case R.id.stop:
                ch.stop();
                start.setEnabled(true);
                break;
            default:
                break;
        }
    }
}
