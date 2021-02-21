package com.example.cs301project;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
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


        // loading, scaling, and displaying chessboard
        Bitmap chessboardimg = BitmapFactory.decodeResource(getResources(), R.drawable.chessboard);

        int w = canvas.getWidth();

        //making a rotation matrix
        Matrix mat = new Matrix();
        mat.postRotate(90);

        chessboardimg = Bitmap.createScaledBitmap(chessboardimg,w,w, false);
        //rotating the image by 90 degrees because the image isn't correct in the orientation we have it at
        chessboardimg = Bitmap.createBitmap(chessboardimg,0,0,chessboardimg.getWidth(),chessboardimg.getHeight(),mat,true);

        canvas.drawBitmap(chessboardimg, 0.f, 0.f, null);

        //drawing the rooks

        Bitmap whiteRook = BitmapFactory.decodeResource(getResources(), R.drawable.whiterookpng);
        int rookwidth = w/9;
        int rookheight = w/9 * whiteRook.getHeight()/whiteRook.getWidth();
        whiteRook = Bitmap.createScaledBitmap(whiteRook,rookwidth,rookheight,false);


        Paint black = new Paint();
        black.setColor(Color.BLACK);
        ColorFilter blackFilter = new PorterDuffColorFilter(ContextCompat.getColor(this.getContext(), R.color.black), PorterDuff.Mode.SRC_IN);
        black.setColorFilter(blackFilter);


        canvas.drawBitmap(whiteRook, w-w/8,0,black);
        canvas.drawBitmap(whiteRook,0,0,black);

        canvas.drawBitmap(whiteRook, 0,w-w/8,null);
        canvas.drawBitmap(whiteRook,w-w/8,w-w/8,null);



        //drawing the Knights
        Bitmap whiteKnight = BitmapFactory.decodeResource(getResources(), R.drawable.whiteknight);
        Bitmap blackKnight = BitmapFactory.decodeResource(getResources(), R.drawable.blackknight);
        int knightWidth = w/9;
        int knightHeight = w/9 * whiteKnight.getHeight()/whiteKnight.getWidth();
        whiteKnight = Bitmap.createScaledBitmap(whiteKnight,knightWidth,knightHeight,false);
        blackKnight = Bitmap.createScaledBitmap(blackKnight,knightWidth,knightHeight,false);


        canvas.drawBitmap(blackKnight,w-w*7/8,0.f,null);
        canvas.drawBitmap(blackKnight, w-w*2/8,0.f,null);
        canvas.drawBitmap(whiteKnight, w-w*7/8, w-w*1/8, null);
        canvas.drawBitmap(whiteKnight, w-w*2/8,w-w*1/8,null);

        //drawing the Bishops
        Bitmap whiteBishop = BitmapFactory.decodeResource(getResources(), R.drawable.whitebishop);
        Bitmap blackBishop = BitmapFactory.decodeResource(getResources(), R.drawable.blackbishop);
        int bishopWidth = w/9;
        int bishopHeight = w/9 * whiteBishop.getHeight()/whiteBishop.getWidth();
        whiteBishop = Bitmap.createScaledBitmap(whiteBishop,bishopWidth,bishopHeight,false);
        blackBishop = Bitmap.createScaledBitmap(blackBishop,bishopWidth,bishopHeight,false);


        canvas.drawBitmap(blackBishop,w-w*6/8,0.f,null);
        canvas.drawBitmap(blackBishop, w-w*3/8,0.f,null);
        canvas.drawBitmap(whiteBishop, w-w*6/8, w-w*1/8, null);
        canvas.drawBitmap(whiteBishop, w-w*3/8,w-w*1/8,null);


        //drawing the kings
        Bitmap whiteKing = BitmapFactory.decodeResource(getResources(),R.drawable.whiteking);
        Bitmap blackKing = BitmapFactory.decodeResource(getResources(),R.drawable.blackking);
        int kingWidth = w/9;
        int kingHeight = w/9 * whiteKing.getHeight()/whiteKing.getWidth();
        whiteKing = Bitmap.createScaledBitmap(whiteKing,kingWidth,kingHeight,false);
        blackKing = Bitmap.createScaledBitmap(blackKing,kingWidth,kingHeight,false);

        canvas.drawBitmap(blackKing,w-w*4/8,0.f,null);
        canvas.drawBitmap(whiteKing,w-w*4/8,w*7/8,null);

        //queens
        Bitmap whiteQueen = BitmapFactory.decodeResource(getResources(),R.drawable.whitequeen);
        Bitmap blackQueen = BitmapFactory.decodeResource(getResources(),R.drawable.blackqueen);
        int queenWidth = w/9;
        int queenHeight = w/9 * whiteQueen.getHeight()/whiteQueen.getWidth();
        whiteQueen = Bitmap.createScaledBitmap(whiteQueen,queenWidth,queenHeight,false);
        blackQueen = Bitmap.createScaledBitmap(blackQueen,queenWidth,queenHeight,false);

        canvas.drawBitmap(whiteQueen,w*3/8,w*7/8,null);
        canvas.drawBitmap(blackQueen,w*3/8,0.f,null);

        //pawns
        Bitmap whitePawn = BitmapFactory.decodeResource(getResources(),R.drawable.whitepawn);
        int pawnWidth = w/9;
        int pawnHeight = w/9 * whitePawn.getHeight()/whitePawn.getWidth();
        whitePawn = Bitmap.createScaledBitmap(whitePawn,pawnWidth,pawnHeight,false);

        for(int i = 0; i < 8; i++){
            canvas.drawBitmap(whitePawn,w*i/8,w*6/8,null);
            canvas.drawBitmap(whitePawn,w*i/8,w/8,black);
        }

    }


}