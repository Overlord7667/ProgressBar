package com.betelgeuse.corp.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.start);
        ProgressBar progressBar = findViewById(R.id.thirdProgressBar);
        Random random = new Random();

        btnStart.setOnClickListener(View -> {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (progressBar.getProgress() < progressBar.getMax()){
                    //i = i + 10 ;
                    //progressBar.setProgress(i);
                        //progressBar.incrementProgressBy(10);
                        progressBar.incrementProgressBy(random.nextInt(50));
                    }else {
                        Toast.makeText(MainActivity.this , "Zapolneno", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    handler.postDelayed(this, 500);
                }
            });
            if (i < progressBar.getMax()){
                i = i + 10 ;
                progressBar.setProgress(i);

            }else {
                Toast.makeText(this, "Zapolneno", Toast.LENGTH_SHORT).show();
            }
        });
    }
}