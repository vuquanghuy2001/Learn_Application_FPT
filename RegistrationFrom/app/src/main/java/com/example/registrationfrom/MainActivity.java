package com.example.registrationfrom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRegister(View view){
        TextView viewFirstName = findViewById(R.id.viewFirstName);
        TextView viewLastName = findViewById(R.id.viewLastName);
        TextView viewEmail = findViewById(R.id.viewEmail);

        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText email = findViewById(R.id.email);

        viewFirstName.setText("First Name: " + firstName.getText().toString());
        viewLastName.setText("Last Name: " + lastName.getText().toString());
        viewEmail.setText("Email: " + email.getText().toString());
    }
}