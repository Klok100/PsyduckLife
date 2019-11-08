package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class SwimmingActivity extends AppCompatActivity {

    public static final long START_TIME_IN_MILLIS = 1000;
    private CountDownTimer myTimer;
    private boolean mTimer;
    private long myTimeLeft = START_TIME_IN_MILLIS;
    private ImageView up;
    private ImageView down;
    TextView instructions;
    Handler timerHandler = new Handler();
    TextView timerTextView;
    private TextView instructionsEndSwimming;
    long startTime = 0;


    private View.OnClickListener instructionsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            instructions = findViewById(R.id.instructionsSwimming);
            instructions.setVisibility(View.GONE);

            startGame();
        }
    };


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
        setContentView(R.layout.activity_swimming);

        instructions = findViewById(R.id.instructionsSwimming);

        instructions.setOnClickListener(instructionsOnClickListener);

        instructionsEndSwimming = findViewById(R.id.instructionsEndSwimming);
    }


    public void startGame() {
        final ImageView backgroundOne = findViewById(R.id.swimmingBackground1);
        final ImageView backgroundTwo = findViewById(R.id.swimmingBackground2);
        final ImageView obstacleOne = findViewById(R.id.graveler1Swimming);
        final ImageView obstacleTwo = findViewById(R.id.graveler2Swimming);

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

        up = findViewById(R.id.upButtonSwimming);
        down = findViewById(R.id.downButton);

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

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            downClick(v);
            if (mTimer) {
                resetTimer();
            } else {
                startTimer();
            }
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
                mTimer = false;
                returnMiddle();
            }
        }.start();

        mTimer = true;
    }


    private void resetTimer() {
        myTimeLeft = START_TIME_IN_MILLIS;
    }


    public void upClick(View v) {
        ImageView high = findViewById(R.id.imageViewdoes);
        ImageView middle = findViewById(R.id.battleBackground);
        ImageView low = findViewById(R.id.imageViewdoes2);

        high.setVisibility(View.VISIBLE);
        high.setImageResource(R.drawable.psyducksprite);
        low.setVisibility(View.INVISIBLE);
        middle.setVisibility(View.INVISIBLE);
    }


    public void downClick(View v) {
        ImageView high = findViewById(R.id.imageViewdoes);
        ImageView middle = findViewById(R.id.battleBackground);
        ImageView low = findViewById(R.id.imageViewdoes2);


        middle.setVisibility(View.INVISIBLE);
        low.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
        low.setVisibility(View.VISIBLE);
    }


    public void returnMiddle(){
        ImageView high = findViewById(R.id.imageViewdoes);
        ImageView middle = findViewById(R.id.battleBackground);
        ImageView low = findViewById(R.id.imageViewdoes2);

        middle.setVisibility(View.VISIBLE);
        middle.setImageResource(R.drawable.psyducksprite);
        high.setVisibility(View.INVISIBLE);
        low.setVisibility(View.INVISIBLE);
    }


    public void endGame(View v) {

        instructionsEndSwimming = findViewById(R.id.instructionsEndSwimming);
        instructionsEndSwimming.setVisibility(VISIBLE);

    }


    public void returnScreen(View v){

        Intent intent = new Intent(this, HomeScreen.class);

        startActivity(intent);
    }
}
