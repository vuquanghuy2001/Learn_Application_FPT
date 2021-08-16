package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view){
        Log.i("Info","Convert starting");
        EditText editText = findViewById(R.id.editText);
        TextView VNDtextView = findViewById(R.id.VNDtextView);
        String amountInUSD = editText.getText().toString();
        double amountInUSDDouble = Double.parseDouble(amountInUSD);
        double amountInVNDsDoubles = amountInUSDDouble * 23000;
        String result = String.format("%.2f USD convert to %.2f VND", amountInUSDDouble, amountInVNDsDoubles);
        VNDtextView.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}