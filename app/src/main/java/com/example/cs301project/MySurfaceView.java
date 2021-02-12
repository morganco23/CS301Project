package com.example.cs301project;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView {


    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //VERY CRITICAL
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        Paint red = new Paint();
        red.setColor(Color.RED);

        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.chessboard);

        Paint black = new Paint();
        black.setColor(Color.BLACK);
        canvas.drawBitmap(image, 150.f, 250.f, black);
    }
}