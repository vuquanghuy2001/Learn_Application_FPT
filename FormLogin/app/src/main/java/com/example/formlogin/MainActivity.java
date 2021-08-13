package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void login(View view){
        EditText username = findViewById(R.id.editTextTextPersonName5);
        EditText password = findViewById(R.id.editTextTextPassword2);
        Log.i("info","Login srarting");
        Log.i("Username", username.getText().toString());
        Log.i("Password", password.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

    }
}