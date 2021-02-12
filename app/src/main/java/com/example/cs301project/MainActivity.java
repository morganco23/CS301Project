package com.example.cs301project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);



        //Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.myimage);
        //Paint black = new Paint();
        //black.setColor(Color.BLACK);
        //canvas.drawBitmap(image, 150.f, 250.f, black);
    }


}