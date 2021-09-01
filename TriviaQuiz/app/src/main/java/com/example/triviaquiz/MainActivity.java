package com.example.triviaquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.triviaquiz.controller.AppController;
import com.example.triviaquiz.data.AnswerListAsyncResponse;
import com.example.triviaquiz.data.Repository;
import com.example.triviaquiz.databinding.ActivityMainBinding;
import com.example.triviaquiz.model.Question;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        questionList = new Repository().getQuestions(questionArrayList -> {
//            Log.d("Main", "onCreate" + questionArrayList);
            binding.questionTextview.setText(questionArrayList.get(currentQuestionIndex).getAnswer());
        });

        binding.buttonNext.setOnClickListener(view -> {
            currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();
            updateQuestion();
        });

        binding.buttonTrue.setOnClickListener(view -> {

        });

        binding.buttonFalse.setOnClickListener(view -> {

        });
    }

    private void updateQuestion() {
        String question = questionList.get(currentQuestionIndex).getAnswer();
        binding.questionTextview.setText(question);
    }
}