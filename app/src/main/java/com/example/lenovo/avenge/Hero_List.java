package com.example.lenovo.avenge;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class Hero_List extends AppCompatActivity implements View.OnClickListener {
MediaPlayer song2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero__list);

        song2 = MediaPlayer.create(Hero_List.this,R.raw.theme_song_2);
        song2.start();

        ImageView captain_america = (ImageView) findViewById(R.id.captain_america);
        ImageView iron_man = (ImageView) findViewById(R.id.iron_man);
        ImageView hulk = (ImageView) findViewById(R.id.hulk);
        ImageView guardians = (ImageView) findViewById(R.id.guardians);
        ImageView black_widow = (ImageView) findViewById(R.id.black_widow);
        ImageView doctor_strange = (ImageView) findViewById(R.id.doctor_strange);
        ImageView thor = (ImageView) findViewById(R.id.thor);
       // ImageView wanda = (ImageView) findViewById(R.id.wanda);
       // ImageView vision = (ImageView) findViewById(R.id.vision);
        ImageView spider = (ImageView) findViewById(R.id.spider);

        captain_america.setOnClickListener(this);
        iron_man.setOnClickListener(this);
        hulk.setOnClickListener(this);
        guardians.setOnClickListener(this);
        black_widow.setOnClickListener(this);
        doctor_strange.setOnClickListener(this);
        thor.setOnClickListener(this);
      //  wanda.setOnClickListener(this);
      //  vision.setOnClickListener(this);
        spider.setOnClickListener(this);

        LayoutInflater lf = getLayoutInflater();
        View toast_layout = lf.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_layoutID));
        Toast toast1 = makeText(this,"Toast:Gravity.TOP",Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER,0,0);
        toast1.setView(toast_layout);
        toast1.show();

    }

    @Override
    public void onClick(View view) {

        Intent in = new Intent(this,Quiz.class);
        switch (view.getId())
        {
            case R.id.captain_america:
                in.putExtra("hero_name","1");
                break;

            case R.id.iron_man:
                in.putExtra("hero_name","2");
                break;

            case R.id.hulk:
                in.putExtra("hero_name","3");
                break;

            case R.id.spider:
                in.putExtra("hero_name","4");
                break;

            case R.id.thor:
                in.putExtra("hero_name","5");
                break;

            case R.id.doctor_strange:
                in.putExtra("hero_name","6");
                break;

            case R.id.black_widow:
                in.putExtra("hero_name","7");
                break;

            case R.id.guardians:
                in.putExtra("hero_name","8");
                break;

        }
        startActivity(in);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        song2.release();
    }

}

