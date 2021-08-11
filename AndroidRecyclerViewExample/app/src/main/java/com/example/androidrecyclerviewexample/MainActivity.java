package com.example.androidrecyclerviewexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        CourseData courseData[] = {new CourseData("Android"),
                new CourseData("Java"),
                new CourseData(".Net"),
                new CourseData("Python"),
                new CourseData("Artificial Intelligence"),
                new CourseData("Cloud Computing")};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CourseAdapter courseAdapter = new CourseAdapter(courseData);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}