package com.example.guessthecelebrity.Service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class ImageDownloader extends AsyncTask<String, Void, Bitmap>
{
    @Override
    protected Bitmap doInBackground(String... urls) {

        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream in = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(in);

            return myBitmap;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
