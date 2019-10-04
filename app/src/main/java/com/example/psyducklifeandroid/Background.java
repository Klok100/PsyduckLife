package com.example.psyducklifeandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    private Bitmap image;

    private int x;
    private int y;
    private int speed;

    public Background(Bitmap resource) {

        image = resource;

    }

    public void update() {

        x += speed;

        if (x < -HomeScreen.WIDTH) {

            x = 0;

        }

    }

    public void draw(Canvas c) {

        c.drawBitmap(image, x, y, null);

        if (x < 0) {

            c.drawBitmap(image, x + HomeScreen.WIDTH, y, null);

        }

    }

    public void setSector(int speed) {

        this.speed = speed;

    }

}
