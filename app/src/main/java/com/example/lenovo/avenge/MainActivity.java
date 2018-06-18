package com.example.lenovo.avenge;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
MediaPlayer aven_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageButton next1 = (ImageButton) findViewById(R.id.hero_list_button);
       aven_theme = MediaPlayer.create(MainActivity.this,R.raw.avengers_theme_song);
       aven_theme.start();
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent in = new Intent(MainActivity.this,Hero_List.class);
                    startActivity(in);
                }
            }
        };
timer.start();


    //public void next(View v)
    //{


    //}

}

    @Override
    protected void onPause() {
        super.onPause();
        aven_theme.release();
        finish();
    }


}