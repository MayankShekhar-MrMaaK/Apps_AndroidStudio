package com.example.weatherapp;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        output.setVisibility(View.INVISIBLE);
    }
    public void findWeather(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(input.getWindowToken(), 0);
        try {
            String encodedinput = URLEncoder.encode(input.getText().toString(), "UTF-8");
            DownloadTask task = new DownloadTask();
            task.execute("http://api.weatherstack.com/current?access_key=f501138222a61d9965c675d3b44161af&query="+encodedinput);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Could not find city", Toast.LENGTH_SHORT).show();
        }
    }
    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(strings[0]);
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
            }
            return "";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                String message = "";
                JSONObject jsonObject = new JSONObject(s);
                String weatherInfo = jsonObject.getString("current");
                JSONObject kj = new JSONObject(weatherInfo);
                String temp=kj.getString("temperature");
                String des=kj.getString("weather_descriptions");
                String spe=kj.getString("wind_speed");
                    if (!temp.isEmpty() && !des.isEmpty() && !spe.isEmpty()) {
                        message += "TEMPERATURE : "+temp + "°C\n\nDESCRIPTION : " + des + "\n\nWIND SPEED : "  +spe;
                        output.setVisibility(View.VISIBLE);
                        output.setText(message);

                } else {
                        output.setVisibility(View.VISIBLE);
                        output.setText("Could not find city");
                    Toast.makeText(getBaseContext(), "Could not find city", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}