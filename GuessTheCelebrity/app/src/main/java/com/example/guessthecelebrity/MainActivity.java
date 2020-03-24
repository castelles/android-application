package com.example.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.guessthecelebrity.Service.DownloadService;
import com.example.guessthecelebrity.Service.ImageDownloader;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadService task = new DownloadService();
        ImageDownloader imageTask = new ImageDownloader();

        Bitmap celebImage;

        // BLOCO TRY É NECESSÁRIO PQ A TAREFA É EXECUTADA EM OUTRA THREAD
        try {
            String result = task.execute("http://www.posh24.se/kandisar").get();
            Log.i("Resultado #INFO", result);

            celebImage = imageTask.execute("...........").get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
