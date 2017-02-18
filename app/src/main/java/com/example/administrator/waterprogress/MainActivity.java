package com.example.administrator.waterprogress;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WaveProgressView wpv;
    private WaveView waveView;
    private static final int FLAG_ONE = 0X0001;
    private int max_progress = 100;
    private int progress;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress++;
            switch (msg.what) {
                case FLAG_ONE:
                    if (progress <= max_progress){
                        wpv.setCurrent(progress, progress + "%");
//                        waveView.setCurrent(progress, progress + "%");
                        sendEmptyMessageDelayed(FLAG_ONE, 100);
                    }else {
                        return;
                    }
                    break;
            }
        }
    };
    private void initView() {
        wpv = (WaveProgressView) findViewById(R.id.wave);
        wpv.setWaveColor("#FF49C12E");
//        waveView = (WaveView) findViewById(R.id.waveView);
//        waveView.setWaveColor("#FF49C12E");
        handler.sendEmptyMessageDelayed(FLAG_ONE, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
}
