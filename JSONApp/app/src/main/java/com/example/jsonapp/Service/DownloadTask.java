package com.example.jsonapp.Service;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void,String>
{
    @Override
    protected String doInBackground(String... urls) {

        String result = "";

        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream in = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            Log.i("Download COntent", "download");

            int data = reader.read();

            while (data != -1) {

                char current = (char) data;
                result += current;
                data = reader.read();
            }
            Log.i("Website", result);
            return result;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        String weather = "";

        try {
            JSONObject object = new JSONObject(result);
             weather = object.getString("weather");

            JSONArray array = new JSONArray(weather);

            for(int i = 0; i < array.length(); i++) {
                JSONObject part = array.getJSONObject(i);

                String partWeather = part.getString("description");
                Log.i("Content",partWeather);

                String main = part.getString("main");
                Log.i("Content",main);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("Website Content", weather);

    }
}
