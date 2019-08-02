package com.example.dhananjay.litetimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer m1;
    EditText setText;
    TextView doneText;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setText = findViewById(R.id.textView2);
        doneText = findViewById(R.id.textView3);
        btn = findViewById(R.id.btnStart);
        btn2 = findViewById(R.id.btnStop);

    }

    public void timerStart() {
        m1 = MediaPlayer.create(this, R.raw.two);

        double min = Double.parseDouble(setText.getText().toString());
        min *= 60;
        int s = (int) min;
        new CountDownTimer(s * 1000, 1000) {
            public void onTick(long MiliSec) {

                setText.setText("Time: " + String.valueOf(MiliSec / 1000));
//                textView1.setText("Time: "+String.valueOf(MiliSec/1000));
                setText.setEnabled(false);
                btn.setEnabled(false);
                btn2.setEnabled(false);

            }

            public void onFinish() {
                doneText.setText("done");
                setText.setText("0");
                setText.setEnabled(true);
                btn.setEnabled(true);
                btn2.setEnabled(true);
                play(true);

            }
        }.start();

    }

    public void play(boolean result) {
        if (result) {
            m1.setLooping(true);
            m1.start();
        }

    }

    public void stop(View view) {
        m1.reset();
    }

    public void btnSetTimer(View view) {
        timerStart();
    }

    @Override
    protected void onDestroy() {
        m1.release();
        super.onDestroy();
    }
}
