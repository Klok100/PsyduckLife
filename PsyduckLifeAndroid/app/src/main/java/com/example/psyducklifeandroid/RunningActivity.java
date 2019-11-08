package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.util.Timer;

import static android.view.View.VISIBLE;

public class RunningActivity extends AppCompatActivity {
    public static final long START_TIME_IN_MILLIS = 1000;
    public static final long COL_TIME_IN_MILLIS = 3000000;
    public static final long OBS_TIME_IN_MILLIS = 5000000;
    private CountDownTimer myTimer;
    private boolean mTimer;
    private CountDownTimer colTimer;
    private boolean cTimer;
    private CountDownTimer obstacleTimer;
    private boolean oTimer;
    private CountDownTimer obstacleTimer2;
    private boolean oTimer2;
    private long myTimeLeft = START_TIME_IN_MILLIS;
    private long colTimeLeft = COL_TIME_IN_MILLIS;
    private long obsTimeLeft = OBS_TIME_IN_MILLIS;
    private long obsTimeLeft2 = OBS_TIME_IN_MILLIS;
    private ImageView up;
    private TextView timerTextView;
    private long startTime = 0;
    private TextView instructionsStart;
    private TextView instructionsEnd;
    private int seconds;
    private boolean onGraveler = false;



    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            seconds = (int) (millis / 1000);

            timerTextView.setText(String.format("%02d", seconds));

            timerHandler.postDelayed(this, 1000);

            colTimer();
            obstacleTimer();
            obstacleTimer2();


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
    }


    @Override
    protected void onStart() {
        super.onStart();

        instructionsStart = findViewById(R.id.instructionsRunningStart);

        instructionsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startGame(v);

               instructionsStart.setVisibility(View.GONE);
           }
        });

        instructionsEnd = findViewById(R.id.instructionsRunningEnd);

    }


    public void startGame(View v){

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
                resetTimer();
                startTimer();

            }
        });
    }


    private void startTimer() {
        myTimer =  new  CountDownTimer(myTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                myTimeLeft = millisUntilFinished;

            }

            @Override
            public void onFinish() {
                downClick();
            }
        }.start();

    }


    private void colTimer(){
        colTimer =  new  CountDownTimer(colTimeLeft, 1) {
            @Override
            // GOOD
            public void onTick(long millisUntilFinished) {
                colTimeLeft = millisUntilFinished;
                checkCol();
            }

            @Override
            public void onFinish(){
            }

        }.start();

    }


    // This is starting time of where graveler is. Psyduck meets graveler around every 5 sec
    // so i made countdown interval 5000ms and on every tick it makes onGraveler true then in obstacleTimer2() the idea was to
    // start that [Blank] (i think around 1 sec) after the first becuase thats how long psyduck stays in contact eith graveler
    // we use the onGraveler boolean later to determine if psyduck collides or not (in the checkcol method).
    // the one second timer and fivesectimer were just experiemnts to give obstacleTimer2 a later start than obstacleTimer.
    // and the fivesectimer i changed to 10ms so its not actually 5 sec.
    // Also the problem with coltimr not working is you have to put in the runnable LOOK AT LINE 64ish
    // in the checkcol method I changed if requirments to be psyduck low is visible and onGraver is true (aka psyduck is toucking graveler)
    // I think i covered all of it. If you cant figure anything out dont stress and go to sleep well just wing the presentation
    // sry for all the spelling mistakes.
    private void obstacleTimer(){
        obstacleTimer =  new  CountDownTimer(obsTimeLeft, 6000) {
            @Override
            // GOOD
            public void onTick(long millisUntilFinished) {
                obsTimeLeft = millisUntilFinished;
                onGraveler = true;
            }

            @Override
            public void onFinish(){

            }

        }.start();

    }


    private void obstacleTimer2(){
        obstacleTimer2 =  new  CountDownTimer(obsTimeLeft2, 5002) {
            @Override
            // GOOD
            public void onTick(long millisUntilFinished) {
                obsTimeLeft2 = millisUntilFinished;
                onGraveler = false;
            }

            @Override
            public void onFinish(){

            }

        }.start();

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

    }


    public void downClick(){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        low.setVisibility(VISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
    }

    // GOOD
    public void checkCol(){
        ImageView high = findViewById(R.id.airPsyduck);
        ImageView low = findViewById(R.id.groundPsyduck);

        if ((low.getVisibility() == VISIBLE) && onGraveler == true) {
            endGame2();
        }
    }

    public void endGame(View v) {

        instructionsEnd = findViewById(R.id.instructionsRunningEnd);
        instructionsEnd.setVisibility(VISIBLE);

    }

    public void endGame2() {

        instructionsEnd = findViewById(R.id.instructionsRunningEnd);
        instructionsEnd.setVisibility(VISIBLE);

    }


    public void returnScreen(View v){

        Intent intent = new Intent(this, HomeScreen.class);

        startActivity(intent);
    }
}
