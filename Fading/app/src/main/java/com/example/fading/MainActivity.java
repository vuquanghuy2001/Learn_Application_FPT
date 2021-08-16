package com.example.fading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bartIsShowing = true;

    public void fade(View view){
        Log.i("Info","ImageView tapped");
        ImageView bartImageView = findViewById(R.id.bartImageView);
        ImageView homerImageView = findViewById(R.id.homerImageView);
        if (bartIsShowing){
            bartIsShowing = false;
            bartImageView.animate().alpha(0).setDuration(2000);
            homerImageView.animate().alpha(1).setDuration(2000);
        }else {
            bartIsShowing = true;
            bartImageView.animate().alpha(1).setDuration(2000);
            homerImageView.animate().alpha(0).setDuration(2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}