package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class SwimmingActivity extends AppCompatActivity {

    int x = 1;
    int seconds = 0;
    boolean running = true;
    boolean wasRunning = true;
    int timeTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming);

        final ImageView backgroundOne = (ImageView) findViewById(R.id.swimmingBackground1);
        final ImageView backgroundTwo = (ImageView) findViewById(R.id.swimmingBackground2);

        final ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(5000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = backgroundOne.getWidth();
                final float translationX = width * progress;
                backgroundOne.setTranslationX(translationX);
                backgroundTwo.setTranslationX(translationX - width);
                if(timeTotal == 5) {
                    x += 1;
                    animator.setDuration(5000L + x);
                    timeTotal = 0;
                }
            }
        });
        animator.start();

        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                timeTotal = seconds;
                handler.postDelayed(this,1000);
            }
        });
    }

    public void onClickStart(View view){
        running = true;
    }

}
