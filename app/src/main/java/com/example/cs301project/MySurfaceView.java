package com.example.cs301project;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.BitmapCompat;

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

        int w = canvas.getWidth();

        image = Bitmap.createScaledBitmap(image,w,w, false);

        Bitmap whiteRook = BitmapFactory.decodeResource(getResources(), R.drawable.whiterookpng);
        int rookwidth = w/9;
        int rookheight = w/9 * whiteRook.getHeight()/whiteRook.getWidth();
        whiteRook = Bitmap.createScaledBitmap(whiteRook,rookwidth,rookheight,false);


        Paint black = new Paint();
        black.setColor(Color.BLACK);
        ColorFilter blackFilter = new PorterDuffColorFilter(ContextCompat.getColor(this.getContext(), R.color.black), PorterDuff.Mode.SRC_IN);
        black.setColorFilter(blackFilter);
        canvas.drawBitmap(image, 0.f, 0.f, null);

        canvas.drawBitmap(whiteRook,0,0,null);
        canvas.drawBitmap(whiteRook, w-w/8,0,black);
    }
}