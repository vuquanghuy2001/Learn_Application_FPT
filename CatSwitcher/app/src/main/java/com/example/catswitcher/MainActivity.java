package com.example.catswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    boolean image1Displaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (image1Displaying){
                    // Switch to image2
                    img.setImageResource(R.drawable.cat2);
                    image1Displaying = false;
                }else {
                    // Switch to image1
                    img.setImageResource(R.drawable.cat1);
                    image1Displaying = true;
                }
                return false;
            }
        });
    }
}