package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class RunningActivity extends AppCompatActivity {
    int seconds = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);




        final ImageView backgroundOne = findViewById(R.id.background_one);
        final ImageView backgroundTwo = findViewById(R.id.background_two);
        final ImageView obstacleOne = findViewById(R.id.graveler1);
        final ImageView obstacleTwo = findViewById(R.id.graveler2);

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

                final float widthGraveler = obstacleOne.getWidth();
                final float translationXGraveler = widthGraveler * progress;
                obstacleOne.setTranslationX(translationXGraveler);
                obstacleTwo.setTranslationX(translationXGraveler - widthGraveler);
            }
        });


        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
        animator.start();

    }

    public void onClickStart(){
        running = true;
    }

    public void onClickStop(View v){
        running = false;
    }

    public void onClickReset(View v){
        running = false;
        seconds = 0;
    }

    private void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running){
                    seconds++;
                }

                handler.postDelayed(this,1000);
            }
        });
    }

    public void upClick(View v){
        ImageView high = findViewById(R.id.imageViewdoes);
        ImageView low = findViewById(R.id.imageView);

        high.setVisibility(View.VISIBLE);
        high.setImageResource(R.drawable.psyducksprite);
        low.setVisibility(View.INVISIBLE);




    }

    public void downClick(View v){
        ImageView high = findViewById(R.id.imageViewdoes);
        ImageView low = findViewById(R.id.imageView);

        low.setVisibility(View.VISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
    }
}
