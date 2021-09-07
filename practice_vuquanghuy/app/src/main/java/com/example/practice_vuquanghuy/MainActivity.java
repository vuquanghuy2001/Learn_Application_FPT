package com.example.practice_vuquanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.tempTview);
    }

    public void getWeather(View view) {
        try {
            DownloadTask task = new DownloadTask();
            String encodedCityName = URLEncoder.encode(editText.getText().toString(), "UTF-8");
            String urlRequest = "http://api.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=10245033e62d1abecf551e5cf8265891";
            task.execute(urlRequest);
            Log.i("URL Request", urlRequest);
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONObject jsonMain = jsonObject.getJSONObject("main");
                double temp = jsonMain.getDouble("temp") - 273.15;
                double feelsLike = jsonMain.getDouble("feels_like") - 273.15;
                float pressure = jsonMain.getInt("pressure");
                int humidity = jsonMain.getInt("humidity");
                double tempMin = jsonMain.getDouble("temp_min")- 273.15;
                double tempMax = jsonMain.getDouble("temp_max")- 273.15;
                Log.i("weatherInfo " , String.valueOf(temp));

                if(!jsonMain.equals("")){
                    tempTview.setText("Temp: " + temp + "°C" );
                    feelsLikeTview.setText("Feel like:"+ feelsLike + "°C");
                    tempMinTview.setText("Temp Min: " + tempMin + "°C");
                    tempMaxTview.setText("Temp Max: " + tempMax + "°C");
                    pressureTview.setText("Pressure: " + pressure + "Hpa");
                    humidityTview.setText("Tumidity: " + humidity + "%");
                } else {
                    Toast.makeText(getApplicationContext(), "Could not find weather :(", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Could not find weather :(", Toast.LENGTH_SHORT).show();
            }
        }
    }
}