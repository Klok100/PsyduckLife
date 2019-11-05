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

import java.util.Timer;

import static android.view.View.VISIBLE;

public class RunningActivity extends AppCompatActivity {
    public static final long START_TIME_IN_MILLIS = 1000;
    public static final long COL_TIME_IN_MILLIS = 3000;
    private CountDownTimer myTimer;
    private boolean mTimer;
    private CountDownTimer colTimer;
    private boolean cTimer;
    private long myTimeLeft = START_TIME_IN_MILLIS;
    private long colTimeLeft = COL_TIME_IN_MILLIS;
    private ImageView up;
    private TextView timerTextView;
    private long startTime = 0;
    private TextView instructionsStart;
    private TextView instructionsEnd;
    private boolean isPlayable = true;


    private View.OnClickListener instructionsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            instructionsStart = findViewById(R.id.instructionsRunningStart);
            instructionsStart.setVisibility(View.GONE);

            startGame();
            //colTimer();
        }
    };


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

        instructionsStart = findViewById(R.id.instructionsRunningStart);

        instructionsStart.setOnClickListener(instructionsOnClickListener);

        instructionsEnd = findViewById(R.id.instructionsRunningEnd);

        instructionsEnd.setOnClickListener(instructionsOnClickListener);
    }


    public void startGame(){

        final ImageView backgroundOne = findViewById(R.id.runningBackground1);
        final ImageView backgroundTwo = findViewById(R.id.runningBackground2);
        final ImageView obstacleOne = findViewById(R.id.graveler1Running);
        final ImageView obstacleTwo = findViewById(R.id.graveler2Running);

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

        timerTextView = (TextView) findViewById(R.id.timer);

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

        up = findViewById(R.id.upButtonRunning);


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upClick(v);
                //if (mTimer) {
                    //resetTimer();
               // }
              //  else {
                    startTimer();
                    colTimer();
                    resetTimer();
                //}
            }
        });

    }


    private void startTimer() {
        myTimer =  new  CountDownTimer(myTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                myTimeLeft = millisUntilFinished;

            }

            //@Override
            public void onFinish() {
                //mTimer = false;
                downClick();
            }
        }.start();

        //mTimer = true;
    }

    private void colTimer(){
        final ImageView high = findViewById(R.id.airPsyduck);
        colTimer =  new  CountDownTimer(colTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                colTimeLeft = millisUntilFinished;
                //checkCol();
            }

            //@Override
            public void onFinish() {
                cTimer = false;
                high.setVisibility(VISIBLE);
            }

        }.start();

        cTimer = true;
    }


    private void resetTimer() {
        myTimeLeft = START_TIME_IN_MILLIS;
        colTimeLeft = COL_TIME_IN_MILLIS;
    }


    public void upClick(View v){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        high.setVisibility(VISIBLE);
        high.setImageResource(R.drawable.psyducksprite);
        low.setVisibility(View.INVISIBLE);

        endGame();
    }


    public void downClick(){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        low.setVisibility(VISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
    }

    public void checkCol(){
        ImageView low = findViewById(R.id.groundPsyduck);

        if (low.getVisibility() == View.VISIBLE) {
            endGame();
        }
    }


    public void repeatColTimer(){
        while(isPlayable){
            colTimer();
        }
    }


    public void endGame(){

        View.OnClickListener instructionsOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructionsEnd = findViewById(R.id.instructionsRunningEnd);
                instructionsEnd.setVisibility(VISIBLE);
                ImageView high = findViewById(R.id.airPsyduck);
                high.setVisibility(VISIBLE);
            }
        };
    }
}
