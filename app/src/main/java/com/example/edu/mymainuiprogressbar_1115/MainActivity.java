package com.example.edu.mymainuiprogressbar_1115;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_run;
    ProgressBar progressBarPost;
    private int mProgressBarStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_run = (Button)findViewById(R.id.btn_run);
        btn_run.setOnClickListener(this);

        progressBarPost = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                while (mProgressBarStatus < 100 ){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgressBarStatus ++;
                    progressBarPost.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBarPost.setProgress(mProgressBarStatus);
                        }
                    });
                }
            }
        }).start();

    }
}
