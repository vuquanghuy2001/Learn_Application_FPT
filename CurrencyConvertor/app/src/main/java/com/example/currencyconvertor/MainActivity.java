package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamt);


        String[] from = {"USD"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Indian Rupees","Srilankan Rupees"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);


        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;

                Double amt = Double.parseDouble(ed1.getText().toString());

                if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "Indian Rupees")
                {
                    tot = amt * 70.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "Srilankan Rupees")
                {
                    tot = amt * 179.0;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}