package com.example.animate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){
        Log.i("Info","ImageView tapped");
        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000*10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.setX(-1000);
        bartImageView.animate().translationXBy(1000).rotation(360*20).setDuration(1000*5);
    }
}