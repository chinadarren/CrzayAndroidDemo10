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
   //��ȡ��ʱ�����
        ch = (Chronometer) findViewById(R.id.ch);
        //��ȡ��ʼ��ť
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

//ΪChronometer���¼�������
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //����ӿ�ʼ��ʱ߶�ٰ�������20s
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
                //���ÿ�ʼ��ʱʱ��
                ch.setBase(SystemClock.elapsedRealtime());
                //������ʱ��
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
