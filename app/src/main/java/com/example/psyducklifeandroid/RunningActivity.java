package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class RunningActivity extends AppCompatActivity {

    int seconds = 0;
    boolean running = false;
    boolean wasRunning = false;

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running && seconds < 3){
                    seconds++;
                }
            }
        });
    }

    TextView timerTextView;
    long startTime = 0;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);

            timerTextView.setText(String.format("%02d", seconds));

            timerHandler.postDelayed(this, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        final ImageView backgroundOne = findViewById(R.id.runningBackground1);
        final ImageView backgroundTwo = findViewById(R.id.runningBackground2);
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
        animator.start();

        timerTextView = (TextView) findViewById(R.id.textView);

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);


    }

    public void upClick(View v){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        high.setVisibility(View.VISIBLE);
        high.setImageResource(R.drawable.psyducksprite);
        low.setVisibility(View.INVISIBLE);


    }

    public void downClick(View v){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        low.setVisibility(View.VISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
    }
}
