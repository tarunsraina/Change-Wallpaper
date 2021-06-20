package com.tarun.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int[] imgArray=new int[]{
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3
    };


    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.buttonwall);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Timer().schedule(new changeWall(),0,30000);


            }
        });

    }
    class changeWall extends TimerTask{

        @Override
        public void run() {
            WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
            try{
                wallpaperManager.setBitmap( BitmapFactory.decodeResource(getResources(),imgArray[i]));
                i++;
                if(i==3){
                    i=0;
                }
            }
            catch(IOException e){
               e.printStackTrace();
            }

        }
    }
}