package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class FlyingActivity extends AppCompatActivity {

    int level = 2;
    TextView instructions;
    Handler timerHandler = new Handler();
    TextView timerTextView;
    long startTime = 0;


    private View.OnClickListener instructionsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            instructions = findViewById(R.id.instructionsFlying);
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
        setContentView(R.layout.activity_flying);

        instructions = findViewById(R.id.instructionsFlying);

        instructions.setOnClickListener(instructionsOnClickListener);

    }

    public void startGame() {

        final ImageView backgroundOne = findViewById(R.id.flyingBackground1);
        final ImageView backgroundTwo = findViewById(R.id.flyingBackground2);

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

            }
        });
        animator.start();

        timerTextView = findViewById(R.id.timer);

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
    }


    public void upClick(View v) {
        ImageView one = findViewById(R.id.level1);
        ImageView two = findViewById(R.id.psyduckImage);
        ImageView three = findViewById(R.id.level3);
        ImageView four = findViewById(R.id.level4);

        if (level == 1) {

            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            one.setImageResource(R.drawable.psyducksprite);
            level = 1;

        }
        else if (level == 2) {

            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            one.setImageResource(R.drawable.psyducksprite);
            level = 1;

        }
        else if (level == 3) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            two.setImageResource(R.drawable.psyducksprite);
            level = 2;

        }
        else if (level == 4) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.INVISIBLE);
            three.setImageResource(R.drawable.psyducksprite);
            level = 3;
        }
    }

    public void downClick(View v) {
        ImageView one = findViewById(R.id.level1);
        ImageView two = findViewById(R.id.psyduckImage);
        ImageView three = findViewById(R.id.level3);
        ImageView four = findViewById(R.id.level4);

        if (level == 1) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            two.setImageResource(R.drawable.psyducksprite);
            level = 2;

        }
        else if (level == 2) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.INVISIBLE);
            three.setImageResource(R.drawable.psyducksprite);
            level = 3;

        }
        else if (level == 3) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.VISIBLE);
            four.setImageResource(R.drawable.psyducksprite);
            level = 4;

        }else if (level == 4) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.VISIBLE);
            four.setImageResource(R.drawable.psyducksprite);
            level = 4;

        }
    }
}

