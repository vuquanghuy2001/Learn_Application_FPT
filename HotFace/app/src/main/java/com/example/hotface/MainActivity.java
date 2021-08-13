package com.example.hotface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    Button button;

    Random r;

    Integer[] images = {
            R.drawable.hotface1,
            R.drawable.hotface2,
            R.drawable.hotface3,
            R.drawable.hotface4,
            R.drawable.hotface5,
            R.drawable.hotface6
    };

    int pickedImage = 0;
    int lastPicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        button = findViewById(R.id.button);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // remove duplicates
                do {
                    pickedImage = r.nextInt(images.length);
                }while (pickedImage == lastPicked);

                lastPicked = pickedImage;
                // display random image
                imageView.setImageResource(images[pickedImage]);
            }
        });
    }
}