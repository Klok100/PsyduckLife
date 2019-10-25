package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class SwimmingActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_swimming);

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
            }
        });
        animator.start();

        timerTextView = (TextView) findViewById(R.id.textView);

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
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

    public void onClickStart(View view){
        running = true;
    }

}
