package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;
public class RunningActivity extends AppCompatActivity {
    public static final long START_TIME_IN_MILLIS = 1500;
    private CountDownTimer myTimer;
    private boolean mTimer;
    private CountDownTimer mcollisionTimer;
    private long myTimeLeft = START_TIME_IN_MILLIS;
    private long myColTimeLeft = 5000;
    private ImageView up;


    TextView timerTextView;
    long startTime = 0;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 500);

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

        up = findViewById(R.id.imageButton);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upClick(v);
                if (mTimer) {
                    resetTimer();
                } else {
                    startTimer();
                }
            }
        });

    }

    ImageView high = findViewById(R.id.airPsyduck);
    ImageView low = findViewById(R.id.groundPsyduck);

    private void startTimer() {
        myTimer =  new  CountDownTimer(myTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                myTimeLeft = millisUntilFinished;

            }

            //@Override
            public void onFinish() {
                mTimer = false;
                downClick();
            }
        }.start();

        mTimer = true;

    }

    private void collisionTimer() {
        mcollisionTimer =  new  CountDownTimer(myColTimeLeft, 5000) {
            @Override
            public void onTick(long colmillisUntilFinished) {
                myColTimeLeft = colmillisUntilFinished;

            }

            //@Override
            public void onFinish() {
                mTimer = false;
                downClick();
            }
        }.start();

        mTimer = true;

    }



    private void resetTimer() {
        myTimeLeft = START_TIME_IN_MILLIS;
    }

    public void upClick(View v){


        high.setVisibility(View.VISIBLE);
        high.setImageResource(R.drawable.psyducksprite);
        low.setVisibility(View.INVISIBLE);


    }

    public void downClick(){

        low.setVisibility(View.VISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
    }
}
