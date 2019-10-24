package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class FlyingActivity extends AppCompatActivity {

    int x = 1;
    int seconds = 0;
    boolean running = true;
    boolean wasRunning = true;
    int timeTotal = 0;
    int level = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flying);

        final ImageView backgroundOne = findViewById(R.id.swimmingBackground1);
        final ImageView backgroundTwo = findViewById(R.id.swimmingBackground2);

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
                if (timeTotal == 5) {
                    x += 1;
                    animator.setDuration(5000L + x);
                    timeTotal = 0;
                }
            }
        });
        animator.start();

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                timeTotal = seconds;
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void upClick(View v) {
        ImageView one = findViewById(R.id.imageView1);
        ImageView two = findViewById(R.id.psyduckImage);
        ImageView three = findViewById(R.id.imageView3);
        ImageView four = findViewById(R.id.imageView4);


        if (level == 1) {

            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            one.setImageResource(R.drawable.psyducksprite);
            level = 1;

        } else if (level == 2) {

            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            one.setImageResource(R.drawable.psyducksprite);
            level = 1;

        } else if (level == 3) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            two.setImageResource(R.drawable.psyducksprite);
            level = 2;

        } else if (level == 4) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.INVISIBLE);
            three.setImageResource(R.drawable.psyducksprite);
            level = 3;

        }

    }

    public void downClick(View v) {
        ImageView one = findViewById(R.id.imageView1);
        ImageView two = findViewById(R.id.psyduckImage);
        ImageView three = findViewById(R.id.imageView3);
        ImageView four = findViewById(R.id.imageView4);

        if (level == 1) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.INVISIBLE);
            two.setImageResource(R.drawable.psyducksprite);
            level = 2;

        } else if (level == 2) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.INVISIBLE);
            three.setImageResource(R.drawable.psyducksprite);
            level = 3;

        } else if (level == 3) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.VISIBLE);
            four.setImageResource(R.drawable.psyducksprite);
            level = 4;

        } else if (level == 4) {

            one.setVisibility(View.INVISIBLE);
            two.setVisibility(View.INVISIBLE);
            three.setVisibility(View.INVISIBLE);
            four.setVisibility(View.VISIBLE);
            four.setImageResource(R.drawable.psyducksprite);
            level = 4;

        }

    }

    public void onClickStart(View view) {
        running = true;
    }

}
